package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    PatientServices patientServices;

    @GetMapping(path = "")
    public List<Patient> getAllPatient() {
        return patientServices.getAllPatient();
    }

    @PostMapping(path = "/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientServices.createPatient(patient);
    @GetMapping(path = "/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientServices.getById(id);
    }

}
