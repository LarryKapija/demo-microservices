package com.demo.op.service.security;

import com.demo.op.data.UserRepository;
import com.demo.op.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String telefono) throws UsernameNotFoundException {
        User user = userRepository.findByTelefono(telefono)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontro el usuario con el telefono: " + telefono));
        return UserDetailsImpl.build(user);
    }
}
