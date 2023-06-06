/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import mx.chapala.tsj.edu.bl.DetalleVentaBLLocal;
import mx.chapala.tsj.edu.modelo.Detalleventa;

/**
 *
 * @author edgar
 */
@Named(value = "detalleVentaBean")
@SessionScoped
public class DetalleVentaBean implements Serializable {

    @EJB
    private DetalleVentaBLLocal detalleVentaBL;

    
    /**
     * Creates a new instance of DetalleVentaBean
     */
    public DetalleVentaBean() {
    }
    public List<Detalleventa> getVentaAll() {

        return detalleVentaBL.getTodos();
    }
}
