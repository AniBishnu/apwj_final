package com.example.Vitascript.Entity;

public class Pharmacy {
    public int id;
    public int userId;
    public String pharmacyName;
    public String licenseNumber;
    public String location;

    public Pharmacy(int id, int userId, String pharmacyName, String licenseNumber, String location) {
        this.id = id;
        this.userId = userId;
        this.pharmacyName = pharmacyName;
        this.licenseNumber = licenseNumber;
        this.location = location;
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

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
