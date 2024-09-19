# Healthcare_dao_1.0.1
Practice project to increase your skills using jdbc/dao

---

### **Ticket Breakdown: Healthcare Management System**

**Project Starter Code:**
- You have been provided with the starter code that includes the following:
  - `DatabaseConnection` class for establishing connections to the database.
  - `Patient` model class and `PatientDAO` for managing patient data.
  - Basic setup of the `HealthcareManagementApp` with CRUD functionality for patients.

---

### **Ticket 1: Implement Doctor Class and DoctorDAO**

- **Description:** Implement the `Doctor` class and `DoctorDAO` to manage doctor-related data.

- **Tasks:**
  1. **Create `Doctor` Model Class:**
     - Create a new class named `Doctor` in the `com.healthcaremanagement.model` package.
     - The class should have the following attributes:
       - `int doctorId`: Represents the unique identifier for each doctor.
       - `String firstName`: The first name of the doctor.
       - `String lastName`: The last name of the doctor.
       - `String specialty`: The doctor's area of specialization (e.g., Cardiology, Pediatrics).
       - `String email`: The doctor's email address.
     - Implement getters and setters for each attribute to allow access and modification of the values.

  2. **Implement `DoctorDAO`:**
     - Create a new class named `DoctorDAO` in the `com.healthcaremanagement.dao` package.
     - Implement the following methods:
       - `void createDoctor(Doctor doctor)`: Inserts a new doctor into the `Doctors` table. Use `INSERT INTO` SQL statements.
       - `Doctor getDoctorById(int doctorId)`: Retrieves a doctor from the database based on the given ID using a `SELECT` statement.
       - `void updateDoctor(Doctor doctor)`: Updates existing doctor details in the `Doctors` table using an `UPDATE` statement.
       - `void deleteDoctor(int doctorId)`: Deletes a doctor from the `Doctors` table based on the given ID using a `DELETE` statement.
       - `List<Doctor> getAllDoctors()`: Retrieves a list of all doctors from the database using a `SELECT` statement.

  3. **Test the Doctor Functionality:**
     - Write simple test cases or use the console to:
       - Create a new doctor record.
       - Retrieve a doctor by ID.
       - Update a doctor’s details.
       - Delete a doctor.
       - Retrieve all doctors.
     - Ensure that the `DoctorDAO` methods interact correctly with the database and perform the expected operations.

---

### **Ticket 2: Implement Appointment Class and AppointmentDAO**

- **Description:** Implement the `Appointment` class and `AppointmentDAO` to manage appointment-related data.

- **Tasks:**
  1. **Create `Appointment` Model Class:**
     - Create a new class named `Appointment` in the `com.healthcaremanagement.model` package.
     - The class should have the following attributes:
       - `int appointmentId`: Represents the unique identifier for each appointment.
       - `int patientId`: The ID of the patient who has the appointment.
       - `int doctorId`: The ID of the doctor who will see the patient.
       - `String appointmentDate`: The date and time of the appointment in the format `YYYY-MM-DD`.
       - `String notes`: Any notes related to the appointment.
     - Implement getters and setters for each attribute to allow access and modification of the values.

  2. **Implement `AppointmentDAO`:**
     - Create a new class named `AppointmentDAO` in the `com.healthcaremanagement.dao` package.
     - Implement the following methods:
       - `void createAppointment(Appointment appointment)`: Inserts a new appointment into the `Appointments` table. Use `INSERT INTO` SQL statements.
       - `Appointment getAppointmentById(int appointmentId)`: Retrieves an appointment from the database based on the given ID using a `SELECT` statement.
       - `void updateAppointment(Appointment appointment)`: Updates existing appointment details in the `Appointments` table using an `UPDATE` statement.
       - `void deleteAppointment(int appointmentId)`: Deletes an appointment from the `Appointments` table based on the given ID using a `DELETE` statement.
       - `List<Appointment> getAllAppointments()`: Retrieves a list of all appointments from the database using a `SELECT` statement.

  3. **Test the Appointment Functionality:**
     - Write simple test cases or use the console to:
       - Create a new appointment record.
       - Retrieve an appointment by ID.
       - Update an appointment’s details.
       - Delete an appointment.
       - Retrieve all appointments.
     - Ensure that the `AppointmentDAO` methods interact correctly with the database and perform the expected operations.

---

### **Ticket 3: Refactor HealthcareManagementApp to Include Doctors and Appointments**

- **Description:** Refactor the `HealthcareManagementApp` class to include options for managing doctors and appointments in addition to patients.

- **Tasks:**
  1. **Update the Main Menu:**
     - In the `HealthcareManagementApp` class, update the main menu to include options for managing doctors and appointments. 
     - The menu should display options like:
       ```
       1. Manage Patients
       2. Manage Doctors
       3. Manage Appointments
       ```

  2. **Implement `manageDoctors()` Method:**
     - Add a new method `private static void manageDoctors(DoctorDAO doctorDAO, Scanner scanner)` that will handle CRUD operations for doctors.
     - Use the structure provided in the existing `managePatients()` method as a guide.
     - The method should include a sub-menu that allows the user to:
       - Create a new doctor.
       - Read a doctor’s details by ID.
       - Update a doctor’s details.
       - Delete a doctor by ID.

  3. **Implement `manageAppointments()` Method:**
     - Add a new method `private static void manageAppointments(AppointmentDAO appointmentDAO, Scanner scanner)` that will handle CRUD operations for appointments.
     - The structure should follow the same pattern as `managePatients()` and `manageDoctors()`.
     - The method should include a sub-menu that allows the user to:
       - Create a new appointment.
       - Read an appointment’s details by ID.
       - Update an appointment’s details.
       - Delete an appointment by ID.

  4. **Integrate the New Methods:**
     - In the main `switch` statement inside the `main` method, integrate the new `manageDoctors()` and `manageAppointments()` methods so they are invoked based on the user's menu choice.
     - Ensure that selecting “2” from the main menu navigates to the doctor management sub-menu, and selecting “3” navigates to the appointment management sub-menu.

  5. **Testing and Debugging:**
     - Run the application and test each menu option to ensure they navigate correctly to the sub-menus.
     - Test creating, reading, updating, and deleting records for all three entities (patients, doctors, and appointments).
     - Debug any issues that arise during testing, ensuring that all CRUD operations are fully functional.

---
