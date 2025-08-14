/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import web.demo.domain.Reserva;
import web.demo.service.FuncionService;
import web.demo.service.ReservaService;
import web.demo.service.UsuarioService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private FuncionService funcionService;
    @GetMapping
    public String listReservas(Model model) {
        List<Reserva> reservas = reservaService.findAll();
        model.addAttribute("reservas", reservas);
        model.addAttribute("usuarios", usuarioService.findAll()); // Pasar usuarios a la vista
        model.addAttribute("funciones", funcionService.findAll()); // Pasar funciones a la vista
        return "reservas"; // Vista de lista de reservas
    }
    @PostMapping("/add")
    public String addReserva(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas"; // Redirigir a la lista de reservas
    }
}