package healthcare;

import healthcare.dao.PatientDAO;
import healthcare.model.Patient;
import healthcare.runner.*;
import java.sql.SQLException;
import java.util.Scanner;
import healthcare.dao.AppointmentDao;
import healthcare.dao.DoctorDao;
import healthcare.model.Appointment;
import healthcare.model.Doctor;
import healthcare.jdbc.DatabaseConnection;
public class Main {


    public static void main(String[] args) throws SQLException {

        PatientDAO patientDAO = new PatientDAO();
        DoctorDao doctorDAO = new DoctorDao();  // Add doctorDAO
        AppointmentDao appointmentDAO = new AppointmentDao();  // Add appointmentDAO
        Scanner scanner = new Scanner(System.in);

        // Main menu
        System.out.println("1. Manage Doctors");
        System.out.println("2. Manage Appointments");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case 1:
                    ManageDoctor.manageDoctors(doctorDAO, scanner);  // New case for doctors
                    break;
                case 2:
                    ManageAppointment.manageAppointments(appointmentDAO, scanner);  // New case for appointments
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}


