package com.veterinaryProyect.Veterinary_Clinic.services;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IPatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServices {

    @Autowired
    IPatientRepository iPatientRepository;

    public List<Patient> getAllPatient() {
        return (List<Patient>) iPatientRepository.findAll();
    }

    public Patient getById(Long id) {
        Patient patient;
        patient = iPatientRepository.findById(id).orElseThrow();
        return patient;

    }

    public void updatePatient(Patient patient, long id) {
        Patient updatedPatient = iPatientRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(updatedPatient, patient, "id");
            iPatientRepository.save(patient);
    }
}

