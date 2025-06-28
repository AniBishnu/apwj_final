package com.example.Vitascript.Entity;

public class Doctor {
    public int id;
    public int userId;
    public String doctorType;
    public String licenseNumber;

    public Doctor(int id, int userId, String doctorType, String licenseNumber) {
        this.id = id;
        this.userId = userId;
        this.doctorType = doctorType;
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

    public String getDoctorTypeId() {
        return doctorType;
    }

    public void setDoctorTypeId(String doctorTypeId) {
        this.doctorType = doctorTypeId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
