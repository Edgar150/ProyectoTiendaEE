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
import mx.chapala.tsj.edu.modelo.Cortecaja;

/**
 *
 * @author edgar
 */
public class CorteCajaDAO implements Serializable  {
    private EntityManager em;

    public CorteCajaDAO() {//Creamos el constructor
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");
        em = emf.createEntityManager();//Con esto ya se conecta a la base de datos y se crea bien la consulta
    }

    public boolean crear(Cortecaja cortecaja) {
        //Faltan validaciones
        em.getTransaction().begin();
        em.persist(cortecaja);//Guarda
        em.getTransaction().commit();        
        return true;
    }

    public boolean editar(Cortecaja cortecaja) {
        if (cortecaja.getId()== null) {//Valida si es un id nulo no se puede
            return false;
        } else {
            em.getTransaction().begin();
            em.merge(cortecaja);//Actualizar
            em.getTransaction().commit();
            return true;
        }
    }

    public boolean eliminar(Cortecaja cortecaja) {
        em.getTransaction().begin();
        em.remove(em.merge(cortecaja));//Remueve si esta actualizado
        em.getTransaction().commit();
        return true;
    }

    public Cortecaja getPorId(int id) {
        Query q = em.createNamedQuery("Cortecaja.findById");//Creando una consulta
        q.setParameter("id", id);
        if (!q.getResultList().isEmpty()) {//revisa si no es nulo que valla a getResult y retorne un valor
            return (Cortecaja) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public List<Cortecaja> getTodos() {
        Query q = em.createNamedQuery("Cortecaja.findAll");
        return q.getResultList();
    }
}
