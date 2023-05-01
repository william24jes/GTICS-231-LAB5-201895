package com.example.gtics231lab5201895.Controllers;

import com.example.gtics231lab5201895.Dto.ListaTemporalDto;
import com.example.gtics231lab5201895.Repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/reporte")
@Controller
public class ReporteController {
    final EmployeeRepository employeeRepository;

    public ReporteController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value={"/","","/menu"})
    public String menu(Model model) {

        return "menuReportes";
    }

    @GetMapping(value={"/menu/salario"})
    public String salario(Model model) {

        model.addAttribute("listaSalarios",employeeRepository.buscarSalario());
        return "salarioReportes";
    }

    @GetMapping(value={"/menu/aumento"})
    public String aumento(Model model) {

        return "aumentoReportes";
    }

}
