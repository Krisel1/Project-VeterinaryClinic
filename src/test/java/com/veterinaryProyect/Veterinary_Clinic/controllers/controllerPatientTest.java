package com.veterinaryProyect.Veterinary_Clinic.controllers;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class controllerPatientTest {
    @Mock
    private PatientServices patientServices;

    @InjectMocks
    private PatientController patientController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
    }

    @Test
    void updateAppointment() throws Exception {
        Patient updatedPatient = new Patient(1L, "John Doe", 5, "Beagle", "Male", "12345", "Jane", "Doe", "555-1234");

        doNothing().when(patientServices).updatePatient(updatedPatient,1L);

        mockMvc.perform(put("/patients/patient/1")
                        .contentType("application/json")
                        .content("{\"name\":\"John Doe\", \"age\":5, \"breed\":\"Beagle\", \"gender\":\"Male\", \"identicationNumber\":\"12345\", \"tutorFirstName\":\"Jane\", \"tutorLastName\":\"Doe\", \"tutorPhoneNumber\":\"555-1234\"}"))
                .andExpect(status().isOk());
    }
}
