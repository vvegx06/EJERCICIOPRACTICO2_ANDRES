/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.demo.dao.PeliculaDao;
import web.demo.domain.Pelicula;
import web.demo.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> getPeliculas(boolean activos) {
        var lista = peliculaDao.findAll();
        if (activos) {
            lista.removeIf(p -> !p.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula getPelicula(Pelicula pelicula) {
        return peliculaDao.findById(pelicula.getIdPelicula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Pelicula pelicula) {
        peliculaDao.save(pelicula);
    }

    @Override
    @Transactional
    public void delete(Pelicula pelicula) {
        peliculaDao.delete(pelicula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> findByPrecioBetweenOrderByTitulo(double precioInf, double precioSup) {
        return peliculaDao.findByPrecioBetweenOrderByTitulo(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> metodoJPQL(double precioInf, double precioSup) {
        return peliculaDao.metodoJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> metodoNativo(double precioInf, double precioSup) {
        return peliculaDao.metodoNativo(precioInf, precioSup);
    }
}