/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Stateless;
import mx.chapala.tsj.edu.dao.VentasDAO;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Ventas;

/**
 *
 * @author edgar
 */
@Stateless
public class VentasBL implements VentasBLLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Codigo agregar(Ventas ventas) {
        
        VentasDAO pd=new VentasDAO();
        pd.crear(ventas);//Se guarda el perfil en la bd
        
        //PermisoPerfilDAO ppfd= new PermisoPerfilDAO();
        /*
        for(Permisoperfil ppf : perfil.getPermisoperfilList()){
            ppfd.crear(ppf);
        }
        */
        return Codigo.NADA;
    }
    
    @Override
    public Codigo modificar(Ventas ventas) {
        VentasDAO perfilDAO =new VentasDAO();
        perfilDAO.editar(ventas);
        return Codigo.NADA;
    }
    
    @Override
    public Codigo eliminar(Ventas ventas) {
        VentasDAO ventasDAO =new VentasDAO();
        Ventas tmp = ventasDAO.getPorId(ventas.getId());
        ventasDAO.eliminar(ventas);
        return Codigo.NADA;
    }

    @Override
    public Ventas buscarPorID(int id) {
        VentasDAO pd = new VentasDAO();
        return pd.getPorId(id);
    }

    @Override
    public List<Ventas> getTodos() {
        VentasDAO vdao = new VentasDAO();
        return vdao.getTodo();
       
    }
}
