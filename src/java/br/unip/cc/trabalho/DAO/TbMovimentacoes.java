/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.trabalho.DAO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ander
 */
@Entity
@Table(name = "tb_movimentacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMovimentacoes.findAll", query = "SELECT t FROM TbMovimentacoes t")
    , @NamedQuery(name = "TbMovimentacoes.findById", query = "SELECT t FROM TbMovimentacoes t WHERE t.id = :id")
    , @NamedQuery(name = "TbMovimentacoes.findByTipo", query = "SELECT t FROM TbMovimentacoes t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TbMovimentacoes.findByDataMov", query = "SELECT t FROM TbMovimentacoes t WHERE t.dataMov = :dataMov")
    , @NamedQuery(name = "TbMovimentacoes.findByItem", query = "SELECT t FROM TbMovimentacoes t WHERE t.item = :item")
    , @NamedQuery(name = "TbMovimentacoes.findByPreco", query = "SELECT t FROM TbMovimentacoes t WHERE t.preco = :preco")
    , @NamedQuery(name = "TbMovimentacoes.findByQtde", query = "SELECT t FROM TbMovimentacoes t WHERE t.qtde = :qtde")})
public class TbMovimentacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "DATA_MOV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMov;
    @Basic(optional = false)
    @Column(name = "ITEM")
    private String item;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECO")
    private BigDecimal preco;
    @Basic(optional = false)
    @Column(name = "QTDE")
    private int qtde;

    public TbMovimentacoes() {
    }

    public TbMovimentacoes(Integer id) {
        this.id = id;
    }

    public TbMovimentacoes(Integer id, String tipo, Date dataMov, String item, BigDecimal preco, int qtde) {
        this.id = id;
        this.tipo = tipo;
        this.dataMov = dataMov;
        this.item = item;
        this.preco = preco;
        this.qtde = qtde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataMov() {
        return dataMov;
    }

    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
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
        if (!(object instanceof TbMovimentacoes)) {
            return false;
        }
        TbMovimentacoes other = (TbMovimentacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unip.cc.trabalho.DAO.TbMovimentacoes[ id=" + id + " ]";
    }
    
}
