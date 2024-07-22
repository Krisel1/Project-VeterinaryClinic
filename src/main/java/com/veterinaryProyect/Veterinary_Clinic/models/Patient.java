package com.veterinaryProyect.Veterinary_Clinic.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.List;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "breed")
    private String breed;

    @Column(name = "gender")
    private String gender;

    @Column(name = "identicationNumber")
    private String identicationNumber;

    @Column(name = "tutorFirstName")
    private String tutorFirstName;

    @Column(name = "tutorLastName")
    private String tutorLastName;

    @Column(name = "tutorphoneNumber")
    private String tutorPhoneNumber;

    @ManyToMany
    @JoinTable(
            name = "patient_appointment",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id")
    )
    private Set<Appointment> appointments = new HashSet<>();

    //private String profileImage;

}
