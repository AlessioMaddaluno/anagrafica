package it.alessiomaddaluno.anagrafica.service;

import it.alessiomaddaluno.anagrafica.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void globalNotification(NotificationDTO dto){
        messagingTemplate.convertAndSend("push-notifications",dto);
    }


}
