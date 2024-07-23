package com.veterinaryProyect.Veterinary_Clinic.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;


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

    @GetMapping(path = "/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientServices.getById(id);
    }

    @PostMapping(path = "/patient")
    public Patient createPatient(@RequestBody Patient newPatient) {
        return patientServices.createPatient(newPatient);
    }

}
