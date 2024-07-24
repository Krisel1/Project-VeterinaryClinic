package com.veterinaryProyect.Veterinary_Clinic.services;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServices {

    @Autowired
    IAppointmentRepository iAppointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
       return iAppointmentRepository.save(appointment);
    }
}
