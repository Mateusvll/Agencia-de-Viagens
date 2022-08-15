/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author mateu
 */
@Entity
@Table(name = "viagem", catalog = "db_mateustur", schema = "")
@NamedQueries({
    @NamedQuery(name = "Viagem.findAll", query = "SELECT v FROM Viagem v"),
    @NamedQuery(name = "Viagem.findByIdviagem", query = "SELECT v FROM Viagem v WHERE v.idviagem = :idviagem"),
    @NamedQuery(name = "Viagem.findByDataViagem", query = "SELECT v FROM Viagem v WHERE v.dataViagem = :dataViagem"),
    @NamedQuery(name = "Viagem.findByHoraPartida", query = "SELECT v FROM Viagem v WHERE v.horaPartida = :horaPartida"),
    @NamedQuery(name = "Viagem.findByOrigem", query = "SELECT v FROM Viagem v WHERE v.origem = :origem"),
    @NamedQuery(name = "Viagem.findByDestino", query = "SELECT v FROM Viagem v WHERE v.destino = :destino"),
    @NamedQuery(name = "Viagem.findByVeiculosIdveiculos", query = "SELECT v FROM Viagem v WHERE v.veiculosIdveiculos = :veiculosIdveiculos")})
public class Viagem implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idviagem")
    private Integer idviagem;
    @Column(name = "dataViagem")
    @Temporal(TemporalType.DATE)
    private Date dataViagem;
    @Column(name = "horaPartida")
    @Temporal(TemporalType.TIME)
    private Date horaPartida;
    @Column(name = "origem")
    private String origem;
    @Column(name = "destino")
    private String destino;
    @Column(name = "veiculos_idveiculos")
    private Integer veiculosIdveiculos;

    public Viagem() {
    }

    public Viagem(Integer idviagem) {
        this.idviagem = idviagem;
    }

    public Integer getIdviagem() {
        return idviagem;
    }

    public void setIdviagem(Integer idviagem) {
        Integer oldIdviagem = this.idviagem;
        this.idviagem = idviagem;
        changeSupport.firePropertyChange("idviagem", oldIdviagem, idviagem);
    }

    public Date getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(Date dataViagem) {
        Date oldDataViagem = this.dataViagem;
        this.dataViagem = dataViagem;
        changeSupport.firePropertyChange("dataViagem", oldDataViagem, dataViagem);
    }

    public Date getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Date horaPartida) {
        Date oldHoraPartida = this.horaPartida;
        this.horaPartida = horaPartida;
        changeSupport.firePropertyChange("horaPartida", oldHoraPartida, horaPartida);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        String oldOrigem = this.origem;
        this.origem = origem;
        changeSupport.firePropertyChange("origem", oldOrigem, origem);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        String oldDestino = this.destino;
        this.destino = destino;
        changeSupport.firePropertyChange("destino", oldDestino, destino);
    }

    public Integer getVeiculosIdveiculos() {
        return veiculosIdveiculos;
    }

    public void setVeiculosIdveiculos(Integer veiculosIdveiculos) {
        Integer oldVeiculosIdveiculos = this.veiculosIdveiculos;
        this.veiculosIdveiculos = veiculosIdveiculos;
        changeSupport.firePropertyChange("veiculosIdveiculos", oldVeiculosIdveiculos, veiculosIdveiculos);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idviagem != null ? idviagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viagem)) {
            return false;
        }
        Viagem other = (Viagem) object;
        if ((this.idviagem == null && other.idviagem != null) || (this.idviagem != null && !this.idviagem.equals(other.idviagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Viagem[ idviagem=" + idviagem + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
