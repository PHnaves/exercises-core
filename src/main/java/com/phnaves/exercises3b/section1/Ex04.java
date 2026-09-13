package com.phnaves.exercises3b.section1;

interface UserNotification {
    void send(String message);
}

class SendEmail implements UserNotification {

    @Override
    public void send(String message) {
        System.out.println("Send to email: " + message);
    }
}

class SendSms implements UserNotification {

    @Override
    public void send(String message) {
        System.out.println("Send to sms: " + message);
    }
}

class ServiceAlert {
    private final UserNotification userNotification;

    public ServiceAlert(UserNotification userNotification) {
        this.userNotification = userNotification;
    }

    public void alert(String message) {
        userNotification.send(message);
    }
}

public class Ex04 {

    public static void main(String[] args) {

        // Usando a implementação de Email
        UserNotification email = new SendEmail();
        ServiceAlert alertEmail = new ServiceAlert(email);

        alertEmail.alert("Servidor indisponível!");

        // Trocando para SMS
        UserNotification sms = new SendSms();
        ServiceAlert alertSms = new ServiceAlert(sms);

        alertSms.alert("Servidor indisponível!");
    }
}