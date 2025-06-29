package com.example.Vitascript.Entity;

public class SaleItem {
    public int id;
    public int saleId;            // FK to Sale
    public int brandedMedicineId; // FK to BrandedMedicine
    public int quantity;
    public int unitPrice;

    public SaleItem(int id, int saleId, int brandedMedicineId, int quantity, int unitPrice) {
        this.id = id;
        this.saleId = saleId;
        this.brandedMedicineId = brandedMedicineId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
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

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
