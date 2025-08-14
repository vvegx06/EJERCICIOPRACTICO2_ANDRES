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
import web.demo.domain.Pelicula;
import web.demo.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    @GetMapping
    public String listPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaService.findAll();
        model.addAttribute("peliculas", peliculas);
        return "peliculas"; // Vista de lista de películas
    }
    @PostMapping("/add")
    public String addPelicula(Pelicula pelicula) {
        peliculaService.save(pelicula);
        return "redirect:/peliculas"; // Redirigir a la lista de películas
    }
}