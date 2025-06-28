package com.example.Vitascript.Entity;

import java.time.LocalDate;

public class Prescription {
    public int id;
    public String code;
    public int doctorId;    // FK to User (role = DOCTOR)
    public int patientId;   // FK to User (role = PATIENT)
    public int appointmentId;
    public PrescriptionStatus Status;
    public LocalDate issuedDate;

    public Prescription(int id, String code, int doctorId, int patientId, int appointmentId, PrescriptionStatus status) {
        this.id = id;
        this.code = code;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.Status = status;
        this.issuedDate=LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public PrescriptionStatus getStatus() {
        return Status;
    }

    public void setStatus(PrescriptionStatus status) {
        Status = status;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }
}
