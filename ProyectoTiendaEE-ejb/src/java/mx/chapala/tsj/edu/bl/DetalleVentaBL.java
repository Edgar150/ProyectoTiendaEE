/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Stateless;
import mx.chapala.tsj.edu.dao.DetalleVentaDAO;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Detalleventa;

/**
 *
 * @author edgar
 */
@Stateless
public class DetalleVentaBL implements DetalleVentaBLLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
    public Codigo agregar(Detalleventa detalleventa) {
//        //Hacer las comprobaciones necesarias
//        //aplicar las politicas del negocio
//        //Se conecta a la BD
//        if(detalleventa==null){
//            return Codigo.ENTIDAD_NULA;
//        }
//         DetalleVentaDAO detalleventaDAO =new DetalleVentaDAO();
//        Detalleventa tmp = detalleventaDAO.getPorId(detalleventa.getId());
//        if(tmp!=null){
//            return Codigo.ID_DUPLICADO;
//        }
//        detalleventaDAO.crear(detalleventa);
//        
//        return Codigo.NADA;
//        
        DetalleVentaDAO dev=new DetalleVentaDAO();
        dev.crear(detalleventa);//Se guarda el detalle de venta en la bd
        
        return Codigo.NADA;
    }
    
    @Override
    public Codigo editar(Detalleventa detalleventa) {
        DetalleVentaDAO detalleventaDAO =new DetalleVentaDAO();
        Detalleventa tmp = detalleventaDAO.getPorId(detalleventa.getId());
        detalleventaDAO.editar(detalleventa);
        return Codigo.NADA;
    }
    
    @Override
    public Codigo eliminar(Detalleventa detalleventa) {
        DetalleVentaDAO detalleventaDAO =new DetalleVentaDAO();
        Detalleventa tmp = detalleventaDAO.getPorId(detalleventa.getId());
        detalleventaDAO.eliminar(detalleventa);
        
        return Codigo.NADA;
    }
    @Override
    public List<Detalleventa> getTodos() {
        DetalleVentaDAO dvdao = new DetalleVentaDAO();
        return dvdao.getTodo();
       
    }
}
