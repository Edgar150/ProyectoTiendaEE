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
import mx.chapala.tsj.edu.modelo.Tipodepago;

/**
 *
 * @author edgar
 */
public class TipoDePagoDAO implements Serializable{
    private EntityManager em;

    public TipoDePagoDAO() {//Creamos el constructor
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");
        em = emf.createEntityManager();//Con esto ya se conecta a la base de datos y se crea bien la consulta
    }

    public boolean crear(Tipodepago tipodepago) {
        //Faltan validaciones
        em.getTransaction().begin();
        em.persist(tipodepago);//Guarda
        em.getTransaction().commit();        
        return true;
    }

    public boolean editar(Tipodepago tipodepago) {
        if (tipodepago.getId()== null) {//Valida si es un id nulo no se puede
            return false;
        } else {
            em.getTransaction().begin();
            em.merge(tipodepago);//Actualizar
            em.getTransaction().commit();
            return true;
        }
    }

    public boolean eliminar(Tipodepago tipodepago) {
        em.getTransaction().begin();
        em.remove(em.merge(tipodepago));//Remueve si esta actualizado
        em.getTransaction().commit();
        return true;
    }

    public Tipodepago getPorId(int id) {
        Query q = em.createNamedQuery("Tipodepago.findById");//Creando una consulta
        q.setParameter("id", id);
        if (!q.getResultList().isEmpty()) {//revisa si no es nulo que valla a getResult y retorne un valor
            return (Tipodepago) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public List<Tipodepago> getTodos() {
        Query q = em.createNamedQuery("Tipodepago.findAll");
        return q.getResultList();
    }
}
