package com.example.Vitascript.Entity;

public class PrescribedMedicine {
    public int id;
    public int prescriptionId;
    public int genericMedicineId;
    public String dose;
    public int duration;
    public String notes;
    public int quantity;

    public PrescribedMedicine(int id, int prescriptionId, int genericMedicineId, String dose, int duration, String notes, int quantity) {
        this.id = id;
        this.prescriptionId = prescriptionId;
        this.genericMedicineId = genericMedicineId;
        this.dose = dose;
        this.duration = duration;
        this.notes = notes;
        this.quantity = quantity;
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

    public int getGenericMedicineId() {
        return genericMedicineId;
    }

    public void setGenericMedicineId(int genericMedicineId) {
        this.genericMedicineId = genericMedicineId;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

