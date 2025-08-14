/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import web.demo.domain.Categoria;

@Data
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long idPelicula;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    private String titulo;

    private double precio;   // o BigDecimal si prefieres

    private boolean activo;

    public Pelicula() {}
}