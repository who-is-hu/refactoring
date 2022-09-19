package me.whiteship.refactoring._21_alternative_classes_with_different_interfaces;

public class AlertNotificationService implements NotificationService {
    private AlertService alertService;

    public AlertNotificationService(AlertService alertService) {
        this.alertService = alertService;
    }

    @Override
    public void send(Notification notification) {
        AlertMessage alertMessage = new AlertMessage();
        alertMessage.setMessage(notification.getTitle());
        alertMessage.setFor(notification.getReceiver());
        alertService.add(alertMessage);
    }
}
