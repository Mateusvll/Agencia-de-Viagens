/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author mateu
 */
@Entity
@Table(name = "veiculos", catalog = "db_mateustur", schema = "")
@NamedQueries({
    @NamedQuery(name = "Veiculos.findAll", query = "SELECT v FROM Veiculos v"),
    @NamedQuery(name = "Veiculos.findByIdveiculos", query = "SELECT v FROM Veiculos v WHERE v.idveiculos = :idveiculos"),
    @NamedQuery(name = "Veiculos.findByMarca", query = "SELECT v FROM Veiculos v WHERE v.marca = :marca"),
    @NamedQuery(name = "Veiculos.findByModelo", query = "SELECT v FROM Veiculos v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Veiculos.findByPlaca", query = "SELECT v FROM Veiculos v WHERE v.placa = :placa")})
public class Veiculos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idveiculos")
    private Integer idveiculos;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "placa")
    private String placa;

    public Veiculos() {
    }

    public Veiculos(Integer idveiculos) {
        this.idveiculos = idveiculos;
    }

    public Integer getIdveiculos() {
        return idveiculos;
    }

    public void setIdveiculos(Integer idveiculos) {
        Integer oldIdveiculos = this.idveiculos;
        this.idveiculos = idveiculos;
        changeSupport.firePropertyChange("idveiculos", oldIdveiculos, idveiculos);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        String oldPlaca = this.placa;
        this.placa = placa;
        changeSupport.firePropertyChange("placa", oldPlaca, placa);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idveiculos != null ? idveiculos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculos)) {
            return false;
        }
        Veiculos other = (Veiculos) object;
        if ((this.idveiculos == null && other.idveiculos != null) || (this.idveiculos != null && !this.idveiculos.equals(other.idveiculos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return marca + " - Placa:" + placa;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
