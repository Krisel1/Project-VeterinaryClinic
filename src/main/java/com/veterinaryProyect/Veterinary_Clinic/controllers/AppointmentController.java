package com.veterinaryProyect.Veterinary_Clinic.controllers;

import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class AppointmentController {

    @Autowired
    AppointmentServices appointmentServices;


    @DeleteMapping(path = "/appointment/{id}")
    public void deleteAppointmentById(@PathVariable("id") Long id) {
        appointmentServices.deleteAppointment(id);

    }

}
