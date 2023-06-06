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
import mx.chapala.tsj.edu.modelo.Permisos;

/**
 *
 * @author edgar
 */
public class PermisoDAO implements Serializable{
    private EntityManager em;

    public PermisoDAO() {//Creamos el constructor
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");
        em = emf.createEntityManager();//Con esto ya se conecta a la base de datos y se crea bien la consulta
    }

    public boolean crear(Permisos permiso) {
        //Faltan validaciones
        em.getTransaction().begin();
        em.persist(permiso);//Guarda
        em.getTransaction().commit();        
        return true;
    }

    public boolean editar(Permisos permiso) {
        if (permiso.getId()== null) {//Valida si es un id nulo no se puede
            return false;
        } else {
            em.getTransaction().begin();
            em.merge(permiso);//Actualizar
            em.getTransaction().commit();
            return true;
        }
    }

    public boolean eliminar(Permisos permiso) {
        em.getTransaction().begin();
        em.remove(em.merge(permiso));//Remueve si esta actualizado
        em.getTransaction().commit();
        return true;
    }

    public Permisos getPorId(int id) {
        Query q = em.createNamedQuery("Permisos.findById");//Creando una consulta
        q.setParameter("id", id);
        if (!q.getResultList().isEmpty()) {//revisa si no es nulo que valla a getResult y retorne un valor
            return (Permisos) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public Permisos getPorTipoPermiso(String tipoPermiso) {
        Query q = em.createNamedQuery("Permisos.findByTipoPermiso");
        q.setParameter("tipoPermiso", tipoPermiso);
        if (!q.getResultList().isEmpty()) {//revisa si no es nulo que valla a getResult y retorne un valor
            return (Permisos) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public List<Permisos> getTodos() {
        Query q = em.createNamedQuery("Permisos.findAll");
        return q.getResultList();
    }
}
