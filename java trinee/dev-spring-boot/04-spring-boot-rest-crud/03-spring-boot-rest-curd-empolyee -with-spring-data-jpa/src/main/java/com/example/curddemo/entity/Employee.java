package com.example.curddemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;


}
