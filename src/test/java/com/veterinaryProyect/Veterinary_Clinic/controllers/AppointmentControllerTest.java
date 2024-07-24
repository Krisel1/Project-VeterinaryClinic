package com.veterinaryProyect.Veterinary_Clinic.controllers;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentControllerTest {

    @Mock
    private AppointmentServices appointmentServices;

    @InjectMocks
    private AppointmentController appointmentController;

    private Appointment appointment;

    @BeforeEach
    void setUp() {
        appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDateTime(LocalDateTime.of(2024, 7, 23, 10, 0));
        appointment.setConsultationType("standard");
        appointment.setReason("Annual checkup");
        appointment.setStatus(true);
    }

    @Test
    void test_Create_Appointment_Id() {

        when(appointmentServices.createAppointment(any(Appointment.class))).thenReturn(appointment);

        Appointment result = appointmentController.createAppointment(appointment);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(appointmentServices, times(1)).createAppointment(any(Appointment.class));
    }

}