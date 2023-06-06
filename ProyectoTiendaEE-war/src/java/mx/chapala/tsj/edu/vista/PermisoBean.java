/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.vista;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import mx.chapala.tsj.edu.bl.PermisoBLLocal;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Permisos;

/**
 *
 * @author edgar
 */
@Named(value = "permisoBean")
@SessionScoped
public class PermisoBean implements Serializable {

    @EJB
    private PermisoBLLocal permisoBL;
    
    private Permisos permiso = new Permisos();
    
    private String titulo="Nuevo Permiso";
    
    /**
     * Creates a new instance of PermisoBean
     */
    public PermisoBean() {
    }

    public Permisos getPermiso() {
        return permiso;
    }

    public void setPermiso(Permisos permiso) {
        this.permiso = permiso;
    }
    
    public String agregar(){
        System.out.println("se agrego con exito!!!");
        permisoBL.agregar(permiso);
        permiso=new Permisos();
        return "PrmisosLista.xhtml";
    }
    
    public String editar(){
        System.out.println("se edito con exito!!!");
        permisoBL.editar(permiso);
        permiso=new Permisos();
        return "PrmisosLista.xhtml";
    }
    public String eliminar (){
        System.out.println("se elimino con exito!!!");
        permiso.setTipoPermiso("xxxxxxx");
        permisoBL.eliminar(permiso);
        permiso=new Permisos();
        return "PrmisosLista.xhtml";
    }
    
    public List<Permisos> getPermisosAll(){
        return permisoBL.getTodo();
    }
    
    public String moduloPermisos(){
        return "PrmisosLista.xhtml";
    }
    
    public void prepararEditar(Permisos p){
        titulo="Editando un Permiso";
        permiso = p;
    }
    
    public void prepararNuevo(){
        titulo="Agregar Permiso";
        permiso=new Permisos();
    }
    
    public void prepararEliminar(Permisos p){
        permiso = p;
    }

    public String getTitulo() {
        return titulo;
    }
     
}
