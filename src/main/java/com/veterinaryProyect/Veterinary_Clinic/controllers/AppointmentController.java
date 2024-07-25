package com.veterinaryProyect.Veterinary_Clinic.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class AppointmentController {

    @Autowired
    AppointmentServices appointmentServices;

    @GetMapping(path = "/appointment")
    public List<Appointment> getAllAppointment() {
        return appointmentServices.getAllAppointment();
    }

    @GetMapping(path = "/appointment/{id}")
    public Appointment getAppointmentById(@PathVariable("id") Long id) {
        return appointmentServices.getById(id);
    }

    @PostMapping(path = "/appointment")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentServices.createAppointment(appointment);
    }

    @PutMapping(path = "/appointment/{id}")
    public void updateAppointment(@RequestBody Appointment appointment, @PathVariable Long id) {
        appointmentServices.updateAppointment(appointment, id);
    }

    @DeleteMapping(path = "/appointment/{id}")
    public void deleteAppointmentById(@PathVariable("id") Long id) {
        appointmentServices.deleteAppointment(id);

    }
}
