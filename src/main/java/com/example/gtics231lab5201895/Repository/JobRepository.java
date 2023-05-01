package com.example.gtics231lab5201895.Repository;

import com.example.gtics231lab5201895.Entity.Employee;
import com.example.gtics231lab5201895.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
