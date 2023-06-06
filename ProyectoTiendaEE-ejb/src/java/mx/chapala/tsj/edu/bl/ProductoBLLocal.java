/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Local;
import mx.chapala.tsj.edu.modelo.Producto;

/**
 *
 * @author edgar
 */
@Local
public interface ProductoBLLocal {
    Codigo agregar(Producto producto);
    
    Codigo editar(Producto producto);
    
    Codigo eliminar(Producto producto);
    
    List<Producto> getTodo();

    Producto buscarporID(int id);
    
    Producto buscarporClave(int clave);
    
    Producto buscarporExistencia(int existencia);

}
