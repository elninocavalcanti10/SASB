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
@Table(name = "cliente", catalog = "SisAge", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIDCliente", query = "SELECT c FROM Cliente c WHERE c.iDCliente = :iDCliente"),
    @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM Cliente c WHERE c.nomeCliente = :nomeCliente"),
    @NamedQuery(name = "Cliente.findByBairroCliente", query = "SELECT c FROM Cliente c WHERE c.bairroCliente = :bairroCliente"),
    @NamedQuery(name = "Cliente.findByNumCasaCliente", query = "SELECT c FROM Cliente c WHERE c.numCasaCliente = :numCasaCliente"),
    @NamedQuery(name = "Cliente.findByCEPCliente", query = "SELECT c FROM Cliente c WHERE c.cEPCliente = :cEPCliente"),
    @NamedQuery(name = "Cliente.findByTelefoneCliente", query = "SELECT c FROM Cliente c WHERE c.telefoneCliente = :telefoneCliente"),
    @NamedQuery(name = "Cliente.findByEmailCleinte", query = "SELECT c FROM Cliente c WHERE c.emailCleinte = :emailCleinte")})
public class Cliente implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Cliente")
    private Integer iDCliente;
    @Basic(optional = false)
    @Column(name = "Nome_Cliente")
    private String nomeCliente;
    @Basic(optional = false)
    @Column(name = "Bairro_Cliente")
    private String bairroCliente;
    @Basic(optional = false)
    @Column(name = "NumCasa_Cliente")
    private String numCasaCliente;
    @Basic(optional = false)
    @Column(name = "CEP_Cliente")
    private String cEPCliente;
    @Basic(optional = false)
    @Column(name = "Telefone_Cliente")
    private String telefoneCliente;
    @Column(name = "Email_Cleinte")
    private String emailCleinte;

    public Cliente() {
    }

    public Cliente(Integer iDCliente) {
        this.iDCliente = iDCliente;
    }

    public Cliente(Integer iDCliente, String nomeCliente, String bairroCliente, String numCasaCliente, String cEPCliente, String telefoneCliente) {
        this.iDCliente = iDCliente;
        this.nomeCliente = nomeCliente;
        this.bairroCliente = bairroCliente;
        this.numCasaCliente = numCasaCliente;
        this.cEPCliente = cEPCliente;
        this.telefoneCliente = telefoneCliente;
    }

    public Integer getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Integer iDCliente) {
        Integer oldIDCliente = this.iDCliente;
        this.iDCliente = iDCliente;
        changeSupport.firePropertyChange("IDCliente", oldIDCliente, iDCliente);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        String oldNomeCliente = this.nomeCliente;
        this.nomeCliente = nomeCliente;
        changeSupport.firePropertyChange("nomeCliente", oldNomeCliente, nomeCliente);
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        String oldBairroCliente = this.bairroCliente;
        this.bairroCliente = bairroCliente;
        changeSupport.firePropertyChange("bairroCliente", oldBairroCliente, bairroCliente);
    }

    public String getNumCasaCliente() {
        return numCasaCliente;
    }

    public void setNumCasaCliente(String numCasaCliente) {
        String oldNumCasaCliente = this.numCasaCliente;
        this.numCasaCliente = numCasaCliente;
        changeSupport.firePropertyChange("numCasaCliente", oldNumCasaCliente, numCasaCliente);
    }

    public String getCEPCliente() {
        return cEPCliente;
    }

    public void setCEPCliente(String cEPCliente) {
        String oldCEPCliente = this.cEPCliente;
        this.cEPCliente = cEPCliente;
        changeSupport.firePropertyChange("CEPCliente", oldCEPCliente, cEPCliente);
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        String oldTelefoneCliente = this.telefoneCliente;
        this.telefoneCliente = telefoneCliente;
        changeSupport.firePropertyChange("telefoneCliente", oldTelefoneCliente, telefoneCliente);
    }

    public String getEmailCleinte() {
        return emailCleinte;
    }

    public void setEmailCleinte(String emailCleinte) {
        String oldEmailCleinte = this.emailCleinte;
        this.emailCleinte = emailCleinte;
        changeSupport.firePropertyChange("emailCleinte", oldEmailCleinte, emailCleinte);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCliente != null ? iDCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.iDCliente == null && other.iDCliente != null) || (this.iDCliente != null && !this.iDCliente.equals(other.iDCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeCliente;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
