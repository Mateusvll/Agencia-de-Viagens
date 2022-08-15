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
@Table(name = "passageiro", catalog = "db_mateustur", schema = "")
@NamedQueries({
    @NamedQuery(name = "Passageiro.findAll", query = "SELECT p FROM Passageiro p"),
    @NamedQuery(name = "Passageiro.findByIdpassageiro", query = "SELECT p FROM Passageiro p WHERE p.idpassageiro = :idpassageiro"),
    @NamedQuery(name = "Passageiro.findByNome", query = "SELECT p FROM Passageiro p WHERE p.nome = :nome"),
    @NamedQuery(name = "Passageiro.findByCpf", query = "SELECT p FROM Passageiro p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Passageiro.findByRg", query = "SELECT p FROM Passageiro p WHERE p.rg = :rg"),
    @NamedQuery(name = "Passageiro.findByTelefone", query = "SELECT p FROM Passageiro p WHERE p.telefone = :telefone")})
public class Passageiro implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpassageiro")
    private Integer idpassageiro;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "telefone")
    private String telefone;

    public Passageiro() {
    }

    public Passageiro(Integer idpassageiro) {
        this.idpassageiro = idpassageiro;
    }

    public Integer getIdpassageiro() {
        return idpassageiro;
    }

    public void setIdpassageiro(Integer idpassageiro) {
        Integer oldIdpassageiro = this.idpassageiro;
        this.idpassageiro = idpassageiro;
        changeSupport.firePropertyChange("idpassageiro", oldIdpassageiro, idpassageiro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpassageiro != null ? idpassageiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passageiro)) {
            return false;
        }
        Passageiro other = (Passageiro) object;
        if ((this.idpassageiro == null && other.idpassageiro != null) || (this.idpassageiro != null && !this.idpassageiro.equals(other.idpassageiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Passageiro[ idpassageiro=" + idpassageiro + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
