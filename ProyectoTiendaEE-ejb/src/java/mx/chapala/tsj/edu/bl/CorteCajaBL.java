/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Stateless;
import mx.chapala.tsj.edu.dao.CorteCajaDAO;
import mx.chapala.tsj.edu.dao.TipoDeVentaDAO;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Cortecaja;

/**
 *
 * @author edgar
 */
@Stateless
public class CorteCajaBL implements CorteCajaBLLocal {

    @Override
    public Codigo agregar(Cortecaja cortecaja) {
        CorteCajaDAO cd=new CorteCajaDAO();
        cd.crear(cortecaja);
        
        TipoDeVentaDAO tvd= new TipoDeVentaDAO();
        /*
        for(Permisoperfil ppf : perfil.getPermisoperfilList()){
            ppfd.crear(ppf);
        }
        */
        return Codigo.NADA;
    }
    
    @Override
    public Codigo editar(Cortecaja cortecaja) {
        CorteCajaDAO cortecajaDAO =new CorteCajaDAO();
       cortecajaDAO.editar(cortecaja);
        return Codigo.NADA;
    }
    
    @Override
    public Codigo eliminar(Cortecaja cortecaja) {
        CorteCajaDAO cortecajaDAO =new CorteCajaDAO();
        cortecajaDAO.eliminar(cortecaja);
        return Codigo.NADA;
    }

    @Override
    public Cortecaja buscarPorID(int id) {
        CorteCajaDAO pd = new CorteCajaDAO();
        
        return pd.getPorId(id);
    }

    @Override
    public List<Cortecaja> getTodo() {
        CorteCajaDAO pdao = new CorteCajaDAO();
        return pdao.getTodos();
    }
}
