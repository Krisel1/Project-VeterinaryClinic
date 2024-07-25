package com.veterinaryProyect.Veterinary_Clinic.controllers;

<<<<<<< HEAD
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
=======
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
>>>>>>> feature/create

@WebMvcTest(controllers = AppointmentController.class)
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentServices appointmentServices;

    @Test
    public void deleteAppointmentById_ShouldReturnOk() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/appointment/{id}", id))
                .andExpect(status().isOk());

        verify(appointmentServices).deleteAppointment(id);
    }
}