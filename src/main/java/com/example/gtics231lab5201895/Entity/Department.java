package com.example.gtics231lab5201895.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="departments")
public class Department {
    @Id
    @Column(name = "department_id", nullable = false)
    private int department_id;

    @Column(nullable = false)
    private String department_name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager_de_department;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
