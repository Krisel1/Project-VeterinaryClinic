package com.veterinaryProyect.Veterinary_Clinic.controllers;

<<<<<<< HEAD
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientServices patientServices;

    @Test
    public void deletePatientById_ShouldReturnOk() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/patient/{id}", id))
                .andExpect(status().isOk());

        verify(patientServices).deletePatient(id);
    }
}
=======
import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientControllerTest {

    @Mock
    private PatientServices patientServices;

    @InjectMocks
    private PatientController patientController;

    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient();
        patient.setId(1L);
        patient.setName("Blacky");
        patient.setAge(3);
        patient.setBreed("Poodle");
        patient.setGender("Male");
    }

    @Test
    void test_Create_Patient_Id() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Name() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals("Blacky", result.getName());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Age() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals(3, result.getAge());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Breed() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals("Poodle", result.getBreed());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Gender() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals("Male", result.getGender());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

}

>>>>>>> feature/create
