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
import mx.chapala.tsj.edu.modelo.Perfil;

/**
 *
 * @author edgar
 */
public class PerfilDAO implements Serializable {
    private EntityManager em ;
    
    public PerfilDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");//este nombre se saco del archivo llamado persistence.xml
        em=emf.createEntityManager();
    }
    
    public boolean crear(Perfil perfil){
        //Faltan Validaciones.
        em.getTransaction().begin();
        em.persist(perfil); //Guardar
        em.getTransaction().commit();
    return true;
    }
    public boolean editar(Perfil perfil){
        if (perfil.getId()==null) {
            return false;
        }else{
        em.getTransaction().begin();
        em.merge(perfil); //Actualiza
        em.getTransaction().commit();
        return true;
        
        }
    }
    public boolean eliminar(Perfil perfil){
        em.getTransaction().begin();
        em.remove(em.merge(perfil));
        em.getTransaction().commit();
        return true;
    }
    public Perfil getPorId(int id){
        Query q = em.createNamedQuery("Perfil.findById");
        q.setParameter("id", id);
        if(!q.getResultList().isEmpty()){
            
            return (Perfil)q.getResultList().get(0);//lista de resultados obtiene el primero
        
        }
        return null;
    }
    public Perfil getPorNombre(String nombre){
        Query q = em.createNamedQuery("Perfil.findByNombre");
        q.setParameter("nombre", nombre);
        if(!q.getResultList().isEmpty()){
            
            return (Perfil)q.getResultList().get(0);//lista de resultados obtiene el primero
        
        }
        return null;
    }
    public Perfil getPorPermisos(String permisos){
        Query q = em.createNamedQuery("Perfil.findByPermisos");
        q.setParameter("permisos", permisos);
        if(!q.getResultList().isEmpty()){
            
            return (Perfil)q.getResultList().get(0);//lista de resultados obtiene el primero
        
        }
        return null;
    }
    
    public List<Perfil> getTodo(){
         Query q = em.createNamedQuery("Perfil.findAll");
        return q.getResultList();
    }
}
