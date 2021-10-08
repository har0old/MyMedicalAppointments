package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointment = new ArrayList<>();
    public  static void showDoctorMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Bienvenido " + UiMenu.doctorLogged.getName());
            System.out.println("1. Agregar citas disponibles ");
            System.out.println("2. programar cita");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 1:
                    showAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UiMenu.showMenu();
            }

        } while (response!=0);
    }

    private static void showAvailableAppointmentsMenu(){
        int response =0;
        do{
            System.out.println();
            System.out.println("::Agregar citas disponibles");
            System.out.println(":: Seleccione un mes");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". "+ UiMenu.MONTHS[i]);
            }
            System.out.println("0. Regresar");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                int monthSlected = response;
                System.out.println(monthSlected +" . "+ UiMenu.MONTHS[monthSlected-1]);

                System.out.println("Ingresa la fecha disponible: [dd/mm/aaaa]");
                String date = sc.nextLine();

                System.out.println("la fecha seleccionada es: "+date + "\n1.Correcto \n2.Cambiar");
                int responseDate = Integer.valueOf(sc.nextLine());
                if(responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Ingrese la hora de la cita para la fecha asiganada: "+ date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("La hora seleccionada es: "+time+"\n1.Correcto \n2.Cambiar");
                    responseTime = Integer.valueOf(sc.nextLine());

                }while (responseTime ==2);

                UiMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppoints(UiMenu.doctorLogged);

            }else if (response ==0){
                showDoctorMenu();
            }

        }while (response !=0);
    }

    private static void checkDoctorAvailableAppoints(Doctor doctor){
        if (doctor.getAvailableAppointments().size()>0 && !doctorsAvailableAppointment.contains(doctor)){
            doctorsAvailableAppointment.add(doctor);
        }
    }
}
