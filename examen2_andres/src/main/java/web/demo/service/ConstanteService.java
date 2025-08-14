/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.demo.service;

import java.util.List;
import web.demo.domain.Constante;

public interface ConstanteService {
    
    //Se obtiene un listado de registro de la tabla constante
    //en un array list de objetos Constante
    //Todos o sólo los activos...
    public List<Constante> getConstantes();
    
    public Constante getConstante(Constante constante);
    
    public Constante getConstantePorAtributo(String atributo);
    
    public void save(Constante constante);
    
    public void delete(Constante constante);
}