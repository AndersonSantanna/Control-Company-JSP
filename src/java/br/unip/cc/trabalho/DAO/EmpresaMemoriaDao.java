package br.unip.cc.trabalho.DAO;

import br.unip.cc.trabalho.Model.Empresa;
import br.unip.cc.trabalho.Model.TipoEmpresa;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;

public class EmpresaMemoriaDao implements EmpresaDAO{
    private List<Empresa> empresas;
    private int cont = 1;
    
    private static EmpresaMemoriaDao instance;

    public static EmpresaMemoriaDao getInstance() {
        if (instance == null) {
            instance = new EmpresaMemoriaDao();
        }
        return instance;
    }
    
    public EmpresaMemoriaDao() {
        empresas = new ArrayList<>();
        empresas.add(new Empresa(0, "123456", "Empresa1", TipoEmpresa.TECNOLOGIA));
        empresas.add(new Empresa(1, "789456", "Empresa2", TipoEmpresa.TECNOLOGIA));
        empresas.add(new Empresa(2, "678920", "Empresa3", TipoEmpresa.AUTOMOTIVA));
        empresas.add(new Empresa(3, "098710", "Empresa4", TipoEmpresa.ALIMENTICIA));
    }

    @Override
    public List getTodos() throws DaoException {
        return empresas;
    }

    @Override
    public List getEmpresaPorTipo(TipoEmpresa tipoEmpresa) throws DaoException {
        List<Empresa> listEmpresas = new ArrayList<>();
        for(Empresa e : empresas){
            if(e.getTipoEmpresa() == tipoEmpresa){
                listEmpresas.add(e);
            }
        }
        return listEmpresas;
    }

    @Override
    public void incluir(Empresa empresa) throws DaoException {
        if(empresa != null){
            empresas.add(empresa);
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível incluir na tabela","ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Empresa empresa) throws DaoException {
        if (empresa != null) {
            empresas.remove(empresa);
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir na tabela","ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void atualizar(Empresa empresa) throws DaoException {
        if (empresa != null) {
            for(Empresa e : empresas){
                if(e.getId() == empresa.getId()){
                    empresas.set(empresas.indexOf(e), empresa);
                }
            }
        } 
    }

    @Override
    public List getPorCNPJ(String cnpj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa getPorId(Integer id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
