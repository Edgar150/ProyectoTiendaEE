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
import mx.chapala.tsj.edu.bl.PerfilBLLocal;
import mx.chapala.tsj.edu.bl.PermisoBLLocal;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Perfil;
import mx.chapala.tsj.edu.modelo.Permisoperfil;

/**
 *
 * @author edgar
 */
@Named(value = "perfilBean")
@SessionScoped
public class PerfilBean implements Serializable {

    @EJB
    private PermisoBLLocal permisoBL;

    @EJB
    private PerfilBLLocal perfilBL;
    
    private Perfil perfil;
    private List<Permisoperfil> listaPermisoPerfil;
    
    private int idpermisoseleccionado;
    
    private String titulo ="Nuevo Perfil";
    /**
     * Creates a new instance of PerfilBean
     */
    public PerfilBean() {
    }
    
    public String agregar(){
        System.out.println("se agrego con exito!!!");
        
        for(Permisoperfil pp : listaPermisoPerfil){
            pp.setPerfilid(perfil);
        }
        
        perfil.setPermisoperfilList(listaPermisoPerfil);
        
        Codigo c = perfilBL.agregar(perfil);
        
        
        return "PerfilesLista.xhtml";

/*
esto es lo que tenia..
perfilBL.agregar(perfil);
            perfil = new Perfil();
            return "PerfilesLista.xhtml";
        */
    }
    
    public String moficar(){
            perfilBL.modificar(perfil);
            perfil = new Perfil();
            return "PerfilesLista.xhtml";
//        Perfil p = perfilBL.buscarPorID(1);//un id existente en la bd
//        p.setNombre("Perfil numero 2");
//        perfilBL.modificar(p);
//        return "index.xhtml";
    }
    
    public String eliminar(){
        perfil.setNombre("xxxx");
        perfil.setDescripcion("xxxx");
        perfilBL.eliminar(perfil);
            perfil = new Perfil();
            return "PerfilesLista.xhtml";
//        System.out.println("se elimino con exito!!!");
//        
//        Perfil p = new Perfil(2,"admin","todos");
//        Codigo c = perfilBL.eliminar(p);
//        
//        
//        return "index.xhtml";
    }
    public String moduloPerfiles(){
        return "PerfilesLista.xhtml";
    }
    //este metodo se utiliza para el template 
    public List<Perfil> getPerfilesAll(){
       return perfilBL.getTodos();
    }

    public List<Permisoperfil> getListaPermisoPerfil() {
        return listaPermisoPerfil;
    }

    public int getIdpermisoseleccionado() {
        return idpermisoseleccionado;
    }

    public void setIdpermisoseleccionado(int idpermisoseleccionado) {
        this.idpermisoseleccionado = idpermisoseleccionado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public void prepararEditar(Perfil p){
        titulo="Editando un Perfil";
        perfil = p;
    }
    public void prepararEliminar(Perfil p){
        perfil = p;
    }
    public void prepararNuevo(){
        titulo="Nuevo perfil";
        perfil = new Perfil();
        listaPermisoPerfil= new ArrayList<>();
    }
    public String getTitulo() {
        return titulo;
    }
    
    public void agregarpermiso(){
        Permisoperfil pp = new Permisoperfil();
        pp.setPermisosid(permisoBL.buscarPorID(idpermisoseleccionado));
        listaPermisoPerfil.add(pp);
        
    }
}
