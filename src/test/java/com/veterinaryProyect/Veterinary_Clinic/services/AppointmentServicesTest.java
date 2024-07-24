package com.veterinaryProyect.Veterinary_Clinic.services;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IAppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AppointmentServicesTest {
    @Mock
    private IAppointmentRepository iAppointmentRepository;

    @InjectMocks
    private AppointmentServices appointmentServices;

    private Patient appointment;
    private Patient updatedAppointment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void updatePatient_shouldUpdatePatient() {
        Appointment appointment = new Appointment(1L, LocalDateTime.of(2023, 2, 13, 7, 12), "hello", "heard", true);
        when(iAppointmentRepository.findById(appointment.getId())).thenReturn(Optional.of(appointment));
        Appointment updatedAppointment = new Appointment(1L, LocalDateTime.of(2024, 7, 23, 14, 30), "good day", "legs", false);

        appointmentServices.updateAppointment(updatedAppointment, appointment.getId());
        assertEquals(updatedAppointment.getReason(), appointment.getReason());
        assertEquals(updatedAppointment.getDateTime(), appointment.getDateTime());
        assertEquals(updatedAppointment.getConsultationType(), appointment.getConsultationType());
        assertEquals(updatedAppointment.isStatus(), appointment.isStatus());

    }

}