/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service.impl;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import web.demo.dao.FacturaDao;
import web.demo.dao.PeliculaDao;
import web.demo.dao.UsuarioDao;
import web.demo.dao.VentaDao;
import web.demo.domain.Factura;
import web.demo.domain.Item;
import web.demo.domain.Usuario;
import web.demo.domain.Venta;
import web.demo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private HttpSession session;

    @Override
    public List<Item> gets() {
        @SuppressWarnings("unchecked")
        List<Item> listaItems = (List<Item>) session.getAttribute("listaItems");
        return listaItems;
    }

    @Override
    public Item get(Item item) {
        @SuppressWarnings("unchecked")
        List<Item> listaItems = (List<Item>) session.getAttribute("listaItems");
        if (listaItems != null) {
            for (Item i : listaItems) {
                if (Objects.equals(i.getIdPelicula(), item.getIdPelicula())) {
                    return i;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(Item item) {
        @SuppressWarnings("unchecked")
        List<Item> listaItems = (List<Item>) session.getAttribute("listaItems");
        if (listaItems != null) {
            int pos = -1;
            boolean existe = false;
            for (Item i : listaItems) {
                pos++;
                if (Objects.equals(i.getIdPelicula(), item.getIdPelicula())) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                listaItems.remove(pos);
                session.setAttribute("listaItems", listaItems);
            }
        }
    }

    @Override
    public void save(Item item) {
        @SuppressWarnings("unchecked")
        List<Item> listaItems = (List<Item>) session.getAttribute("listaItems");
        if (listaItems == null) listaItems = new ArrayList<>();

        boolean existe = false;
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdPelicula(), item.getIdPelicula())) {
                existe = true;
                // Si manejas existencias, aquí validarías contra existencias:
                // if (i.getCantidad() < i.getExistencias()) { ... }
                i.setCantidad(i.getCantidad() + 1);
                break;
            }
        }
        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }
        session.setAttribute("listaItems", listaItems);
    }

    @Override
    public void update(Item item) {
        @SuppressWarnings("unchecked")
        List<Item> listaItems = (List<Item>) session.getAttribute("listaItems");
        if (listaItems != null) {
            for (Item i : listaItems) {
                if (Objects.equals(i.getIdPelicula(), item.getIdPelicula())) {
                    i.setCantidad(item.getCantidad());
                    session.setAttribute("listaItems", listaItems);
                    break;
                }
            }
        }
    }

    @Autowired private UsuarioDao usuarioDao;
    @Autowired private PeliculaDao peliculaDao;
    @Autowired private FacturaDao facturaDao;
    @Autowired private VentaDao ventaDao;

    @Override
    public void facturar() {
        // 1) Usuario autenticado
        String username = "";
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails ud) username = ud.getUsername();
        else if (principal != null) username = principal.toString();
        if (username.isBlank()) return;

        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) return;

        // 2) Crear la factura
        // Nota: asumimos constructor Factura(int idUsuario) como en tu código
        Factura factura = facturaDao.save(new Factura(usuario.getIdUsuario()));

        // 3) Procesar ítems del carrito
        @SuppressWarnings("unchecked")
        List<Item> lista = (List<Item>) session.getAttribute("listaItems");
        if (lista == null || lista.isEmpty()) return;

        double total = 0.0;
        for (Item i : lista) {
            // Validar que la película exista
            peliculaDao.getReferenceById(i.getIdPelicula());

            // Registrar la venta
            // Asumimos constructor Venta(int idFactura, int idPelicula, double precio, int cantidad)
            Venta venta = new Venta(
                factura.getIdFactura(),
                i.getIdPelicula(), // ajusta tipo si tu entidad usa long
                i.getPrecio(),
                i.getCantidad()
            );
            ventaDao.save(venta);

            total += i.getCantidad() * i.getPrecio();
        }

        // 4) Actualizar total y guardar la factura
        factura.setTotal(total);
        facturaDao.save(factura);

        // 5) Limpiar carrito
        lista.clear();
        session.setAttribute("listaItems", lista);
    }

    @Override
    public double getTotal() {
        @SuppressWarnings("unchecked")
        List<Item> listaItems = (List<Item>) session.getAttribute("listaItems");
        if (listaItems == null || listaItems.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Item i : listaItems) {
            total += i.getCantidad() * i.getPrecio();
        }
        return total;
    }
}