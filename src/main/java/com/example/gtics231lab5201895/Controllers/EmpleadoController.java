package com.example.gtics231lab5201895.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/empleado")
@Controller
public class EmpleadoController {

    @GetMapping(value={"/",""})
    public String dashboard(Model model) {
        List<Cita> optionalCita = citaRepository.BuscarPorDoctor("09568265");

        ArrayList<String> listaHorarios= new ArrayList<>();


        model.addAttribute("listaCitas", citaRepository.BuscarPorDoctor("09568265"));//CAMBIAR POR ID SESION

        return "doctor/DoctorDashboard";
    }

}
