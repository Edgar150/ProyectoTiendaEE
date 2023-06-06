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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "cortecaja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cortecaja.findAll", query = "SELECT c FROM Cortecaja c")
    , @NamedQuery(name = "Cortecaja.findById", query = "SELECT c FROM Cortecaja c WHERE c.id = :id")
    , @NamedQuery(name = "Cortecaja.findByIngresado", query = "SELECT c FROM Cortecaja c WHERE c.ingresado = :ingresado")
    , @NamedQuery(name = "Cortecaja.findByRetirado", query = "SELECT c FROM Cortecaja c WHERE c.retirado = :retirado")
    , @NamedQuery(name = "Cortecaja.findByTotal", query = "SELECT c FROM Cortecaja c WHERE c.total = :total")})
public class Cortecaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ingresado")
    private Float ingresado;
    @Column(name = "retirado")
    private Float retirado;
    @Column(name = "total")
    private Float total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corteCajaid")
    private List<Tipodeventa> tipodeventaList;

    public Cortecaja() {
    }

    public Cortecaja(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getIngresado() {
        return ingresado;
    }

    public void setIngresado(Float ingresado) {
        this.ingresado = ingresado;
    }

    public Float getRetirado() {
        return retirado;
    }

    public void setRetirado(Float retirado) {
        this.retirado = retirado;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
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
        if (!(object instanceof Cortecaja)) {
            return false;
        }
        Cortecaja other = (Cortecaja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.chapala.tsj.edu.modelo.Cortecaja[ id=" + id + " ]";
    }
    
}
