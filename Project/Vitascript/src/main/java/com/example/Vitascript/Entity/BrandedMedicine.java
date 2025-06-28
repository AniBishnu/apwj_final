package com.example.Vitascript.Entity;

public class BrandedMedicine {
    public int id;
    public String name;
    public int genericMedicineId;   // FK to GenericMedicine
    public String brandName;
    public int buyingPrice;
    public int mrp;

    public BrandedMedicine(int id, String name, int genericMedicineId, String brandName, int buyingPrice, int mrp) {
        this.id = id;
        this.name = name;
        this.genericMedicineId = genericMedicineId;
        this.brandName = brandName;
        this.buyingPrice = buyingPrice;
        this.mrp = mrp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGenericMedicineId() {
        return genericMedicineId;
    }

    public void setGenericMedicineId(int genericMedicineId) {
        this.genericMedicineId = genericMedicineId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }
}
