/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service;

import java.util.List;
import web.demo.domain.Reserva;

public interface ReservaService {

    List<Reserva> findAll();

    void save(Reserva reserva);
}
