/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.demo.dao.UsuarioDAO;
import web.demo.domain.Usuario;
import web.demo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }
    
    @Override
    public void save(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }
}
