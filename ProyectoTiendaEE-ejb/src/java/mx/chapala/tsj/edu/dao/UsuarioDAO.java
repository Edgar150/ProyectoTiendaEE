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
import mx.chapala.tsj.edu.modelo.Usuario;

/**
 *
 * @author edgar
 */
public class UsuarioDAO implements Serializable{
    private EntityManager em;

    public UsuarioDAO() {//Creamos el constructor
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoTiendaEE-ejbPU");
        em = emf.createEntityManager();//Con esto ya se conecta a la base de datos y se crea bien la consulta
    }

    public boolean crear(Usuario usuario) {
        //Faltan validaciones
        em.getTransaction().begin();
        em.persist(usuario);//Guarda
        em.getTransaction().commit();        
        return true;
    }

    public boolean editar(Usuario usuario) {
        if (usuario.getId()== null) {//Valida si es un id nulo no se puede
            return false;
        } else {
            em.getTransaction().begin();
            em.merge(usuario);//Actualizar
            em.getTransaction().commit();
            return true;
        }
    }

    public boolean eliminar(Usuario usuario) {
        em.getTransaction().begin();
        em.remove(em.merge(usuario));//Remueve si esta actualizado
        em.getTransaction().commit();
        return true;
    }

    public Usuario getPorId(int id) {
        Query q = em.createNamedQuery("Usuario.findById");//Creando una consulta
        q.setParameter("id", id);
        if (!q.getResultList().isEmpty()) {//revisa si no es nulo que valla a getResult y retorne un valor
            return (Usuario) q.getResultList().get(0);
        } else {
            return null;
        }
    }


    public List<Usuario> getTodos() {
        Query q = em.createNamedQuery("Usuario.findAll");
        return q.getResultList();
    }
}
