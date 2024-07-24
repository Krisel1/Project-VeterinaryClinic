package com.veterinaryProyect.Veterinary_Clinic.services;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IPatientRepository;
import net.bytebuddy.implementation.EqualsMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PatientServicesTest {

    @Mock
    private IPatientRepository iPatientRepository;

    @InjectMocks
    private PatientServices patientServices;

    private Patient patient;
    private Patient updatedPatient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
            }

    @Test
    void update_patient() {
        patient = new Patient(1L, "Sharik", 5, "mutt","fame","13-07-13","Vadim","Shevchenko","067118675");
        when(iPatientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
        updatedPatient = new Patient(1L, "Shariko", 7, "Mastiff","male","156-07-24","Svitlana","Franko","0674567389");
        when(iPatientRepository.save(any(Patient.class))).thenReturn(updatedPatient);
        patientServices.updatePatient(updatedPatient, patient.getId());
        assertEquals(updatedPatient.getName(), patient.getName());
        assertEquals(updatedPatient.getAge(), patient.getAge());
        assertEquals(updatedPatient.getBreed(), patient.getBreed());
        assertEquals(updatedPatient.getGender(), patient.getGender());
        assertEquals(updatedPatient.getTutorPhoneNumber(), patient.getTutorPhoneNumber());
        assertEquals(updatedPatient.getTutorFirstName(), patient.getTutorFirstName());
        assertEquals(updatedPatient.getTutorLastName(), patient.getTutorLastName());
        assertEquals(updatedPatient.getTutorPhoneNumber(), patient.getTutorPhoneNumber());
        }

    }