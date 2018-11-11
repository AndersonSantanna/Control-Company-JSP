package br.unip.cc.trabalho.Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EMPRESA")
@NamedQueries({
    @NamedQuery(name = "Empresa.getCNPJ", 
            query = "Select e from Empresa e where e.cnpj = :cnpj"),
    @NamedQuery(name = "Empresa.getPorTipo",
            query = "Select e from Empresa e where e.tipoEmpresa = :tipo")
})
//@NamedQuery(name = "Empresa.getPorTipo",
            //query = "Select e from Empresa e where tipo= :tipo")
public class Empresa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "CNPJ", nullable = false)
    private String cnpj;
    @Column(name = "RAZAO", nullable = false)
    private String razaoSocial;
    @Column(name = "TIPO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;

    public Empresa(int id, String cnpj, String razaoSocial, TipoEmpresa tipoEmpresa) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.tipoEmpresa = tipoEmpresa;
    }

    public Empresa(String cnpj, String razaoSocial, TipoEmpresa tipoEmpresa) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.tipoEmpresa = tipoEmpresa;
    }
    
    public Empresa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return id == empresa.id &&
                Objects.equals(cnpj, empresa.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj);
    }
}
