package com.example.assignment2.Service;

import com.example.assignment2.Entity.Invoice;
import com.example.assignment2.Repository.InvoiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    public InvoiceRepo invoiceRepo;

    public InvoiceService(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }
    public List<Invoice> getAll() {
        return invoiceRepo.getAll();
    }

    public List<Invoice> getByUserId(int userId) {
        return invoiceRepo.getByUserId(userId);
    }

    public void generateInvoice(Invoice invoice) {
        invoiceRepo.generateInvoice(invoice);
    }

}
