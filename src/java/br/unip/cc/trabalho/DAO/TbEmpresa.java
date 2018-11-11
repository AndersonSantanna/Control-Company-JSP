/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.trabalho.DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ander
 */
@Entity
@Table(name = "tb_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmpresa.findAll", query = "SELECT t FROM TbEmpresa t")
    , @NamedQuery(name = "TbEmpresa.findById", query = "SELECT t FROM TbEmpresa t WHERE t.id = :id")
    , @NamedQuery(name = "TbEmpresa.findByCnpj", query = "SELECT t FROM TbEmpresa t WHERE t.cnpj = :cnpj")
    , @NamedQuery(name = "TbEmpresa.findByRazao", query = "SELECT t FROM TbEmpresa t WHERE t.razao = :razao")
    , @NamedQuery(name = "TbEmpresa.findByTipo", query = "SELECT t FROM TbEmpresa t WHERE t.tipo = :tipo")})
public class TbEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CNPJ")
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "RAZAO")
    private String razao;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;

    public TbEmpresa() {
    }

    public TbEmpresa(Integer id) {
        this.id = id;
    }

    public TbEmpresa(Integer id, String cnpj, String razao, String tipo) {
        this.id = id;
        this.cnpj = cnpj;
        this.razao = razao;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof TbEmpresa)) {
            return false;
        }
        TbEmpresa other = (TbEmpresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unip.cc.trabalho.DAO.TbEmpresa[ id=" + id + " ]";
    }
    
}
