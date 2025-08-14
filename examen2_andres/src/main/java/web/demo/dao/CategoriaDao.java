/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package web.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.demo.domain.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
}