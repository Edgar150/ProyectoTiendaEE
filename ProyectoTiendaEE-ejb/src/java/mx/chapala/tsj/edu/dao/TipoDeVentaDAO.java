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
import mx.chapala.tsj.edu.modelo.Tipodeventa;

/**
 *
 * @author edgar
 */
public class TipoDeVentaDAO implements Serializable {
     private EntityManager em ;
    
    public TipoDeVentaDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");//este nombre se saco del archivo llamado persistence.xml
        em=emf.createEntityManager();
    }
    
    public boolean crear(Tipodeventa tipodeventa){
        //Faltan Validaciones.
        em.getTransaction().begin();
        em.persist(tipodeventa); //Guardar
        em.getTransaction().commit();
    return true;
    }
    public boolean editar(Tipodeventa tipodeventa){
        if (tipodeventa.getId()==null) {
            return false;
        }else{
        em.getTransaction().begin();
        em.merge(tipodeventa); //Actualiza
        em.getTransaction().commit();
        return true;
        
        }
    }
    public boolean eliminar(Tipodeventa tipodeventa){
        em.getTransaction().begin();
        em.remove(em.merge(tipodeventa));
        em.getTransaction().commit();
        return true;
    }
    public Tipodeventa getPorId(int id){
        Query q = em.createNamedQuery("Tipodeventa.findById");
        q.setParameter("id", id);
        if(!q.getResultList().isEmpty()){
            
            return (Tipodeventa)q.getResultList().get(0);//lista de resultados obtiene el primero
        
        }
        return null;
    }
   
    
    public List<Tipodeventa> getTodo(){
         Query q = em.createNamedQuery("Tipodeventa.findAll");
        return q.getResultList();
    }
}
