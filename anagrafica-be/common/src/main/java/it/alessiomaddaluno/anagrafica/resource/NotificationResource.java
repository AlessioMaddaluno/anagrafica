package it.alessiomaddaluno.anagrafica.resource;

import it.alessiomaddaluno.anagrafica.enums.NotificationType;

public class NotificationResource {
    private String notificationMessage;
    private NotificationType type;

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
