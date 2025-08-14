/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service;

import java.util.List;
import web.demo.domain.Contacto;

public interface ContactoService {
    void guardarContacto(Contacto contacto);
    List<Contacto> listarContactos();
}