/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import web.demo.dao.PeliculaDAO;
import web.demo.domain.Pelicula;
import web.demo.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDAO peliculaDAO;

    @Override
    public List<Pelicula> findAll() {
        return peliculaDAO.findAll();
    }

    @Override
    public void save(Pelicula pelicula) {
        peliculaDAO.save(pelicula);
    }
}
