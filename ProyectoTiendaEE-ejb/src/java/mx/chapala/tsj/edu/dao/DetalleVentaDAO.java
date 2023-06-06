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
import mx.chapala.tsj.edu.modelo.Detalleventa;

/**
 *
 * @author edgar
 */
public class DetalleVentaDAO implements Serializable {
    private EntityManager em ;
    
    public DetalleVentaDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");
        em=emf.createEntityManager();
    }
    
    public boolean crear(Detalleventa detalleventa){
        em.getTransaction().begin();
        em.persist(detalleventa); 
        em.getTransaction().commit();
    return true;
    }
    public boolean editar(Detalleventa detalleventa){
        if (detalleventa.getId()==null) {
            return false;
        }else{
        em.getTransaction().begin();
        em.merge(detalleventa); 
        em.getTransaction().commit();
        return true;
        
        }
    }
    public boolean eliminar(Detalleventa detalleventa){
        em.getTransaction().begin();
        em.remove(em.merge(detalleventa));
        em.getTransaction().commit();
        return true;
    }
    public Detalleventa getPorId(int id){
        Query q = em.createNamedQuery("Detalleventa.findById");
        q.setParameter("id", id);
        if(!q.getResultList().isEmpty()){       
            return (Detalleventa)q.getResultList().get(0);
        }
        return null;
    }
    
    public List<Detalleventa> getTodo(){
         Query q = em.createNamedQuery("Detalleventa.findAll");
        return q.getResultList();
    }
}
