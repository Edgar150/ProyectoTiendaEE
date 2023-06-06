/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "permisoperfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisoperfil.findAll", query = "SELECT p FROM Permisoperfil p")
    , @NamedQuery(name = "Permisoperfil.findById", query = "SELECT p FROM Permisoperfil p WHERE p.id = :id")})
public class Permisoperfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "Perfil_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Perfil perfilid;
    @JoinColumn(name = "Permisos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Permisos permisosid;

    public Permisoperfil() {
    }

    public Permisoperfil(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Perfil getPerfilid() {
        return perfilid;
    }

    public void setPerfilid(Perfil perfilid) {
        this.perfilid = perfilid;
    }

    public Permisos getPermisosid() {
        return permisosid;
    }

    public void setPermisosid(Permisos permisosid) {
        this.permisosid = permisosid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisoperfil)) {
            return false;
        }
        Permisoperfil other = (Permisoperfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.chapala.tsj.edu.modelo.Permisoperfil[ id=" + id + " ]";
    }
    
}
