/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Stateless;
import mx.chapala.tsj.edu.dao.UsuarioDAO;
import mx.chapala.tsj.edu.modelo.Usuario;

/**
 *
 * @author edgar
 */
@Stateless
public class UsuarioBL implements UsuarioBLLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Codigo agregar(Usuario usuario) {
        //Hacer las comprobaciones necesarias
        //aplicar las politicas del negocio
        //Se conecta a la BD
        UsuarioDAO usuarioDAO =new UsuarioDAO();
        usuarioDAO.crear(usuario);
        
        return Codigo.NADA;
    }
    
    @Override
    public Codigo editar(Usuario usuario) {
        UsuarioDAO permisosDAO =new UsuarioDAO();
       permisosDAO.editar(usuario);
        return Codigo.NADA;
    }
    
    @Override
    public Codigo eliminar(Usuario usuario) {
        UsuarioDAO usuarioDAO =new UsuarioDAO();
        usuarioDAO.eliminar(usuario);
        return Codigo.NADA;
    }

    @Override
    public Usuario buscarPorID(int id) {
        UsuarioDAO ud = new UsuarioDAO();
        
        return ud.getPorId(id);
    }

    @Override
    public List<Usuario> getTodo() {
        UsuarioDAO udao = new UsuarioDAO();
        return udao.getTodos();
    }
}
