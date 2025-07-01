package com.example.Vitascript.Service;

import com.example.Vitascript.Entity.*;
import com.example.Vitascript.Repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class PharmacyService {
    public PharmacyRepo pharmacyRepo;
    public PrescriptionRepo prescriptionRepo;
    public SaleRepo saleRepo;
    public SaleItemRepo saleItemRepo;
    public StockRepo stockRepo;
    public BrandedMedicineRepo brandedMedicineRepo;
    public PrescribedMedicineRepo prescribedMedicineRepo;

    public PharmacyService(PharmacyRepo pharmacyRepo, PrescriptionRepo prescriptionRepo, SaleRepo saleRepo,
                           SaleItemRepo saleItemRepo, StockRepo stockRepo, BrandedMedicineRepo brandedMedicineRepo) {
        this.pharmacyRepo = pharmacyRepo;
        this.prescriptionRepo = prescriptionRepo;
        this.saleRepo = saleRepo;
        this.saleItemRepo = saleItemRepo;
        this.stockRepo = stockRepo;
        this.brandedMedicineRepo = brandedMedicineRepo;
    }

    public Prescription getPrescriptionByCode(String code) {
        return prescriptionRepo.getByCode(code);
    }

    public void sellMedicines(Sale sale, List<SaleItem> items, int prescriptionId) {
        for (SaleItem item : items) {
            BrandedMedicine branded = brandedMedicineRepo.getById(item.getBrandedMedicineId());
            int genericId = branded.getGenericMedicineId();

            if (!prescribedMedicineRepo.isGenericPrescribed(prescriptionId, genericId)) {
                throw new RuntimeException("Medicine not allowed: Generic medicine not prescribed.");
            }

            List<PrescribedMedicine> prescribedList = prescribedMedicineRepo.getByPrescriptionId(prescriptionId);
            PrescribedMedicine match = prescribedList.stream()
                    .filter(pm -> pm.getGenericMedicineId() == genericId)
                    .findFirst().orElse(null);

            if (match == null || match.getQuantityLeft() < item.getQuantity()) {
                throw new RuntimeException("Insufficient quantityLeft in prescription.");
            }

            prescribedMedicineRepo.decreaseQuantityLeft(prescriptionId, genericId, item.getQuantity());

            stockRepo.decreaseStock(sale.getPharmacyId(), branded.getId(), item.getQuantity());
        }

        saleRepo.add(sale);
        for (SaleItem item : items) {
            saleItemRepo.add(item);
        }
    }


    public void addOrUpdateStock(int pharmacyId, int brandedMedicineId, int quantity) {
        Stock existing = stockRepo.getStock(pharmacyId, brandedMedicineId);
        if (existing == null) {
            stockRepo.add(new Stock(0, pharmacyId, brandedMedicineId, quantity));
        } else {
            existing.setQuantity(existing.getQuantity() + quantity);
            stockRepo.update(existing);
        }
    }


    public List<Sale> getSalesHistory() {
        return saleRepo.getAll();
    }

    public List<Stock> getLowStock() {
        return stockRepo.getLowStock();
    }

    public List<BrandedMedicine> getTopSellingMedicines() {
        List<SaleItem> allSaleItems = saleItemRepo.getAll();
        List<BrandedMedicine> allMedicines = brandedMedicineRepo.getAll();

        Map<Integer, Integer> salesCountMap = new HashMap<>();
        for (SaleItem item : allSaleItems) {
            salesCountMap.put(item.getBrandedMedicineId(),
                    salesCountMap.getOrDefault(item.getBrandedMedicineId(), 0) + item.getQuantity());
        }

        List<Integer> topMedicineIds = salesCountMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();

        return topMedicineIds.stream()
                .map(id -> allMedicines.stream()
                        .filter(med -> med.getId() == id)
                        .findFirst().orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }

    public List<Sale> getSalesReport() {
        List<Sale> allSales = saleRepo.getAll();
        LocalDate now = LocalDate.now();

        return allSales.stream()
                .filter(sale -> sale.getDate().getMonth() == now.getMonth() && sale.getDate().getYear() == now.getYear())
                .toList();
    }

    public Pharmacy getPharmacyProfile(int userId) {
        return pharmacyRepo.getByUserId(userId);
    }

    public void updatePharmacyProfile(Pharmacy pharmacy) {
        pharmacyRepo.updatePharmacy(pharmacy);
    }
}
