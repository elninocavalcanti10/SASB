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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Adolpho
 */
@Entity
@Table(name = "funcionario", catalog = "SisAge", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIDFuncionario", query = "SELECT f FROM Funcionario f WHERE f.iDFuncionario = :iDFuncionario"),
    @NamedQuery(name = "Funcionario.findByNomeFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomeFuncionario = :nomeFuncionario"),
    @NamedQuery(name = "Funcionario.findByCPFFuncionario", query = "SELECT f FROM Funcionario f WHERE f.cPFFuncionario = :cPFFuncionario"),
    @NamedQuery(name = "Funcionario.findByAdministrador", query = "SELECT f FROM Funcionario f WHERE f.administrador = :administrador"),
    @NamedQuery(name = "Funcionario.findByFuncaoIDFuncao", query = "SELECT f FROM Funcionario f WHERE f.funcaoIDFuncao = :funcaoIDFuncao")})
public class Funcionario implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Funcionario")
    private Integer iDFuncionario;
    @Basic(optional = false)
    @Column(name = "Nome_Funcionario")
    private String nomeFuncionario;
    @Basic(optional = false)
    @Column(name = "CPF_Funcionario")
    private String cPFFuncionario;
    @Basic(optional = false)
    @Column(name = "Administrador")
    private boolean administrador;
    
    @ManyToOne
    @JoinColumn(name = "Funcao_ID_Funcao")
    private Funcao funcaoIDFuncao;

    public Funcionario() {
    }

    public Funcionario(Integer iDFuncionario) {
        this.iDFuncionario = iDFuncionario;
    }

    public Funcionario(Integer iDFuncionario, String nomeFuncionario, String cPFFuncionario, boolean administrador, Funcao funcaoIDFuncao) {
        this.iDFuncionario = iDFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cPFFuncionario = cPFFuncionario;
        this.administrador = administrador;
        this.funcaoIDFuncao = funcaoIDFuncao;
    }

    public Integer getIDFuncionario() {
        return iDFuncionario;
    }

    public void setIDFuncionario(Integer iDFuncionario) {
        Integer oldIDFuncionario = this.iDFuncionario;
        this.iDFuncionario = iDFuncionario;
        changeSupport.firePropertyChange("IDFuncionario", oldIDFuncionario, iDFuncionario);
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        String oldNomeFuncionario = this.nomeFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        changeSupport.firePropertyChange("nomeFuncionario", oldNomeFuncionario, nomeFuncionario);
    }

    public String getCPFFuncionario() {
        return cPFFuncionario;
    }

    public void setCPFFuncionario(String cPFFuncionario) {
        String oldCPFFuncionario = this.cPFFuncionario;
        this.cPFFuncionario = cPFFuncionario;
        changeSupport.firePropertyChange("CPFFuncionario", oldCPFFuncionario, cPFFuncionario);
    }

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        boolean oldAdministrador = this.administrador;
        this.administrador = administrador;
        changeSupport.firePropertyChange("administrador", oldAdministrador, administrador);
    }

    public Funcao getFuncaoIDFuncao() {
        return funcaoIDFuncao;
    }

    public void setFuncaoIDFuncao(Funcao funcaoIDFuncao) {
        Funcao oldFuncaoIDFuncao = this.funcaoIDFuncao;
        this.funcaoIDFuncao = funcaoIDFuncao;
        changeSupport.firePropertyChange("funcaoIDFuncao", oldFuncaoIDFuncao, funcaoIDFuncao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFuncionario != null ? iDFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.iDFuncionario == null && other.iDFuncionario != null) || (this.iDFuncionario != null && !this.iDFuncionario.equals(other.iDFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeFuncionario;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
