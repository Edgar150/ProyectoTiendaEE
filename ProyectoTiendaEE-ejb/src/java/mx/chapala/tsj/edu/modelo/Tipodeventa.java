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
@Table(name = "tipodeventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeventa.findAll", query = "SELECT t FROM Tipodeventa t")
    , @NamedQuery(name = "Tipodeventa.findById", query = "SELECT t FROM Tipodeventa t WHERE t.id = :id")})
public class Tipodeventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "CorteCaja_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cortecaja corteCajaid;
    @JoinColumn(name = "TipoDePago_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipodepago tipoDePagoid;

    public Tipodeventa() {
    }

    public Tipodeventa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cortecaja getCorteCajaid() {
        return corteCajaid;
    }

    public void setCorteCajaid(Cortecaja corteCajaid) {
        this.corteCajaid = corteCajaid;
    }

    public Tipodepago getTipoDePagoid() {
        return tipoDePagoid;
    }

    public void setTipoDePagoid(Tipodepago tipoDePagoid) {
        this.tipoDePagoid = tipoDePagoid;
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
        if (!(object instanceof Tipodeventa)) {
            return false;
        }
        Tipodeventa other = (Tipodeventa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.chapala.tsj.edu.modelo.Tipodeventa[ id=" + id + " ]";
    }
    
}
