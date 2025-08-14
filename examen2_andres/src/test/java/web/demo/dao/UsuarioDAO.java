/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.demo.domain.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
