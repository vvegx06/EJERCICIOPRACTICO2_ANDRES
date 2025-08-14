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
import web.demo.domain.Funcion;
import web.demo.service.FuncionService;
import web.demo.service.PeliculaService;

@Controller
@RequestMapping("/funciones")
public class FuncionController {
    @Autowired
    private FuncionService funcionService;
    @Autowired
    private PeliculaService peliculaService;
    @GetMapping
    public String listFunciones(Model model) {
        List<Funcion> funciones = funcionService.findAll();
        model.addAttribute("funciones", funciones);
        model.addAttribute("peliculas", peliculaService.findAll()); // Pasar películas a la vista
        return "funciones"; // Vista de lista de funciones
    }
    @PostMapping("/add")
    public String addFuncion(Funcion funcion) {
        funcionService.save(funcion);
        return "redirect:/funciones"; // Redirigir a la lista de funciones
    }
}