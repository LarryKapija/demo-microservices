package com.demo.op.util;

import com.demo.op.data.entity.interfaces.Notificable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificationsUtils {

    @Value("${notifications.mail}")
    private boolean isCorreoEnabled;
    @Value("${notifications.sms}")
    private boolean isSmsEnabled;
    @Autowired
    SmsUtils smsUtils;
    @Autowired
    MailUtils mailUtils;

    public void enviarNotificacion(Notificable notificable, String mensaje) {
        if(isSmsEnabled && notificable.getTelefono()!=null)
            smsUtils.enviarSms(notificable.getTelefono(), mensaje);
        if(isCorreoEnabled && notificable.getCorreo()!=null)
            mailUtils.enviarCorreo(notificable.getCorreo(), mensaje);
    }
}
