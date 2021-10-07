import model.Doctor;
import model.ISchedulable;
import model.Patient;
import model.User;

import javax.print.Doc;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //showMenu();

    Doctor myDoctor = new Doctor("Carol Lombana", "Pediatra");
    myDoctor.addAvailableAppointment(new Date(), "4pm");
    myDoctor.addAvailableAppointment(new Date(), "10pm");
    myDoctor.addAvailableAppointment(new Date(), "18pm");

        for (Doctor.AvailableAppointment aA:myDoctor.getAvailableAppointments()){
            System.out.println(aA.getDate() +" "+aA.getTime());
        }
    Patient patient = new Patient("sofia garcia", "sofi@mail.com");
        System.out.println(patient);
        Doctor doctor1 = new Doctor("alvaro", "alv@mail.com");
        System.out.println(doctor1);

        System.out.println("----------------------------------------");

        User user = new Doctor("Ana", "pedro");
        user.showDataUser();

        Patient userPA = new Patient("Alberto", "albereto@mail.com");
        userPA.showDataUser();

        User user2 = new User("Alvaro", "alvp@mail.com") {
            @Override
            public void showDataUser() {
                System.out.println("------------------------------");
                System.out.println("Doctor");
                System.out.println("Clinica: Meta");
                System.out.println("Departamento: Urgencias");
            }
        };
    user2.showDataUser();
        ISchedulable iSchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {

            }
        };


    }
}


