package br.unip.cc.trabalho.Model;

import br.unip.cc.trabalho.DAO.DaoException;
import br.unip.cc.trabalho.DAO.EmpresaDAO;
import br.unip.cc.trabalho.DAO.EmpresaJPA;

import java.util.List;

public class GerenciadorEmpresa {
    private static GerenciadorEmpresa ourInstance;

    public static GerenciadorEmpresa getInstance() {
        if (ourInstance == null ) {
            ourInstance = new GerenciadorEmpresa();
        }
        return ourInstance;
    }

    
    private GerenciadorEmpresa() {
    }
    
    private EmpresaDAO dao = EmpresaJPA.getInstancia();
    public List getTodasEmpresa() throws DaoException{
        return dao.getTodos();
    }
    
    public Empresa getNovaEmpresa() {
        return new Empresa(0, "123.125.1558-0", "NOME FICTICIO", TipoEmpresa.TECNOLOGIA);
    }
    
    public List<Empresa> getEmpresaPorTipo(TipoEmpresa tipoEmpresa) throws DaoException{
        if (tipoEmpresa != null) {
            return dao.getEmpresaPorTipo(tipoEmpresa);
        }else{
            return dao.getTodos();
        }
    }
    
    public void salvar(Empresa empresa) throws DaoException{        
        if (dao.getPorId(empresa.getId()) == null || empresa.getId() == 0) {
            System.out.println("NOVA EMPRESA ABAIXO");
            System.out.println(empresa);
            dao.incluir(empresa);
        } else {
            dao.atualizar(empresa);
        }
        
    }
    
    public void remover(Empresa empresa) throws DaoException{
        dao.excluir(empresa);
    }

    public Empresa getPorId(int id) throws DaoException {
        return dao.getPorId(id);
    }
    
}
