package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {

    public  static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Bienvenido a la app de citas medicas");
        System.out.println("Selecciona la opción deseada");

        int response = 0;

        do{
            System.out.println("1. Doctor");
            System.out.println("2. Paciente");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);

                    break;
                case 2:
                    response =0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Gracias por tu visita!");
                    break;
                default:
                    System.out.println("Porfavor selecciones un dato correcto!");
            }
        }while (response!=0);
    }

    static void showPatienMenu(){
        int response = 0;

        do{
            System.out.println("\n\n");
            System.out.println("Seccion Pacientes");
            System.out.println("1. Lista de citas");
            System.out.println("2. mis citas");
            System.out.println("0. regresar");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Libro de citas");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(i+". "+MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::Mis citas");
                    break;
                case 0:
                    showMenu();
                    break;

            }
        }while (response !=0);
    }
    private static void authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Jaime Sanez", "jaimes@mail.com"));
        doctors.add(new Doctor("Karen Sosa", "ks@mail.com"));
        doctors.add(new Doctor("Jose Agudelo", "ja@mail.com"));

        ArrayList<Patient> patiens = new ArrayList<>();
        patiens.add(new Patient("Harold Garcia", "hg@mail.com"));
        patiens.add(new Patient("Sofia Garcia", "sg@mail.com"));
        patiens.add(new Patient("Carol Lombana", "cl@mail.com"));

        boolean emailCorret = false;
        do{
            System.out.println("Ingrese su email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType ==1){
                for (Doctor d: doctors){
                    if(d.getEmail().equals(email)){
                        emailCorret = true;
                        //Obtener el usuario logeado
                        doctorLogged = d;
                        UIDoctorMenu.showDoctorMenu();

                    }
                }

            }
            if(userType ==2){
                for(Patient p: patiens){
                    if(p.getEmail().equals(email)){
                        emailCorret = true;
                        patientLogged =p;
                        UIPatientMenu.showpatientMenu();

                    }
                }
            }

        }while (!emailCorret);
    }
}
