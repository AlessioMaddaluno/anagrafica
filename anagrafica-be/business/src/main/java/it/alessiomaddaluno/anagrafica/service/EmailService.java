package it.alessiomaddaluno.anagrafica.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {

    private Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender emailSender;

    @Value("${email.default-email}")
    private String defaultEmail;

    public void sendSimpleMessage(String to, String subject, String textMessage){
        logger.info("[START] to: %s , subject: %s",to,subject);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(defaultEmail);
        message.setTo(to);
        message.setSentDate(new Date());
        message.setSubject(subject);
        message.setText(textMessage);

        emailSender.send(message);

        logger.info("[END OK] to: %s , subject: %s",to,subject);
    }

}
