package com.example.gtics231lab5201895.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer employee_id;

    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String email;

    private String password;
    private String phone_number;

    @Column(nullable = false)
    private LocalDateTime hire_date;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    private BigDecimal salary;
    private BigDecimal commission_pct;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager_de_employee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department_de_employee;
    private int enabled;
}
