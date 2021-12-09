package it.alessiomaddaluno.anagrafica.controller;

import it.alessiomaddaluno.anagrafica.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;


@RestController
@RequestMapping("public/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("test")
    ResponseEntity<Boolean> testEmail() throws MessagingException {
        emailService.sendSimpleMessage("test_user@anagrafica.it", "Email di test", "Hello World!");
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
