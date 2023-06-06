/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Local;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Permisos;

/**
 *
 * @author edgar
 */
@Local
public interface PermisoBLLocal {
    Codigo agregar(Permisos permiso);
    
    Codigo editar(Permisos permiso);
    
    Codigo eliminar(Permisos permiso);

    Permisos buscarPorID(int id);

    List<Permisos> getTodo();
}
