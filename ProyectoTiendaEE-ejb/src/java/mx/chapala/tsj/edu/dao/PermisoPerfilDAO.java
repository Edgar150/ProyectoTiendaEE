/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.chapala.tsj.edu.modelo.Permisoperfil;

/**
 *
 * @author edgar
 */
public class PermisoPerfilDAO implements Serializable{
    
    private EntityManager em ;
    
    public PermisoPerfilDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");//este nombre se saco del archivo llamado persistence.xml
        em=emf.createEntityManager();
    }
    
    public boolean crear(Permisoperfil permisoPerfil){
        //Faltan Validaciones.
        em.getTransaction().begin();
        em.persist(permisoPerfil); //Guardar
        em.getTransaction().commit();
    return true;
    }
    public boolean editar(Permisoperfil permisoPerfil){
        if (permisoPerfil.getId()==null) {
            return false;
        }else{
        em.getTransaction().begin();
        em.merge(permisoPerfil); //Actualiza
        em.getTransaction().commit();
        return true;
        
        }
    }
    public boolean eliminar(Permisoperfil permisoPerfil){
        em.getTransaction().begin();
        em.remove(em.merge(permisoPerfil));
        em.getTransaction().commit();
        return true;
    }
    public Permisoperfil getPorId(int id){
        Query q = em.createNamedQuery("Permisoperfil.findById");
        q.setParameter("id", id);
        if(!q.getResultList().isEmpty()){
            
            return (Permisoperfil)q.getResultList().get(0);//lista de resultados obtiene el primero
        
        }
        return null;
    }
   
    
    public List<Permisoperfil> getTodo(){
         Query q = em.createNamedQuery("Permisoperfil.findAll");
        return q.getResultList();
    }
}
