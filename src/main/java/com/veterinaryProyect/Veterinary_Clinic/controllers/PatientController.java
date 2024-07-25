package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientServices patientServices;



    @DeleteMapping(path = "/patient/{id}")
    public void deletePatientById(@PathVariable("id") Long id) {patientServices.deletePatient(id); }

}

