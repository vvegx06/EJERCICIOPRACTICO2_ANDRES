/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import web.demo.dao.ContactoDao;
import web.demo.domain.Contacto;
import web.demo.service.ContactoService;


@Service
public class ContactoServiceImpl implements ContactoService {

    private final ContactoDao dao;

    public ContactoServiceImpl(ContactoDao dao) {
        this.dao = dao;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        dao.save(contacto);
    }

    @Override
    public List<Contacto> listarContactos() {
        return dao.findAll();
    }
}