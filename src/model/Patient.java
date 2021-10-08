package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{
    //Atributos
    private String birthday;
    private double weight;
    private double heigth;
    private String blood;

    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses= new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);

    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    public Patient(String name, String email){
        super(name, email);
    }

    public String getWeight(){
        return this.weight + " Kg.";
    }

    public void setWeight(double weight){
        this.weight = weight;

    }

    public String getHeigth() {
        return heigth + " Mts.";
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString()+"\n\nPaciente" +
                "\nCumpleaños: " + birthday  +
                "\nPeso: " + getWeight() +
                "\nEstatura: " + getHeigth()+
                "\nTipo sangre: " + blood ;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo del paciente");
    }
}
