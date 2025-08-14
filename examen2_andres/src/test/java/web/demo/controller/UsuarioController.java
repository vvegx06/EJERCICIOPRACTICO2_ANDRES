/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.demo.domain.Usuario;
import web.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Vista de registro
    }
    @PostMapping("/register")
    public String registerUser(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/login"; // Redirigir a la página de login
    }
}