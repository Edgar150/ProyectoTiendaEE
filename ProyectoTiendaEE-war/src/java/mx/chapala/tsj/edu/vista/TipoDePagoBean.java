/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import mx.chapala.tsj.edu.bl.TipoDePagoBLLocal;
import mx.chapala.tsj.edu.bl.VentasBLLocal;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Tipodepago;

/**
 *
 * @author edgar
 */
@Named(value = "tipoDePagoBean")
@SessionScoped
public class TipoDePagoBean implements Serializable{

    
    @EJB
    private TipoDePagoBLLocal tipoDePagoBL;
    
    private Tipodepago tipodepago = new Tipodepago();
    
    private String titulo="Nuevo Tipo de pago";

    /**
     * Creates a new instance of TipoDePagoBean
     */
    public TipoDePagoBean() {
    }

    public Tipodepago getTipodepago() {
        return tipodepago;
    }

    public void setTipodepago(Tipodepago tipodepago) {
        this.tipodepago = tipodepago;
    }
    
    
    public String agregar(){
        System.out.println("se agrego con exito!!!");
        tipoDePagoBL.agregar(tipodepago);
        tipodepago=new Tipodepago();
        return "TipodepagoLista.xhtml";
    }
    
    public String editar(){
        System.out.println("se edito con exito!!!");
        tipoDePagoBL.editar(tipodepago);
        tipodepago=new Tipodepago();
        return "TipodepagoLista.xhtml";
    }
    public String eliminar (){
        System.out.println("se elimino con exito!!!");
        tipodepago.setTipodepago("xxxxxxx");
        tipoDePagoBL.eliminar(tipodepago);
        tipodepago=new Tipodepago();
        return "TipodepagoLista.xhtml";
    }
    
    public List<Tipodepago> getTipodepagoAll(){
        return tipoDePagoBL.getTodo();
    }
    
    public String moduloTipodepago(){
        return "TipodepagoLista.xhtml";
    }
    
    public void prepararEditar(Tipodepago t){
        titulo="Editando Tipo de pago.";
        tipodepago = t;
    }
    
    public void prepararNuevo(){
        titulo="Agregar Tipo de pago";
        tipodepago=new Tipodepago();
    }
    
    public void prepararEliminar(Tipodepago t){
        tipodepago = t;
    }

    public String getTitulo() {
        return titulo;
    }

}
