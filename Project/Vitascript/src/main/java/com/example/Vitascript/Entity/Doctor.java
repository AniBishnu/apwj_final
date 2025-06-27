package com.example.Vitascript.Entity;

public class Doctor {
    public int id;
    public int userId;
    public int doctorTypeId;
    public String licenseNumber;

    public Doctor(int id, int userId, int doctorTypeId, String licenseNumber) {
        this.id = id;
        this.userId = userId;
        this.doctorTypeId = doctorTypeId;
        this.licenseNumber = licenseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDoctorTypeId() {
        return doctorTypeId;
    }

    public void setDoctorTypeId(int doctorTypeId) {
        this.doctorTypeId = doctorTypeId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
