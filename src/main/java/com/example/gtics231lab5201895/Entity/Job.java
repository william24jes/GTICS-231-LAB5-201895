package com.example.gtics231lab5201895.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="jobs")
public class Job {
    @Id
    @Column(name = "job_id", nullable = false)
    private String job_id;

    @Column(nullable = false)
    private String job_title;
    private int min_salary;
    private int max_salary;
}
