/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.demo.domain.Rol;

public interface RolDao extends JpaRepository<Rol, Long> {

}