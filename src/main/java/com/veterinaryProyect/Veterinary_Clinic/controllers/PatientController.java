package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientServices patientServices;

    @GetMapping
    public List<Patient> getAllPatient() {
        return patientServices.getAllPatient();
    }

    @GetMapping(path = "/images/{id}")
    public Patient getPatientById(@PathVariable("id") long id) {
        return patientServices.getById(id);
    }

    @PutMapping(path = "/{id}")
    public void updateImage(@RequestBody Patient patient, @PathVariable long id) {
        patientServices.updatePatient(patient, id);
    }
}
