package br.unip.cc.trabalho.DAO;

import br.unip.cc.trabalho.Model.Empresa;
import br.unip.cc.trabalho.Model.TipoEmpresa;

import java.util.List;

public interface EmpresaDAO {
    public Empresa getPorId(Integer id) throws DaoException;
    public List getTodos() throws DaoException;
    public List getPorCNPJ(String cnpj) throws DaoException;
    public List getEmpresaPorTipo(TipoEmpresa tipoEmpresa) throws DaoException;
    public void incluir(Empresa empresa)throws DaoException;
    public void excluir(Empresa empresa)throws DaoException;
    public void atualizar(Empresa empresa)throws DaoException;
}
