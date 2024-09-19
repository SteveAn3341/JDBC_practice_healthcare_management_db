package healthcare.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import healthcare.jdbc.DatabaseConnection;
import healthcare.model.Appointment;

public class AppointmentDao {

    public void  createAppointment(Appointment appointment) throws SQLException {
        String query = "Insert into Appointment values(?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,appointment.getAppointmentId());
            ps.setInt(2,appointment.getPatientId());
            ps.setInt(3,appointment.getDoctorId());
            ps.setString(4,appointment.getAppointmentDate());
            ps.setString(5,appointment.getNotes());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Appointment getAppointmentById (int appointmentId)throws SQLException {
        String query = "select * from Appointment where AppointmentId = ?";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Appointment(
                        rs.getInt("AppointmentId"),
                        rs.getInt("PatientId"),
                        rs.getInt("DoctorId"),
                        rs.getString("AppointmentDate"),
                        rs.getString("Notes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };

public void updateAppointment(Appointment appointment) throws SQLException {
    String query = "UPDATE Doctors SET doctorId = ?,  PatientId = ?, DoctorId = ? , AppointmentDate = ?, Notes = ? WHERE AppointmentId = ?";
    try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
    ps.setInt(1,appointment.getAppointmentId());
    ps.setInt(2,appointment.getPatientId());
    ps.setInt(3,appointment.getDoctorId());
    ps.setString(4,appointment.getAppointmentDate());
    ps.setString(5,appointment.getNotes());
}
catch (SQLException e) {
    e.printStackTrace();
}
}



public void deleteAppointment(int appointmentId) throws SQLException {
    String query = "DELETE FROM Appointment WHERE AppointmentId = ?";
    try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setInt(1,appointmentId);
        ps.executeUpdate();
    }catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Appointment> getAllAppointments()throws SQLException{
    String query = "select * from Appointment";
    List <Appointment> appointments = new ArrayList<>();
    try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Appointment appointment = new Appointment(
                    rs.getInt("AppointmentId"),
                    rs.getInt("PatientId"),
                    rs.getInt("DoctorId"),
                    rs.getString("AppointmentDate"),
                    rs.getString("Notes")
            );
            appointments.add(appointment);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    return appointments;

}




    }

