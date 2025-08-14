/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import web.demo.dao.ReservaDAO;
import web.demo.domain.Reserva;
import web.demo.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDAO reservaDAO;

    @Override
    public List<Reserva> findAll() {
        return reservaDAO.findAll();
    }

    @Override
    public void save(Reserva reserva) {
        reservaDAO.save(reserva);
    }
}
