/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service;

import java.util.List;
import web.demo.domain.Pelicula;

public interface PeliculaService {
    List<Pelicula> getPeliculas(boolean activos);
    void save(Pelicula pelicula);
    void delete(Pelicula pelicula);
    Pelicula getPelicula(Pelicula pelicula);

    List<Pelicula> findByPrecioBetweenOrderByTitulo(double precioInf, double precioSup);
    List<Pelicula> metodoJPQL(double precioInf, double precioSup);
    List<Pelicula> metodoNativo(double precioInf, double precioSup);
}