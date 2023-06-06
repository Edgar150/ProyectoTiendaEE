/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Stateless;
import mx.chapala.tsj.edu.dao.ProductoDAO;
import mx.chapala.tsj.edu.modelo.Producto;

/**
 *
 * @author edgar
 */
@Stateless
public class ProductoBL implements ProductoBLLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public Codigo agregar(Producto producto){
       if(producto==null){
            return Codigo.ENTIDAD_NULA;
        }
        ProductoDAO productoDAO =new ProductoDAO();
        //Producto tmp = productoDAO.getPorId(producto.getId());
        //if(tmp!=null){
          //  return Codigo.ID_DUPLICADO;
        //}
        productoDAO.crear(producto);
        
        return Codigo.NADA;
    }
    
    @Override
    public Codigo editar(Producto producto) {
        ProductoDAO productoDAO =new ProductoDAO();
        productoDAO.editar(producto);
        return Codigo.NADA;
    }
    
    @Override
    public Codigo eliminar(Producto producto) {
        ProductoDAO productoDAO =new ProductoDAO();
        productoDAO.eliminar(producto);
        return Codigo.NADA;
    }
    
    @Override
    public Producto buscarporID(int id){
        ProductoDAO pd = new ProductoDAO();
        return pd.getPorId(id);
    }
    
    @Override
    public Producto buscarporClave(int clave){
        ProductoDAO pd = new ProductoDAO();
        return pd.getPorClave(clave);
    }
    
    @Override
    public Producto buscarporExistencia(int existencia){
        ProductoDAO pd = new ProductoDAO();
        return pd.getPorExistencia(existencia);
    }
    
    @Override
    public List<Producto> getTodo() {
        ProductoDAO pd = new ProductoDAO();
        return pd.getTodo();
    }
}
