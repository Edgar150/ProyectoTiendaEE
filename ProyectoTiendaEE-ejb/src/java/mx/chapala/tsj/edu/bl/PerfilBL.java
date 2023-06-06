/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.bl;

import java.util.List;
import javax.ejb.Stateless;
import mx.chapala.tsj.edu.dao.PerfilDAO;
import mx.chapala.tsj.edu.dao.PermisoPerfilDAO;
import mx.chapala.tsj.edu.error.Codigo;
import mx.chapala.tsj.edu.modelo.Perfil;

/**
 *
 * @author edgar
 */
@Stateless
public class PerfilBL implements PerfilBLLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Codigo agregar(Perfil perfil) {
        
        PerfilDAO pd=new PerfilDAO();
        pd.crear(perfil);//Se guarda el perfil en la bd
        
        PermisoPerfilDAO ppfd= new PermisoPerfilDAO();
        /*
        for(Permisoperfil ppf : perfil.getPermisoperfilList()){
            ppfd.crear(ppf);
        }
        */
        return Codigo.NADA;
    }
    
    @Override
    public Codigo modificar(Perfil perfil) {
        PerfilDAO perfilDAO =new PerfilDAO();
        perfilDAO.editar(perfil);
        return Codigo.NADA;
    }
    
    @Override
    public Codigo eliminar(Perfil perfil) {
        PerfilDAO perfilDAO =new PerfilDAO();
        Perfil tmp = perfilDAO.getPorId(perfil.getId());
        perfilDAO.eliminar(perfil);
        return Codigo.NADA;
    }

    @Override
    public Perfil buscarPorID(int id) {
        PerfilDAO pd = new PerfilDAO();
        return pd.getPorId(id);
    }

    @Override
    public List<Perfil> getTodos() {
        PerfilDAO pdao = new PerfilDAO();
        return pdao.getTodo();
       
    }
    
    
}
