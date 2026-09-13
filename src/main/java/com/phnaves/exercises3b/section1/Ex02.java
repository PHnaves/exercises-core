package com.phnaves.exercises3b.section1;

interface Logs {
    void log();
}

interface Audits {
    void audit();
}

class ServiceNotify implements Logs, Audits {
    private String user;

    public ServiceNotify(String user) {
        this.user = user;
        this.log();
    }

    @Override
    public void log() {
        System.out.println("Access registered!");
        audit();
    }

    @Override
    public void audit() {
        System.out.println("THis user " + this.user + " identify");
    }
}

public class Ex02 {
    public static void main(String[] args) {
        ServiceNotify serviceNotify = new ServiceNotify("Pedro Naves");
    }
}
