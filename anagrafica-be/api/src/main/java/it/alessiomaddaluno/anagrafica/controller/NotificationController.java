package it.alessiomaddaluno.anagrafica.controller;

import it.alessiomaddaluno.anagrafica.dto.NotificationDTO;
import it.alessiomaddaluno.anagrafica.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("global")
    public void global(@RequestBody NotificationDTO notificationDTO) {
        this.notificationService.globalNotification(notificationDTO);
    }

}
