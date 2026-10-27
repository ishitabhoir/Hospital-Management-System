import java.sql.*; 
import java.util.Scanner; 
public class HospitalManagementSystem {
static final String URL = "jdbc:mysql://localhost:3306/hospital_db"; static final String USER = "root"; 
static final String PASSWORD = "Root";
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
try { 
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con = DriverManager.getConnection(URL, USER, PASSWORD); int choice; 
do { 
System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM ====="); System.out.println("1. Add Patient"); 
System.out.println("2. Add Doctor"); 
System.out.println("3. Book Appointment"); 
System.out.println("4. Add Billing"); 
System.out.println("5. Add Prescription"); 
System.out.println("6. View Patients"); 
System.out.println("7. View Doctors"); 
System.out.println("8. View Appointments"); 
System.out.println("9. View Billing"); 
System.out.println("10. View Prescriptions"); 
System.out.println("11. Exit"); 
System.out.print("Enter Choice: "); 
choice = sc.nextInt(); 
switch (choice) { 
case 1: 
addPatient(con, sc); 
break; 
case 2: 
addDoctor(con, sc); 
break;
case 3: 
bookAppointment(con, sc); 
break; 
case 4: 
addBilling(con, sc); 
break; 
case 5: 
addPrescription(con, sc); 
break; 
case 6: 
viewPatients(con); 
break; 
case 7: 
viewDoctors(con); 
break; 
case 8: 
viewAppointments(con); 
break; 
case 9: 
viewBilling(con); 
break; 
case 10: 
viewPrescriptions(con); 
break; 
case 11: 
System.out.println("Exiting..."); 
break; 
default: 
System.out.println("Invalid Choice"); } 
} while (choice != 11); 
con.close();
} catch (Exception e) { 
System.out.println(e); 
} 
} 
// ADD PATIENT 
static void addPatient(Connection con, Scanner sc) throws SQLException { sc.nextLine(); 
System.out.print("Enter Name: "); 
String name = sc.nextLine(); 
System.out.print("Enter Age: "); 
int age = sc.nextInt(); 
sc.nextLine(); 
System.out.print("Enter Gender: "); 
String gender = sc.nextLine(); 
System.out.print("Enter Contact: "); 
String contact = sc.nextLine(); 
System.out.print("Enter Medical History: "); 
String history = sc.nextLine(); 
String query = "INSERT INTO patients(name, age, gender, contact, medical_history) VALUES (?, ?, ?, ?, ?)"; 
PreparedStatement pst = con.prepareStatement(query); 
pst.setString(1, name); 
pst.setInt(2, age); 
pst.setString(3, gender); 
pst.setString(4, contact); 
pst.setString(5, history); 
pst.executeUpdate();
System.out.println("Patient Added Successfully!"); 
} 

// ADD DOCTOR 

static void addDoctor(Connection con, Scanner sc) throws SQLException { sc.nextLine(); 
System.out.print("Enter Doctor Name: "); 
String name = sc.nextLine(); 
System.out.print("Enter Specialization: "); 
String specialization = sc.nextLine(); 
System.out.print("Enter Schedule: "); 
String schedule = sc.nextLine(); 
String query = "INSERT INTO doctors(name, specialization, schedule) VALUES (?, ?, ?)"; PreparedStatement pst = con.prepareStatement(query); 
pst.setString(1, name); 
pst.setString(2, specialization); 
pst.setString(3, schedule); 
pst.executeUpdate(); 
System.out.println("Doctor Added Successfully!"); 
} 

// BOOK APPOINTMENT 

static void bookAppointment(Connection con, Scanner sc) throws SQLException { 
System.out.print("Enter Patient ID: "); 
int patientId = sc.nextInt(); 
System.out.print("Enter Doctor ID: "); 
int doctorId = sc.nextInt();
sc.nextLine(); 
System.out.print("Enter Appointment Date (YYYY-MM-DD): "); 
String date = sc.nextLine(); 
String query = "INSERT INTO appointments(patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)"; 
PreparedStatement pst = con.prepareStatement(query); 
pst.setInt(1, patientId); 
pst.setInt(2, doctorId); 
pst.setDate(3, Date.valueOf(date)); 
pst.executeUpdate(); 
System.out.println("Appointment Booked Successfully!"); 
} 

