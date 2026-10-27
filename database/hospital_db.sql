CREATE DATABASE hospital_db; 
USE hospital_db; 
-- Patient Table 
CREATE TABLE patients ( 
patient_id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(100), 
age INT, 
gender VARCHAR(10),
contact VARCHAR(15), 
medical_history TEXT 
); 
-- Doctor Table 
CREATE TABLE doctors ( 
doctor_id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(100), 
specialization VARCHAR(100), 
schedule VARCHAR(100) 
); 
-- Appointment Table 
CREATE TABLE appointments ( 
appointment_id INT PRIMARY KEY AUTO_INCREMENT, 
patient_id INT, 
doctor_id INT, 
appointment_date DATE, 
FOREIGN KEY (patient_id) REFERENCES patients(patient_id), FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ); 
-- Billing Table 
CREATE TABLE billing ( 
bill_id INT PRIMARY KEY AUTO_INCREMENT, 
patient_id INT, 
amount DOUBLE, 
payment_status VARCHAR(20), 
FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ); 
-- Prescription Table 
CREATE TABLE prescriptions ( 
prescription_id INT PRIMARY KEY AUTO_INCREMENT, 
patient_id INT, 
doctor_id INT, 
medicines TEXT, 
FOREIGN KEY (patient_id) REFERENCES patients(patient_id), FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ); 
INSERT INTO patients(name, age, gender, contact, medical_history) VALUES ('Yash Thakur', 24, 'Male', '9188732419', 'Fever'),
('Simran Bhosale', 29, 'Female', '9234668702', 'Asthma'), 
('Omkar Jadhav', 35, 'Male', '8149956703', 'Diabetes'), 
('Tanvi Salunke', 21, 'Female', '9856709124', 'Migraine'), 
('Harsh Agrawal', 42, 'Male', '9335156705', 'BP'), 
('Rutuja Pawar', 27, 'Female', '9600154831', 'Thyroid'), 
('Sanket Patne', 31, 'Male', '9707990128', 'Back Pain'), 
('Aishwarya Kale', 26, 'Female', '8082219912', 'Allergy'), 
('Tejas Shinde', 38, 'Male', '9142100879', 'Heart Disease'), 
('Pallavi More', 33, 'Female', '9010664399', 'Anemia'), 
('Nikhil Wagh', 23, 'Male', '8855427109', 'Cold & Cough'), 
('Vaishnavi Patil', 30, 'Female', '9671449872', 'PCOD'), 
('Pratik Desai', 45, 'Male', '9176534789', 'Arthritis'), 
('Sakshi Chavan', 25, 'Female', '9736684899', 'Sinus'), 
('Atharva Kulkarni', 37, 'Male', '8456378902', 'Skin Infection'); 
INSERT INTO doctors(name, specialization, schedule) VALUES ('Dr. Rohit Bendre', 'Cardiologist', '9 AM - 1 PM'), 
('Dr. Neha Gokhale', 'Dermatologist', '10 AM - 3 PM'), 
('Dr. Ajinkya Patwardhan', 'Neurologist', '11 AM - 4 PM'), 
('Dr. Snehal Tambe', 'Orthopedic', '2 PM - 6 PM'), 
('Dr. Mahesh Bhalerao', 'General Physician', '9 AM - 5 PM'), 
('Dr. Priti Kulshrestha', 'Gynecologist', '10 AM - 2 PM'), 
('Dr. Vinay Joshi', 'ENT Specialist', '1 PM - 5 PM'), 
('Dr. Kiran Pathak', 'Pediatrician', '9 AM - 12 PM'), 
('Dr. Ashutosh Rane', 'Psychiatrist', '3 PM - 7 PM'), 
('Dr. Sonali Phadke', 'Ophthalmologist', '10 AM - 1 PM'), 
('Dr. Tushar Bane', 'Dentist', '11 AM - 6 PM'), 
('Dr. Rachana Dixit', 'Oncologist', '8 AM - 12 PM'), 
('Dr. Akshay Inamdar', 'Radiologist', '2 PM - 5 PM'), 
('Dr. Smita Dongre', 'Physiotherapist', '9 AM - 4 PM'), 
('Dr. Vivek Ranade', 'Surgeon', '7 AM - 11 AM'); 
INSERT INTO appointments(patient_id, doctor_id, appointment_date) VALUES (1, 5, '2026-05-01'), 
(2, 2, '2026-05-02'), 
(3, 1, '2026-05-03'), 
(4, 3, '2026-05-04'), 
(5, 5, '2026-05-05'), 
(6, 6, '2026-05-06'), 
(7, 4, '2026-05-07'), 
(8, 2, '2026-05-08'), 
(9, 1, '2026-05-09'), 
(10, 8, '2026-05-10'), 
(11, 5, '2026-05-11'),
(12, 6, '2026-05-12'), 
(13, 4, '2026-05-13'), 
(14, 7, '2026-05-14'), 
(15, 2, '2026-05-15'); 
INSERT INTO billing(patient_id, amount, payment_status) VALUES (1, 1200, 'Paid'), 
(2, 1800, 'Pending'), 
(3, 2500, 'Paid'), 
(4, 1600, 'Paid'), 
(5, 3000, 'Pending'), 
(6, 2200, 'Paid'), 
(7, 1400, 'Paid'), 
(8, 1700, 'Pending'), 
(9, 4500, 'Paid'), 
(10, 1100, 'Paid'), 
(11, 900, 'Pending'), 
(12, 2000, 'Paid'), 
(13, 3500, 'Paid'), 
(14, 1300, 'Pending'), 
(15, 2800, 'Paid'); 
INSERT INTO prescriptions(patient_id, doctor_id, medicines) VALUES (1, 5, 'Paracetamol'), 
(2, 2, 'Asthalin Inhaler'), 
(3, 1, 'Metformin'), 
(4, 3, 'Sumatriptan'), 
(5, 5, 'Amlodipine'), 
(6, 6, 'Thyroxine'), 
(7, 4, 'Pain Relief Gel'), 
(8, 2, 'Cetirizine'), 
(9, 1, 'Aspirin'), 
(10, 8, 'Iron Supplements'), 
(11, 5, 'Cough Syrup'), 
(12, 6, 'Hormonal Tablets'), 
(13, 4, 'Calcium Tablets'), 
(14, 7, 'Antibiotics'), 
(15, 2, 'Skin Ointment'); 
