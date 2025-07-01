package com.example.Vitascript.Service;

import com.example.Vitascript.Entity.*;
import com.example.Vitascript.Repository.*;

import java.util.List;

public class AdminService {
    public DoctorRepo doctorRepo;
    public PharmacyRepo pharmacyRepo;
    public GenericMedicineRepo genericMedicineRepo;
    public BrandedMedicineRepo brandedMedicineRepo;
    public PrescriptionRepo prescriptionRepo;
    public SaleRepo saleRepo;
    public StockRepo stockRepo;
    public UserRepo userRepo;

    public AdminService(DoctorRepo doctorRepo, PharmacyRepo pharmacyRepo, GenericMedicineRepo genericMedicineRepo,
                        BrandedMedicineRepo brandedMedicineRepo, PrescriptionRepo prescriptionRepo, SaleRepo saleRepo,
                        StockRepo stockRepo, UserRepo userRepo) {
        this.doctorRepo = doctorRepo;
        this.pharmacyRepo = pharmacyRepo;
        this.genericMedicineRepo = genericMedicineRepo;
        this.brandedMedicineRepo = brandedMedicineRepo;
        this.prescriptionRepo = prescriptionRepo;
        this.saleRepo = saleRepo;
        this.stockRepo = stockRepo;
        this.userRepo = userRepo;
    }

    // Doctor Management
    public void addDoctor(Doctor doctor) {
        doctorRepo.addDoctor(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        doctorRepo.updateDoctor(doctor);
    }

    public void deleteDoctor(int id) {
        doctorRepo.deleteDoctor(id);
    }

    // Pharmacy Management
    public void addPharmacy(Pharmacy pharmacy) {
        pharmacyRepo.addPharmacy(pharmacy);
    }

    public void updatePharmacy(Pharmacy pharmacy) {
        pharmacyRepo.updatePharmacy(pharmacy);
    }

    public void deletePharmacy(int id) {
        pharmacyRepo.deletePharmacy(id);
    }

    // Medicine Management
    public void addGenericMedicine(GenericMedicine gm) {
        genericMedicineRepo.add(gm);
    }

    public void updateGenericMedicine(GenericMedicine gm) {
        genericMedicineRepo.update(gm);
    }

    public void addBrandedMedicine(BrandedMedicine bm) {
        brandedMedicineRepo.add(bm);
    }

    public void updateBrandedMedicine(BrandedMedicine bm) {
        brandedMedicineRepo.update(bm);
    }

    // View all prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepo.getAll();
    }

    // View all transactions (sales)
    public List<Sale> getAllSales() {
        return saleRepo.getAll();
    }

    // Low stock alerts
    public List<Stock> getLowStockAlerts() {
        return stockRepo.getLowStock();
    }

    // Dashboard statistics
    public int getUserCount() {
        return userRepo.getAll().size();
    }

    public int getPrescriptionCount() {
        return prescriptionRepo.getAll().size();
    }

    public int getMedicineCount() {
        return genericMedicineRepo.getAll().size();
    }
}
