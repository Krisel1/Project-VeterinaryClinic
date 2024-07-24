package com.veterinaryProyect.Veterinary_Clinic.controllers;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AppointmentControllerTest {

    @Mock
    private AppointmentServices appointmentServices;

    @InjectMocks
    private AppointmentController appointmentController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentController).build();
    }

    @Test
    void updateAppointment() throws Exception {
        Appointment updatedAppointment = new Appointment(1L, LocalDateTime.of(2023, 2, 13, 7, 12), "Updated Title", "Updated Description", false);

        doNothing().when(appointmentServices).updateAppointment(updatedAppointment,1L);

        mockMvc.perform(put("/appointments/appointment/1")
                        .contentType("application/json")
                        .content("{\"title\":\"Updated Title\", \"description\":\"Updated Description\", \"favorite\":false}"))
                .andExpect(status().isOk());
    }
}
