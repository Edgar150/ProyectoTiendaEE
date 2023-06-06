/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Local;
import mx.chapala.tsj.edu.modelo.Usuario;

/**
 *
 * @author edgar
 */
@Local
public interface UsuarioBLLocal {
    Codigo agregar(Usuario usuario);
    
    Codigo editar(Usuario usuario);
    
    Codigo eliminar(Usuario usuario);

    Usuario buscarPorID(int id);

    List<Usuario> getTodo();
}
