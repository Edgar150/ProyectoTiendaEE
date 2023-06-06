/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Local;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Perfil;

/**
 *
 * @author edgar
 */
@Local
public interface PerfilBLLocal {
    Codigo agregar(Perfil perfil);
    Codigo modificar(Perfil perfil);
    Codigo eliminar(Perfil perfil);
    Perfil buscarPorID(int id);
    List<Perfil> getTodos();
}