// ADD BILLING 

static void addBilling(Connection con, Scanner sc) throws SQLException { 
System.out.print("Enter Patient ID: "); 
int patientId = sc.nextInt(); 
System.out.print("Enter Amount: "); 
double amount = sc.nextDouble(); 
sc.nextLine(); 
System.out.print("Enter Payment Status: "); 
String status = sc.nextLine(); 
String query = "INSERT INTO billing(patient_id, amount, payment_status) VALUES (?, ?, ?)"; 
PreparedStatement pst = con.prepareStatement(query); 
pst.setInt(1, patientId); 
pst.setDouble(2, amount);
pst.setString(3, status); 
pst.executeUpdate(); 
System.out.println("Billing Added Successfully!"); 
} 

// ADD PRESCRIPTION 

static void addPrescription(Connection con, Scanner sc) throws SQLException { 
System.out.print("Enter Patient ID: "); 
int patientId = sc.nextInt(); 
System.out.print("Enter Doctor ID: "); 
int doctorId = sc.nextInt(); 
sc.nextLine(); 
System.out.print("Enter Medicines: "); 
String medicines = sc.nextLine(); 
String query = "INSERT INTO prescriptions(patient_id, doctor_id, medicines) VALUES (?, ?, ?)"; 
PreparedStatement pst = con.prepareStatement(query); 
pst.setInt(1, patientId); 
pst.setInt(2, doctorId); 
pst.setString(3, medicines); 
pst.executeUpdate(); 
System.out.println("Prescription Added Successfully!"); 
} 

// VIEW PATIENTS 

static void viewPatients(Connection con) throws SQLException {
String query = "SELECT * FROM patients"; 
Statement st = con.createStatement(); 
ResultSet rs = st.executeQuery(query); 
System.out.println("\n--- Patient Records ---"); 
while (rs.next()) { 
System.out.println( 
rs.getInt("patient_id") + " | " + 
rs.getString("name") + " | " + 
rs.getInt("age") + " | " + 
rs.getString("gender") + " | " + 
rs.getString("contact") + " | " + 
rs.getString("medical_history") 
); 
} 
} 

// VIEW DOCTORS 

static void viewDoctors(Connection con) throws SQLException { String query = "SELECT * FROM doctors"; 
Statement st = con.createStatement(); 
ResultSet rs = st.executeQuery(query); 
System.out.println("\n--- Doctor Records ---"); 
while (rs.next()) { 
System.out.println( 
rs.getInt("doctor_id") + " | " + 
rs.getString("name") + " | " + 
rs.getString("specialization") + " | " + 
rs.getString("schedule") 
); 
}
} 

// VIEW APPOINTMENTS 

static void viewAppointments(Connection con) throws SQLException { String query = "SELECT * FROM appointments"; 
Statement st = con.createStatement(); 
ResultSet rs = st.executeQuery(query); 
System.out.println("\n--- Appointment Records ---"); 
while (rs.next()) { 
System.out.println( 
rs.getInt("appointment_id") + " | " + 
rs.getInt("patient_id") + " | " + 
rs.getInt("doctor_id") + " | " + 
rs.getDate("appointment_date") 
); 
} 
} 

// VIEW BILLING 

static void viewBilling(Connection con) throws SQLException { String query = "SELECT * FROM billing"; 
Statement st = con.createStatement(); 
ResultSet rs = st.executeQuery(query); 
System.out.println("\n--- Billing Records ---"); 
while (rs.next()) { 
System.out.println(
rs.getInt("bill_id") + " | " + 
rs.getInt("patient_id") + " | " + 
rs.getDouble("amount") + " | " + 
rs.getString("payment_status") 
); 
} 
} 

// VIEW PRESCRIPTIONS 

static void viewPrescriptions(Connection con) throws SQLException { 
String query = "SELECT * FROM prescriptions"; 
Statement st = con.createStatement(); 
ResultSet rs = st.executeQuery(query); 
System.out.println("\n--- Prescription Records ---"); 
while (rs.next()) { 
System.out.println( 
rs.getInt("prescription_id") + " | " + 
rs.getInt("patient_id") + " | " + 
rs.getInt("doctor_id") + " | " + 
rs.getString("medicines") 
); 
} 
} 
} 
