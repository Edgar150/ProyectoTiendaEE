/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Local;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Tipodepago;

/**
 *
 * @author edgar
 */
@Local
public interface TipoDePagoBLLocal {
    Codigo agregar(Tipodepago tipodepago);
    
    Codigo editar(Tipodepago tipodepago);
    
    Codigo eliminar(Tipodepago tipodepago);

    Tipodepago buscarPorID(int id);

    List<Tipodepago> getTodo();
    
}
