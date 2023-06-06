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
import mx.chapala.tsj.edu.modelo.Producto;

/**
 *
 * @author edgar
 */
public class ProductoDAO implements Serializable{
             private EntityManager em ;
    
    public ProductoDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");//este nombre se saco del archivo llamado persistence.xml
        em=emf.createEntityManager();
    }
    
    public boolean crear(Producto producto){
        //Faltan Validaciones.
        em.getTransaction().begin();
        em.persist(producto); //Guardar
        em.getTransaction().commit();
    return true;
    }
    public boolean editar(Producto producto){
        if (producto.getId()==null) {
            return false;
        }else{
        em.getTransaction().begin();
        em.merge(producto); //Actualiza
        em.getTransaction().commit();
        return true;
        
        }
    }
    public boolean eliminar(Producto producto){
        em.getTransaction().begin();
        em.remove(em.merge(producto));
        em.getTransaction().commit();
        return true;
    }
    public Producto getPorId(int id){
        Query q = em.createNamedQuery("Producto.findById");
        q.setParameter("id", id);
        if(!q.getResultList().isEmpty()){
            
            return (Producto)q.getResultList().get(0);//lista de resultados obtiene el primero
        
        }
        return null;
    }
    public Producto getPorClave(int clave){
         Query q = em.createNamedQuery("Producto.findByClave");
        q.setParameter("clave", clave);
        if(!q.getResultList().isEmpty()){
            
            return (Producto)q.getResultList().get(0);//lista de resultados obtiene el primero
        
        }
        return null;
    }
    
    public Producto getPorExistencia(int existencia){
         Query q = em.createNamedQuery("Producto.findByExistencia");
        q.setParameter("existencia", existencia);
        if(!q.getResultList().isEmpty()){
            
            return (Producto)q.getResultList().get(0);//lista de resultados obtiene el primero
        
        }
        return null;
    }
    
    public List<Producto> getTodo(){
         Query q = em.createNamedQuery("Producto.findAll");
        return q.getResultList();
    }
}
