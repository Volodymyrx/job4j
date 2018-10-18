package ru.job4j.working;

public class Doctor extends Profession {

    public void treat(Patient patient) {

    }

    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }

}
