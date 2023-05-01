package com.example.gtics231lab5201895.Repository;

import com.example.gtics231lab5201895.Dto.ListaSalarios;
import com.example.gtics231lab5201895.Dto.ListaTemporalDto;
import com.example.gtics231lab5201895.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT e.employee_id,e.first_name, e.last_name,j.job_title,d.department_name, l.city FROM employees e inner join jobs j on (e.job_id=j.job_id) inner join departments d on (d.department_id=e.department_id) inner join locations l on (l.location_id=d.location_id)",
            nativeQuery = true)
    List<ListaTemporalDto> listarEmployee();

    @Query(value = "SELECT e.employee_id,e.first_name, e.last_name, j.job_title, d.department_name, l.city FROM employees e INNER JOIN jobs j ON e.job_id = j.job_id INNER JOIN departments d ON e.department_id = d.department_id INNER JOIN locations l ON d.location_id = l.location_id WHERE lower(e.first_name) LIKE %?1% OR lower(e.last_name) LIKE %?1% OR lower(j.job_title) LIKE %?1% OR lower(l.city) LIKE %?1% OR lower(department_name) LIKE %?1%",
            nativeQuery = true)
    List<ListaTemporalDto> buscarEmployee(String searchField);

    @Query(value = "SELECT job_title, MAX(salary) AS max_salary, MIN(salary) AS min_salary, SUM(salary) AS total_salary, AVG(salary) AS avg_salary FROM employees JOIN jobs ON employees.job_id = jobs.job_id GROUP BY job_title",
            nativeQuery = true)
    List<ListaSalarios> buscarSalario();



}


