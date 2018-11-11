/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.trabalho.DAO;

import br.unip.cc.trabalho.Model.Empresa;
import br.unip.cc.trabalho.Model.TipoEmpresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author anderson
 */
public class EmpresaJPA implements EmpresaDAO{
    private static EmpresaJPA instacia;
    public static EmpresaDAO getInstancia() {
        if(instacia == null){
            instacia = new EmpresaJPA(JpaUtil.getEntityManager());
        }
        return instacia;
    }
    private final EntityManager entityManager;
 
    public EmpresaJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public Empresa getPorId(Integer id) throws DaoException {
        Empresa empresa = null;
        try {
            empresa =entityManager.find(Empresa.class, id);
        } catch (Exception e) {
            throw new DaoException("nao foi possivel recuperar", e);
        }
        return empresa;
    }

    @Override
    public List<Empresa> getTodos() throws DaoException {
        List empresa = null;
        try {
            Query query = entityManager.createQuery("SELECT e FROM Empresa e");
            empresa = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("nao foi possivel recuperar", e);
        }
        return empresa;
    }

    @Override
    public List getPorCNPJ(String cnpj) throws DaoException {
        List<Empresa> empresa = null;
        try {
            TypedQuery<Empresa> query = entityManager.createNamedQuery("Empresa.getCNPJ", Empresa.class );
            query.setParameter("cnpj", cnpj);
            empresa = query.getResultList();
        } catch (Exception e) {
            throw new DaoException("Não foi possivel recuperar..", e);
        }
        return empresa;
    }

    @Override
    public List getEmpresaPorTipo(TipoEmpresa tipoEmpresa) throws DaoException {
        List<Empresa> list = null;
        try {
            TypedQuery<Empresa> query = entityManager.createNamedQuery("Empresa.getPorTipo", Empresa.class);
            query.setParameter("tipo", tipoEmpresa);
            list = query.getResultList();
        } catch (Exception e) {
            throw new DaoException("Não foi possível recuperar", e);
        }
        /*
            Query query = entityManager.createQuery("SELECT * FROM Empresa WHERE tipo = " + tipoEmpresa);
            list = (List<Empresa>) query.getSingleResult();
            */
        
        return list;
    }

    @Override
    public void incluir(Empresa empresa) throws DaoException {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(empresa);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new DaoException("nao foi possivel incluir", e);
        }
    }

    @Override
    public void excluir(Empresa empresa) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(empresa);
            entityManager.getTransaction().commit();;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DaoException("Não foi possivel excluir... ", e);
        }
    }

    @Override
    public void atualizar(Empresa empresa) throws DaoException {
        try{
            entityManager.getTransaction().begin();
            if(!entityManager.contains(empresa)){
                entityManager.merge(empresa);
            }
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        
    }
    
}
