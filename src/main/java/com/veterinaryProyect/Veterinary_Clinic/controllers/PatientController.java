package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> feature/create

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientServices patientServices;

<<<<<<< HEAD
    @GetMapping(path = "/patients")
    public List<Patient> getAllPatient() {
        return patientServices.getAllPatient();
    }

    @GetMapping(path = "/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientServices.getById(id);
=======

    @PostMapping(path = "/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientServices.createPatient(patient);
>>>>>>> feature/create
    }

    @DeleteMapping(path = "/patient/{id}")
    public void deletePatientById(@PathVariable("id") Long id) {patientServices.deletePatient(id); }


}
