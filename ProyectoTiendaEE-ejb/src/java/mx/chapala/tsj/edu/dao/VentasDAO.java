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
import mx.chapala.tsj.edu.modelo.Ventas;

/**
 *
 * @author edgar
 */
public class VentasDAO implements Serializable{
    private EntityManager em ;
    
    public VentasDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");
        em=emf.createEntityManager();
    }
    
    public boolean crear(Ventas venta){
        em.getTransaction().begin();
        em.persist(venta); 
        em.getTransaction().commit();
    return true;
    }
    public boolean editar(Ventas venta){
        if (venta.getId()==null) {
            return false;
        }else{
        em.getTransaction().begin();
        em.merge(venta); 
        em.getTransaction().commit();
        return true;
        
        }
    }
    public boolean eliminar(Ventas venta){
        em.getTransaction().begin();
        em.remove(em.merge(venta));
        em.getTransaction().commit();
        return true;
    }
    public Ventas getPorId(int id){
        Query q = em.createNamedQuery("Ventas.findById");
        q.setParameter("id", id);
        if(!q.getResultList().isEmpty()){       
            return (Ventas)q.getResultList().get(0);
        }
        return null;
    }
    
    public List<Ventas> getTodo(){
         Query q = em.createNamedQuery("Ventas.findAll");
        return q.getResultList();
    }
}
