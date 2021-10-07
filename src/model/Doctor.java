package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Atributo
    private String speciality;

    //metodo constructor inicializado
    public Doctor(String name, String email){
        super(name, email);
        System.out.println("El nombre del doctor asignado es: "+name);
        this.speciality = speciality;

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //coportamientos o metodos
    ArrayList<AvailableAppointment>availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(Date date, String time){
    availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }
    public ArrayList<AvailableAppointment>getAvailableAppointments(){
        return availableAppointments;
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time){
            this.date = date;
            this.time = time;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "\nListado de fechas disponibles:" +
                    "\nCalendario: " + date +
                    "\nHora: " + time;
        }
    }

    @Override
    public String toString() {
        return "model.Doctor{" +
                "speciality='" + speciality + '\'' +
                ", availableAppointments=" + availableAppointments+
                "} " + super.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital Departamental");
        System.out.println("Departamento: Cancerologia");
    }
}

