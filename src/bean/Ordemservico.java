/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Adolpho
 */
@Entity
@Table(name = "ordemservico", catalog = "SisAge", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ordemservico.findAll", query = "SELECT o FROM Ordemservico o"),
    @NamedQuery(name = "Ordemservico.findById", query = "SELECT o FROM Ordemservico o WHERE o.id = :id"),
    @NamedQuery(name = "Ordemservico.findByIDCliente", query = "SELECT o FROM Ordemservico o WHERE o.iDCliente = :iDCliente"),
    @NamedQuery(name = "Ordemservico.findByIDFuncionario", query = "SELECT o FROM Ordemservico o WHERE o.iDFuncionario = :iDFuncionario"),
    @NamedQuery(name = "Ordemservico.findByDescricao", query = "SELECT o FROM Ordemservico o WHERE o.descricao = :descricao"),
    @NamedQuery(name = "Ordemservico.findByValor", query = "SELECT o FROM Ordemservico o WHERE o.valor = :valor"),
    @NamedQuery(name = "Ordemservico.findByData", query = "SELECT o FROM Ordemservico o WHERE o.data = :data"),
    @NamedQuery(name = "Ordemservico.findByHora", query = "SELECT o FROM Ordemservico o WHERE o.hora = :hora")})
public class Ordemservico implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "ID_Cliente")
    private Cliente iDCliente;
    
    @ManyToOne
    @JoinColumn(name = "ID_Funcionario")
    private Funcionario iDFuncionario;
    
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "Valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;

    public Ordemservico() {
    }

    public Ordemservico(Integer id) {
        this.id = id;
    }

    public Ordemservico(Integer id, Cliente iDCliente, Funcionario iDFuncionario, String descricao, String valor, Date data, Date hora) {
        this.id = id;
        this.iDCliente = iDCliente;
        this.iDFuncionario = iDFuncionario;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Cliente getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Cliente iDCliente) {
        Cliente oldIDCliente = this.iDCliente;
        this.iDCliente = iDCliente;
        changeSupport.firePropertyChange("IDCliente", oldIDCliente, iDCliente);
    }

    public Funcionario getIDFuncionario() {
        return iDFuncionario;
    }

    public void setIDFuncionario(Funcionario iDFuncionario) {
        Funcionario oldIDFuncionario = this.iDFuncionario;
        this.iDFuncionario = iDFuncionario;
        changeSupport.firePropertyChange("IDFuncionario", oldIDFuncionario, iDFuncionario);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        String oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
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
        if (!(object instanceof Ordemservico)) {
            return false;
        }
        Ordemservico other = (Ordemservico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Ordemservico[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
