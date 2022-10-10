package com.demo.op.rest;

import com.demo.op.api.AuthApi;
import com.demo.op.data.RegistrationRequestRepository;
import com.demo.op.data.RoleRepository;
import com.demo.op.data.UserRepository;
import com.demo.op.data.entity.RegistrationRequest;
import com.demo.op.data.entity.Role;
import com.demo.op.data.entity.User;
import com.demo.op.model.*;
import com.demo.op.util.SmsUtils;
import com.demo.op.util.exception.CampoInvalidoException;
import com.demo.op.util.exception.NoEncontradoException;
import com.demo.op.util.exception.RequestInvalidoException;
import com.demo.op.util.model.Notificaciones;
import com.demo.op.util.model.RoleEnum;
import com.demo.op.util.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AuthRestController implements AuthApi {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegistrationRequestRepository solicitudRegistroRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private SmsUtils smsUtils;

    @Override
    public ResponseEntity<JwtResponseDTO> authenticateUser(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByTelefono(loginRequestDTO.getUsername())
                .orElseThrow(() -> new NoEncontradoException("Telefono no registrado"));
        String jwt = generateJwt(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        /*
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        */
        return ResponseEntity.ok(new JwtResponseDTO()
                .value(new JwtDTO()
                        .token(jwt)
                        .nombre(user.getNombre())
                        .apellido(user.getApellido())));
    }

    @Override
    public ResponseEntity<RegistroResponseDTO> registerUser(RegisterRequestDTO registroRequestDTO) {
        if(Objects.isNull(registroRequestDTO.getTelefono()))
            throw new CampoInvalidoException("telefono","No puede estar en blanco");
        if(Objects.isNull(registroRequestDTO.getNombre()))
            throw new CampoInvalidoException("nombre","No puede estar en blanco");
        if(Objects.isNull(registroRequestDTO.getApellido()))
            throw new CampoInvalidoException("apellido","No puede estar en blanco");

        if (userRepository.existsByTelefono(registroRequestDTO.getTelefono()))
            throw new CampoInvalidoException("telefono","Ya se encuentra registrado");

        solicitudRegistroRepository.findByTelefono(registroRequestDTO.getTelefono())
                .ifPresent(solicitudRegistroRepository::delete);

        RegistrationRequest solicitudRegistro = RegistrationRequest.builder()
                .telefono(registroRequestDTO.getTelefono())
                .nombre(registroRequestDTO.getNombre())
                .apellido(registroRequestDTO.getApellido())
                .correo(registroRequestDTO.getCorreo())
                .otp(generateOTP().toString())
                .build();

        solicitudRegistro = solicitudRegistroRepository.save(solicitudRegistro);
        smsUtils.enviarSms(solicitudRegistro.getTelefono(), Notificaciones.REGISTRO_OTP + solicitudRegistro.getOtp());

        RegisterConfirmationDTO confirmacionRegistro = new RegisterConfirmationDTO()
                .solicitud(solicitudRegistro.getTelefono());
        return ResponseEntity.ok(new RegistroResponseDTO().value(confirmacionRegistro));

    }

    @Override
    public ResponseEntity<EmptyResponseDTO> sendPhoneOTP(ValidatePhoneRequestDTO validatePhoneRequestDTO) {
        User user = userRepository.findByTelefono(validatePhoneRequestDTO.getPhone())
                .orElseThrow(() -> new NoEncontradoException("Telefono no registrado"));

        user.setPassword(generateOTP().toString());
        userRepository.save(user);
        smsUtils.enviarSms(user.getTelefono(), Notificaciones.REGISTRO_OTP + user.getPassword());
        return ResponseEntity.ok(new EmptyResponseDTO());
    }

    @Override
    public ResponseEntity<JwtResponseDTO> validateOTP(RegisterConfirmationRequestDTO confirmacionRegistroRequestDTO) {
        RegistrationRequest solicitudRegistro = solicitudRegistroRepository.findByTelefono(confirmacionRegistroRequestDTO.getSolicitud())
                .orElseThrow(() -> new RequestInvalidoException("Codigo de solicitud invalido"));

        if(!solicitudRegistro.getOtp().equals(confirmacionRegistroRequestDTO.getOneTimePassword()))
            throw new RequestInvalidoException("OTP invalido");

        User user = User.builder()
                .telefono(solicitudRegistro.getTelefono())
                .nombre(solicitudRegistro.getNombre())
                .apellido(solicitudRegistro.getApellido())
                .password(confirmacionRegistroRequestDTO.getOneTimePassword())
                .correo(solicitudRegistro.getCorreo())
                .build();

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleEnum.ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Error: Role no encontrado!"));
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
        solicitudRegistroRepository.delete(solicitudRegistro);

        return ResponseEntity.ok(new JwtResponseDTO()
                .value(new JwtDTO()
                        .token(generateJwt(user.getTelefono(), user.getPassword()))
                        .nombre(user.getNombre())
                        .apellido(user.getApellido())));
    }

    private String generateJwt(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtils.generateJwtToken(authentication);
    }

    private Integer generateOTP(){
        Random random = new Random();
        return random.nextInt(899999)+100000;
    }
}
