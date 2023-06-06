/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Local;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Detalleventa;

/**
 *
 * @author edgar
 */
@Local
public interface DetalleVentaBLLocal {
    Codigo agregar(Detalleventa detalleventa);
    Codigo editar(Detalleventa detalleventa);
    Codigo eliminar(Detalleventa detalleventa);
    List<Detalleventa> getTodos();
}
