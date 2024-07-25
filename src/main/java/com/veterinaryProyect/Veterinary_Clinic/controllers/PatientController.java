package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientServices patientServices;


    @PostMapping(path = "/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientServices.createPatient(patient);
    }

}
