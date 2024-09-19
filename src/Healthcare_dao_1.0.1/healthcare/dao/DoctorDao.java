package healthcare.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import healthcare.jdbc.DatabaseConnection;
import healthcare.model.Doctor;
public class DoctorDao {


    public void createDoctor(Doctor doctor) throws SQLException {
        String query = "insert into doctor values(?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, doctor.getDoctorId());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getSpecialty());
            ps.setString(5, doctor.getEmail());
            ps.executeUpdate();
        }
    }

    public Doctor getDoctorById(int doctorId) {
        String query = "select * from doctors where doctorId = ?";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Doctor(
                        rs.getInt("doctorId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("specialty"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void updateDoctor(Doctor doctor) throws SQLException {
        String query = "UPDATE Doctors SET firstName = ?, lastName = ?, specialty = ?, email = ? WHERE doctorId = ?";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setString(3, doctor.getSpecialty());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getDoctorId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteDoctor(int doctorid) throws SQLException {
        String query = "delete from doctors where doctorId = ?";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, doctorid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public List<Doctor> getAllDoctors() throws SQLException {
        String query = "select * from doctors";
        List<Doctor> doctors = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor(
                        rs.getInt("doctorId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("specialty"),
                        rs.getString("email")
                );
                doctors.add(doctor);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return doctors;
    }





}




