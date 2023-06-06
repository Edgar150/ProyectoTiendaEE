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
import mx.chapala.tsj.edu.bl.UsuarioBLLocal;
import mx.chapala.tsj.edu.modelo.Usuario;

/**
 *
 * @author edgar
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioBLLocal usuarioBL;
    
    private Usuario usuario = new Usuario();
    
    private String titulo="Nuevo Usuario";

    
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String agregar(){
        System.out.println("se agrego con exito!!!");
        usuarioBL.agregar(usuario);
        usuario=new Usuario();
        return "UsuarioLista.xhtml";
    }
    
    public String editar(){
        System.out.println("se edito con exito!!!");
        usuarioBL.editar(usuario);
        usuario=new Usuario();
        return "UsuarioLista.xhtml";
    }
    public String eliminar (){
        System.out.println("se elimino con exito!!!");
        usuario.setUsuario("xxxxxxx");
        usuario.setNombreUsuario("xxxxxxx");
        usuario.setPasswordUsuario("xxxxxxx");
        usuario.setDireccion("xxxxxxx");
        usuario.setMunicipio("xxxxxxx");
        
        usuarioBL.eliminar(usuario);
        usuario=new Usuario();
        return "UsuarioLista.xhtml";
    }
    
    public List<Usuario> getUsuarioAll(){
        return usuarioBL.getTodo();
    }
    
    public String moduloUsuario(){
        return "UsuarioLista.xhtml";
    }
    
    public void prepararEditar(Usuario u){
        titulo="Editando un Permiso";
        usuario = u;
    }
    
    public void prepararNuevo(){
        titulo="Agregar Usuario";
        usuario=new Usuario();
    }
    
    public void prepararEliminar(Usuario u){
        usuario = u;
    }

    public String getTitulo() {
        return titulo;
    }
    
}
