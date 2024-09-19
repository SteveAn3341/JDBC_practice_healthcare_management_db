package healthcare.runner;
import java.sql.*;
import healthcare.dao.DoctorDao;
import healthcare.model.Doctor;
import java.util.Scanner;

public class ManageDoctor {
    public static void manageDoctors(DoctorDao doctorDAO, Scanner scanner) throws SQLException {
        System.out.println("1. Create Doctor");
        System.out.println("2. Read Doctor");
        System.out.println("3. Update Doctor");
        System.out.println("4. Delete Doctor");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Create Doctor
                Doctor newDoctor = new Doctor();
                System.out.print("Enter first name: ");
                newDoctor.setFirstName(scanner.nextLine());
                System.out.print("Enter last name: ");
                newDoctor.setLastName(scanner.nextLine());
                System.out.print("Enter specialty: ");
                newDoctor.setSpecialty(scanner.nextLine());
                System.out.print("Enter email: ");
                newDoctor.setEmail(scanner.nextLine());
                doctorDAO.createDoctor(newDoctor);
                System.out.println("Doctor created successfully.");
                break;
            case 2:
                // Read Doctor
                System.out.print("Enter Doctor ID: ");
                int doctorId = scanner.nextInt();
                Doctor doctor = doctorDAO.getDoctorById(doctorId);
                if (doctor != null) {
                    System.out.println("Doctor ID: " + doctor.getDoctorId());
                    System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName());
                    System.out.println("Specialty: " + doctor.getSpecialty());
                    System.out.println("Email: " + doctor.getEmail());
                } else {
                    System.out.println("Doctor not found.");
                }
                break;
            case 3:
                // Update Doctor
                System.out.print("Enter Doctor ID: ");
                doctorId = scanner.nextInt();
                scanner.nextLine();
                doctor = doctorDAO.getDoctorById(doctorId);
                if (doctor != null) {
                    System.out.print("Enter new first name: ");
                    doctor.setFirstName(scanner.nextLine());
                    System.out.print("Enter new last name: ");
                    doctor.setLastName(scanner.nextLine());
                    System.out.print("Enter new specialty: ");
                    doctor.setSpecialty(scanner.nextLine());
                    System.out.print("Enter new email: ");
                    doctor.setEmail(scanner.nextLine());
                    doctorDAO.updateDoctor(doctor);
                    System.out.println("Doctor updated successfully.");
                } else {
                    System.out.println("Doctor not found.");
                }
                break;
            case 4:
                // Delete Doctor
                System.out.print("Enter Doctor ID: ");
                doctorId = scanner.nextInt();
                doctorDAO.deleteDoctor(doctorId);
                System.out.println("Doctor deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
