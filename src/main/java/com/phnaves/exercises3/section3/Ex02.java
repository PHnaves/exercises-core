package com.phnaves.exercises3.section3;

class Employee {
    private String cpf;

    public Employee(String cpf) {
        this.cpf = cpf;
    }
}

class Manager extends Employee {
    private String sector;

    public Manager(String cpf, String sector) {
        super(cpf);
        this.sector = sector;
    }
}

class Director extends Manager{
    private String profile;

    public Director(String cpf, String sector, String profile) {
        super(cpf, sector);
        this.profile = profile;
    }
}

public class Ex02 {
    public static void main(String[] args) {

    }
}
