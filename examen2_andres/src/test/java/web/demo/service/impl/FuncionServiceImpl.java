/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import web.demo.dao.FuncionDAO;
import web.demo.domain.Funcion;
import web.demo.service.FuncionService;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionDAO funcionDAO;

    @Override
    public List<Funcion> findAll() {
        return funcionDAO.findAll();
    }

    @Override
    public void save(Funcion funcion) {
        funcionDAO.save(funcion);
    }
}
