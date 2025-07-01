package com.example.Vitascript.Service;

import com.example.Vitascript.Entity.*;
import com.example.Vitascript.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    public UserRepo userRepo;
    public DoctorRepo doctorRepo;
    public AppointmentRepo appointmentRepo;
    public GenericMedicineRepo genericMedicineRepo;
    public BrandedMedicineRepo brandedMedicineRepo;
    public PrescriptionRepo prescriptionRepo;
    public PrescribedMedicineRepo prescribedMedicineRepo;

    public DoctorService(UserRepo userRepo, DoctorRepo doctorRepo,
                         AppointmentRepo appointmentRepo,
                         GenericMedicineRepo genericMedicineRepo,
                         BrandedMedicineRepo brandedMedicineRepo,
                         PrescriptionRepo prescriptionRepo,
                         PrescribedMedicineRepo prescribedMedicineRepo) {
        this.userRepo = userRepo;
        this.doctorRepo = doctorRepo;
        this.appointmentRepo = appointmentRepo;
        this.genericMedicineRepo = genericMedicineRepo;
        this.brandedMedicineRepo = brandedMedicineRepo;
        this.prescriptionRepo = prescriptionRepo;
        this.prescribedMedicineRepo = prescribedMedicineRepo;
    }

    // req 1
    public User authenticateDoctor(String email, String password) {
        User user = userRepo.getByEmail(email);
        if (user != null && user.getRole() == Role.Doctor && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // req 2
    public void addPatient(User patient) {
        patient.setRoleId(Role.Patient);
        userRepo.addUser(patient);
    }

    // req 3
    public List<Appointment> getPatientsByDoctor(int doctorId) {
        return appointmentRepo.getByDoctor(doctorId);
    }

    // req 4
    public void updatePatient(User patient) {
        if (patient.getRole() == Role.Patient) {
            userRepo.updateUser(patient);
        } else {
            throw new IllegalArgumentException("Only patients can be updated via this method.");
        }
    }


    // req 5
    public void createPrescription(Prescription prescription, List<PrescribedMedicine> meds) {
        prescriptionRepo.add(prescription);
        for (PrescribedMedicine pm : meds) {
            prescribedMedicineRepo.add(pm);
        }
    }

    // 6. List all prescriptions by doctor
    public List<Prescription> getPrescriptionsByDoctor(int doctorId) {
        return prescriptionRepo.getByDoctor(doctorId);
    }

    // 7. Search medicines by generic name
    public List<GenericMedicine> searchGenericMedicines(String name) {
        return genericMedicineRepo.searchByName(name);
    }

    // 8. Get branded medicines by generic ID
    public List<BrandedMedicine> getBrandsByGeneric(int genericId) {
        return brandedMedicineRepo.getByGenericId(genericId);
    }

    // 9. Get prescription by ID
    public Prescription getPrescriptionById(int id) {
        return prescriptionRepo.getById(id);
    }

    // 10. Get appointments
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        return appointmentRepo.getByDoctor(doctorId);
    }
}
