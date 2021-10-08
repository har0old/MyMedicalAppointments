package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Atributo
    private String speciality;
    private ArrayList<AvailableAppointment>availableAppointments = new ArrayList<>();
    //metodo constructor inicializado
    public Doctor(String name, String email){
        super(name, email);

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //coportamientos o metodos

    public void addAvailableAppointment(String date, String time){

        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }
    public ArrayList<AvailableAppointment>getAvailableAppointments(){
        return availableAppointments;
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }
        public String getDate() {
            return format.format(date);
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

