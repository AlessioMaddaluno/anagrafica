package it.alessiomaddaluno.anagrafica.controller;

import it.alessiomaddaluno.anagrafica.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("test")
    public void test(){
        this.notificationService.notifyTest();
    }

}
