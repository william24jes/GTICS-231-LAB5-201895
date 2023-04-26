package com.example.gtics231lab5201895.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employees")
public class Empleado {
    @Id
    @Column(name = "employee_id", nullable = false)
    private int employee_id;

    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String email;

    private String password;
    private String phone_number;


    
}
