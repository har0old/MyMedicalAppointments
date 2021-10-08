package ui;

import model.Doctor;
import sun.reflect.generics.tree.Tree;

import javax.print.Doc;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showpatientMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Paciente");
            System.out.println("bienvenido "+UiMenu.patientLogged.getName());
            System.out.println("1. Agendar una cita");
            System.out.println("2. Mi Agendamiento");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
            }

        }while(response !=0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("::Agendar una cita");
            System.out.println("::Selecciona una fecha: ");
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointment.size(); i++) {
                ArrayList<Doctor.AvailableAppointment>availableAppointments
                        =UIDoctorMenu.doctorsAvailableAppointment.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". "+ availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvailableAppointment.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer,Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");
            for (Map.Entry<Integer, Doctor> doc :doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName()+
                    ". Fecha: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate()+
                    ". Hora: "+
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirme su agendamiento: \n1. Correcto \n2. Cambiar datos ");
            response = Integer.valueOf(sc.nextLine());

            if (response ==1){
                UiMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            }




        }while(response !=0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do{
            System.out.println("..MY Agendamiento");
            if(UiMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("No tienes citas agendades");
                break;
            }
            for (int i = 0; i < UiMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i +1;
                System.out.println(j+". "+
                        "Fecha: "+
                        UiMenu.patientLogged.getAppointmentDoctors().get(i).getDate()+
                        " Hora: "+ UiMenu.patientLogged.getAppointmentDoctors().get(i).getTime()+
                        "\n Doctor: "+UiMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor());
            }
            System.out.println("0. Retornar");
        }while (response!=0);
    }
}
