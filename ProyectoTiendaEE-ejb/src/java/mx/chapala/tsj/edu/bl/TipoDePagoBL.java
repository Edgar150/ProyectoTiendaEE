/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Stateless;
import mx.chapala.tsj.edu.dao.DetalleVentaDAO;
import mx.chapala.tsj.edu.dao.TipoDePagoDAO;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Detalleventa;
import mx.chapala.tsj.edu.modelo.Tipodepago;

/**
 *
 * @author edgar
 */
@Stateless
public class TipoDePagoBL implements TipoDePagoBLLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Codigo agregar(Tipodepago tipodepago) {
        //Hacer las comprobaciones necesarias
        //aplicar las politicas del negocio
        //Se conecta a la BD
        TipoDePagoDAO tipodepagoDAO =new TipoDePagoDAO();
        tipodepagoDAO.crear(tipodepago);
        
        return Codigo.NADA;
    }
    
    @Override
    public Codigo editar(Tipodepago tipodepago) {
        TipoDePagoDAO tipodepagoDAO =new TipoDePagoDAO();
       tipodepagoDAO.editar(tipodepago);
        return Codigo.NADA;
    }
    
    @Override
    public Codigo eliminar(Tipodepago tipodepago) {
        TipoDePagoDAO tipodepagoDAO =new TipoDePagoDAO();
        tipodepagoDAO.eliminar(tipodepago);
        return Codigo.NADA;
    }

    @Override
    public Tipodepago buscarPorID(int id) {
        TipoDePagoDAO tdpd = new TipoDePagoDAO();
        
        return tdpd.getPorId(id);
    }

    @Override
    public List<Tipodepago> getTodo() {
        TipoDePagoDAO pdao = new TipoDePagoDAO();
        return pdao.getTodos();
    }
    
}
