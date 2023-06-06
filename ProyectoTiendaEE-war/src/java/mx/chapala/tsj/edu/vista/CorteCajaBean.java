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
import javax.swing.JOptionPane;
import mx.chapala.tsj.edu.bl.CorteCajaBLLocal;
import mx.chapala.tsj.edu.bl.TipoDePagoBLLocal;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Cortecaja;
import mx.chapala.tsj.edu.modelo.Perfil;
import mx.chapala.tsj.edu.modelo.Tipodeventa;

/**
 *
 * @author edgar
 */
@Named(value = "corteCajaBean")
@SessionScoped
public class CorteCajaBean implements Serializable{

    @EJB
    private TipoDePagoBLLocal tipoDePagoBL;

    @EJB
    private CorteCajaBLLocal corteCajaBL;
    
    private Cortecaja cortecaja;
    private List<Tipodeventa> listaTipodeventa;
    
    private int idtipodepagoseleccionado;
    private int bandera = 0;

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
    
    
    private String titulo ="Nuevo Corte de caja";
    /**
     * Creates a new instance of CorteCajaBean
     */
    public CorteCajaBean() {
    }
    public String agregar(){
        System.out.println("se agrego con exito!!!");
        
        for(Tipodeventa tv : listaTipodeventa){
            tv.setCorteCajaid(cortecaja);
        }
        
        
        
        
        Codigo c = corteCajaBL.agregar(cortecaja);
        
        
        return "CortecajaLista.xhtml";
    }
    
    public String moficar(){
            corteCajaBL.editar(cortecaja);
            cortecaja = new Cortecaja();
            return "CortecajaLista.xhtml";

    }
    
    public String eliminar(){
        cortecaja.setIngresado(0.0f);
        cortecaja.setRetirado(0.0f);
        cortecaja.setTotal(0.0f);
        corteCajaBL.eliminar(cortecaja);
            cortecaja = new Cortecaja();
            return "CortecajaLista.xhtml";
    }
    public String moduloCortecaja(){
        return "CortecajaLista.xhtml";
    }
    //este metodo se utiliza para el template 
    public List<Cortecaja> getCortecajaAll(){
       return corteCajaBL.getTodo();
    }

    public List<Tipodeventa> getListaTipodeventa() {
        return listaTipodeventa;
    }

    public int getIdtipodepagoseleccionado() {
        return idtipodepagoseleccionado;
    }

    public void setIdtipodepagoseleccionado(int idtipodepagoseleccionado) {
        this.idtipodepagoseleccionado = idtipodepagoseleccionado;
    }

    public Cortecaja getCortecaja() {
        return cortecaja;
    }

    public void setCortecaja(Cortecaja cortecaja) {
        this.cortecaja = cortecaja;
    }

    public void prepararEditar(Cortecaja c){
        titulo="Editando un Corte de caja";
        cortecaja = c;
    }
    public void prepararEliminar(Cortecaja c){
        cortecaja = c;
    }
    public void prepararNuevo(){
        titulo="Nuevo Corte";
        cortecaja = new Cortecaja();
        listaTipodeventa= new ArrayList<>();
    }
    public String getTitulo() {
        return titulo;
    }
    
    public void agregarTipodepago(){
        cortecaja.setTipodeventaList(listaTipodeventa);
        bandera = 0;
        if(cortecaja.getRetirado()<cortecaja.getIngresado()){
            cortecaja.setTotal(cortecaja.getIngresado()-cortecaja.getRetirado());
        
        }else{
           bandera = 1; 
        }
        Tipodeventa tv = new Tipodeventa();
        tv.setTipoDePagoid(tipoDePagoBL.buscarPorID(idtipodepagoseleccionado));
        listaTipodeventa.add(tv);
        
    }
}
