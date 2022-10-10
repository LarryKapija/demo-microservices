package com.demo.op.util.javamail;

import com.demo.op.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailUtilsImpl implements MailUtils {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    private final String SUBJECT = "Demo Notificacion";

    public void enviarCorreo(String email, String body) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setSubject(SUBJECT);

            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException e) {
            System.err.println(e.getMessage());
        }
    }
}
