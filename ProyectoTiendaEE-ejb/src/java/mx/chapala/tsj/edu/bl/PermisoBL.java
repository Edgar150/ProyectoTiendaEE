/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Stateless;
import mx.chapala.tsj.edu.dao.PermisoDAO;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Permisos;

/**
 *
 * @author edgar
 */
@Stateless
public class PermisoBL implements PermisoBLLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Codigo agregar(Permisos permiso) {
        //Hacer las comprobaciones necesarias
        //aplicar las politicas del negocio
        //Se conecta a la BD
        PermisoDAO permisoDAO =new PermisoDAO();
        permisoDAO.crear(permiso);
        
        return Codigo.NADA;
    }
    
    @Override
    public Codigo editar(Permisos permiso) {
        PermisoDAO permisosDAO =new PermisoDAO();
       permisosDAO.editar(permiso);
        return Codigo.NADA;
    }
    
    @Override
    public Codigo eliminar(Permisos permiso) {
        PermisoDAO permisosDAO =new PermisoDAO();
        permisosDAO.eliminar(permiso);
        return Codigo.NADA;
    }

    @Override
    public Permisos buscarPorID(int id) {
        PermisoDAO pd = new PermisoDAO();
        
        return pd.getPorId(id);
    }

    @Override
    public List<Permisos> getTodo() {
        PermisoDAO pdao = new PermisoDAO();
        return pdao.getTodos();
    }
    
}
