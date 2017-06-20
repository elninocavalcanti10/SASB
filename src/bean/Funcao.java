/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
 * @author Adolpho
 */
@Entity
@Table(name = "funcao", catalog = "SisAge", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f"),
    @NamedQuery(name = "Funcao.findByIDFuncao", query = "SELECT f FROM Funcao f WHERE f.iDFuncao = :iDFuncao"),
    @NamedQuery(name = "Funcao.findByNomeFuncao", query = "SELECT f FROM Funcao f WHERE f.nomeFuncao = :nomeFuncao")})
public class Funcao implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Funcao")
    private Integer iDFuncao;
    @Basic(optional = false)
    @Column(name = "Nome_Funcao")
    private String nomeFuncao;

    public Funcao() {
    }

    public Funcao(Integer iDFuncao) {
        this.iDFuncao = iDFuncao;
    }

    public Funcao(Integer iDFuncao, String nomeFuncao) {
        this.iDFuncao = iDFuncao;
        this.nomeFuncao = nomeFuncao;
    }

    public Integer getIDFuncao() {
        return iDFuncao;
    }

    public void setIDFuncao(Integer iDFuncao) {
        Integer oldIDFuncao = this.iDFuncao;
        this.iDFuncao = iDFuncao;
        changeSupport.firePropertyChange("IDFuncao", oldIDFuncao, iDFuncao);
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        String oldNomeFuncao = this.nomeFuncao;
        this.nomeFuncao = nomeFuncao;
        changeSupport.firePropertyChange("nomeFuncao", oldNomeFuncao, nomeFuncao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFuncao != null ? iDFuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.iDFuncao == null && other.iDFuncao != null) || (this.iDFuncao != null && !this.iDFuncao.equals(other.iDFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeFuncao;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
