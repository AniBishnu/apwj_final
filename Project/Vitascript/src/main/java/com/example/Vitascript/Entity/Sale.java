package com.example.Vitascript.Entity;

import java.time.LocalDate;

public class Sale {
    public int id;
    public int prescriptionId;   // FK to Prescription
    public int pharmacyId;       // FK to Pharmacy
    public LocalDate date;
    public int totalAmount;

    public Sale(int id, int prescriptionId, int pharmacyId, int totalAmount) {
        this.id = id;
        this.prescriptionId = prescriptionId;
        this.pharmacyId = pharmacyId;
        this.date = LocalDate.now();
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }
}
