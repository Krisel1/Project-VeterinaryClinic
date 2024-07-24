package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentServices appointmentServices;

    public List<Appointment> getAllAppointment() {
        return appointmentServices.getAllAppointment();
    }

    @GetMapping(path = "/{id}")
    public Appointment getAppointmentById(@PathVariable("id") long id) {
        return appointmentServices.getById(id);
    }

    @PutMapping(path = "/{id}")
    public void updateImage(@RequestBody Appointment appointment, @PathVariable long id) {
        appointmentServices.updateAppointment(appointment, id);
    }
}
