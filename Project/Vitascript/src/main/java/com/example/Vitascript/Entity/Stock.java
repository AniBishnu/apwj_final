package com.example.Vitascript.Entity;

public class Stock {
    public int id;
    public int pharmacyId;        // FK to Pharmacy
    public int brandedMedicineId; // FK to BrandedMedicine
    public int quantity;

    public Stock(int id, int pharmacyId, int brandedMedicineId, int quantity) {
        this.id = id;
        this.pharmacyId = pharmacyId;
        this.brandedMedicineId = brandedMedicineId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public int getBrandedMedicineId() {
        return brandedMedicineId;
    }

    public void setBrandedMedicineId(int brandedMedicineId) {
        this.brandedMedicineId = brandedMedicineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
