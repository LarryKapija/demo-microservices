package com.demo.op.util.twilio;

import com.demo.op.util.SmsUtils;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SmsUtilsImpl implements SmsUtils {
    @Value("${twilio.accountSid}")
    String accountSid;
    @Value("${twilio.apiToken}")
    String apiToken;
    @Value("${twilio.messagingServiceSid}")
    String messagingServiceSid;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, apiToken);
    }

    public void enviarSms(String telefono, String mensaje) {
        try {
            Message.creator(
                            new com.twilio.type.PhoneNumber(telefono),
                            messagingServiceSid,
                            mensaje)
                    .create();
        }
        catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
