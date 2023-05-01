package com.example.gtics231lab5201895.Controllers;

import com.example.gtics231lab5201895.Dto.ListaTemporalDto;
import com.example.gtics231lab5201895.Entity.Employee;
import com.example.gtics231lab5201895.Entity.Job;
import com.example.gtics231lab5201895.Repository.EmployeeRepository;
import com.example.gtics231lab5201895.Repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;

    public EmployeeController(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @GetMapping(value={"/","","/listarEmployees"})
    public String listarEmployees(Model model) {
        List<ListaTemporalDto> employeeList = employeeRepository.listarEmployee();
        model.addAttribute("listaEmpleados", employeeList);

        return "listaEmployees";
    }

    @PostMapping("/buscarEmployee")
    public String buscarEmployee(@RequestParam("searchField") String searchField,
                                      Model model) {

        List<ListaTemporalDto> employeeList = employeeRepository.buscarEmployee(searchField);
        System.out.println("funciono buscar");
        model.addAttribute("listaEmpleados", employeeList);

        return "listaEmployees";
    }

    @GetMapping(value={"/crearEmpleado"})
    public String crearEmployee(Model model) {
        List<Employee> employeeList = employeeRepository.findAll();

        LocalDateTime fechaActual = LocalDateTime.now();
        model.addAttribute("listaEmpleados", employeeList);
        model.addAttribute("fechaActual", fechaActual);
        model.addAttribute("listaJobs",jobRepository.findAll());

        return "crearEmpleado";
    }

    @PostMapping("/save")
    public String guardarNuevoEmployee(Employee employee, RedirectAttributes attr) {

        attr.addFlashAttribute("msg", "Empleado creado exitosamente");


        employeeRepository.save(employee);
        return "redirect:/employee/listarEmployees";
    }

    @GetMapping("/borrar")
    public String borrarTransportista(@RequestParam("id") Integer id,RedirectAttributes attr) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        attr.addFlashAttribute("msg", "Empleado borrado exitosamente");
        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        }
        return "redirect:/employee/listarEmployees";

    }

}
