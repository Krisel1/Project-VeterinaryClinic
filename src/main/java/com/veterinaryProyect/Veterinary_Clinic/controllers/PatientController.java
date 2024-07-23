package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientServices patientServices;

    @GetMapping
    public List<Patient> getAllPatient() {
        return patientServices.getAllPatient();
    }

    @GetMapping(path = "/*/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientServices.getById(id);
    }

    @DeleteMapping(path = "/*/{id}")
    public void deletePatientById(@PathVariable("id") Long id) {patientServices.deletePatient(id); }


}
