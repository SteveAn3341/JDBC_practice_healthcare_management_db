package healthcare.runner;

import healthcare.dao.AppointmentDao;
import healthcare.model.Appointment;

import java.sql.SQLException;
import java.util.Scanner;

public class ManageAppointment{

public static void manageAppointments(AppointmentDao appointmentDao, Scanner scanner) throws SQLException {
    System.out.println("1. Create Appointment");
    System.out.println("2. Read Appointment");
    System.out.println("3. Update Appointment");
    System.out.println("4. Delete Appointment");

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
        case 1:
            // Create Appointment
            Appointment newAppointment = new Appointment();
            System.out.print("Enter Patient ID: ");
            newAppointment.setPatientId(scanner.nextInt());
            System.out.print("Enter Doctor ID: ");
            newAppointment.setDoctorId(scanner.nextInt());
            scanner.nextLine();  // consume newline
            System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
            newAppointment.setAppointmentDate(scanner.nextLine());
            System.out.print("Enter Notes: ");
            newAppointment.setNotes(scanner.nextLine());
            appointmentDao.createAppointment(newAppointment);
            System.out.println("Appointment created successfully.");
            break;
        case 2:
            // Read Appointment
            System.out.print("Enter Appointment ID: ");
            int appointmentId = scanner.nextInt();
            Appointment appointment = appointmentDao.getAppointmentById(appointmentId);
            if (appointment != null) {
                System.out.println("Appointment ID: " + appointment.getAppointmentId());
                System.out.println("Patient ID: " + appointment.getPatientId());
                System.out.println("Doctor ID: " + appointment.getDoctorId());
                System.out.println("Date: " + appointment.getAppointmentDate());
                System.out.println("Notes: " + appointment.getNotes());
            } else {
                System.out.println("Appointment not found.");
            }
            break;
        case 3:
            // Update Appointment
            System.out.print("Enter Appointment ID: ");
            appointmentId = scanner.nextInt();
            scanner.nextLine();
            appointment = appointmentDao.getAppointmentById(appointmentId);
            if (appointment != null) {
                System.out.print("Enter new Patient ID: ");
                appointment.setPatientId(scanner.nextInt());
                System.out.print("Enter new Doctor ID: ");
                appointment.setDoctorId(scanner.nextInt());
                scanner.nextLine();  // consume newline
                System.out.print("Enter new Appointment Date (YYYY-MM-DD): ");
                appointment.setAppointmentDate(scanner.nextLine());
                System.out.print("Enter new Notes: ");
                appointment.setNotes(scanner.nextLine());
                appointmentDao.updateAppointment(appointment);
                System.out.println("Appointment updated successfully.");
            } else {
                System.out.println("Appointment not found.");
            }
            break;
        case 4:
            // Delete Appointment
            System.out.print("Enter Appointment ID: ");
            appointmentId = scanner.nextInt();
            appointmentDao.deleteAppointment(appointmentId);
            System.out.println("Appointment deleted successfully.");
            break;
        default:
            System.out.println("Invalid choice.");
    }
}
}
