package com.example.Vitascript.Entity;

import java.time.LocalDateTime;

public class Appointment {
    public int id;

    public String patientName;
    public int patientAge;
    public String patientGender;
    public String patientPhone;
    public int doctorId;
    public LocalDateTime apointmentTaken;

    public Appointment(int id, String patientName, int patientAge, String patientGender, String patientPhone, int doctorId) {
        this.id = id;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientPhone = patientPhone;
        this.doctorId = doctorId;
        this.apointmentTaken=LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getApointmentTaken() {
        return apointmentTaken;
    }
}

