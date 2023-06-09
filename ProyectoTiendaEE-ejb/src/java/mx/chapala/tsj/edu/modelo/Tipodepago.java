/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "tipodepago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodepago.findAll", query = "SELECT t FROM Tipodepago t")
    , @NamedQuery(name = "Tipodepago.findById", query = "SELECT t FROM Tipodepago t WHERE t.id = :id")
    , @NamedQuery(name = "Tipodepago.findByTipodepago", query = "SELECT t FROM Tipodepago t WHERE t.tipodepago = :tipodepago")})
public class Tipodepago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "tipodepago")
    private String tipodepago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDePagoid")
    private List<Tipodeventa> tipodeventaList;

    public Tipodepago() {
    }

    public Tipodepago(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipodepago() {
        return tipodepago;
    }

    public void setTipodepago(String tipodepago) {
        this.tipodepago = tipodepago;
    }

    @XmlTransient
    public List<Tipodeventa> getTipodeventaList() {
        return tipodeventaList;
    }

    public void setTipodeventaList(List<Tipodeventa> tipodeventaList) {
        this.tipodeventaList = tipodeventaList;
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
        if (!(object instanceof Tipodepago)) {
            return false;
        }
        Tipodepago other = (Tipodepago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.chapala.tsj.edu.modelo.Tipodepago[ id=" + id + " ]";
    }
    
}
