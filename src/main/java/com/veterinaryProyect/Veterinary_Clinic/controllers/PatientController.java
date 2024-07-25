package com.veterinaryProyect.Veterinary_Clinic.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class PatientController {

    @Autowired
    PatientServices patientServices;

    @GetMapping(path = "/patient")
    public List<Patient> getAllPatient() {
        return patientServices.getAllPatient();
    }

    @GetMapping(path = "/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientServices.getById(id);
    }

    @PostMapping(path = "/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientServices.createPatient(patient);
    }

    @PutMapping(path = "/patient/{id}")
    public void updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
        patientServices.updatePatient(patient, id);
    }

    @DeleteMapping(path = "/patient/{id}")
    public void deletePatientById(@PathVariable("id") Long id) {
        patientServices.deletePatient(id); }

}
