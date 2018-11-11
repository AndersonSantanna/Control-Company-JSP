/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.trabalho.DAO;

import br.unip.cc.trabalho.Model.Empresa;
import br.unip.cc.trabalho.Model.TipoEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class EmpresaJDBC implements EmpresaDAO{

    
    private static EmpresaJDBC instancia;
    public static EmpresaJDBC getInstancia(){
        if(instancia == null){
            instancia = new EmpresaJDBC();
        }
        return instancia;
    }
    
    @Override
    public List getTodos() throws DaoException {
        Connection connection
                = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Empresa> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM TB_EMPRESA;");
            rs = statement.executeQuery();
            while (rs.next()) { 
                list.add(new Empresa(rs.getInt("ID"),rs.getString("CNPJ"), rs.getString("RAZAO") , TipoEmpresa.valueOf(rs.getString("TIPO"))));
            }
        } catch (SQLException ex) {
            throw new DaoException(
                    "Não foi possivel selecionar", ex);
        } finally {
            GerenciadorConexao.fechar(connection, statement, rs);
        }
        return list;
    }

    @Override
    public List getPorCNPJ(String cnpj) throws DaoException {
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        ResultSet rs= null;
        Empresa empresa= null;
        try {
            statement = connection.prepareStatement("SELECT * FROM TB_MOVIMENTACOES WHERE TIPO = ?;");
            statement.setString(1, cnpj);
            rs = statement.executeQuery();
            rs.next();
                
            empresa = new Empresa(rs.getInt("ID"), rs.getString("CNPJ"), rs.getString("RAZAO"), TipoEmpresa.valueOf(rs.getString("TIPO")));
            
            } catch (SQLException ex) {
                Logger.getLogger(EmpresaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            GerenciadorConexao.fechar(connection, statement, rs);
            List<Empresa> list = new ArrayList<>();
            list.add(empresa);
            return list;
    }

    @Override
    public List getEmpresaPorTipo(TipoEmpresa tipoEmpresa) throws DaoException {
        List<Empresa> list = new ArrayList<>();
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        ResultSet rs= null;
        try {
            statement = connection.prepareStatement("SELECT ID, CNPJ, RAZAO, TIPO FROM TB_EMPRESA WHERE TIPO = ?;");
            statement.setString(1, String.valueOf(tipoEmpresa));
            rs = statement.executeQuery();
            while(rs.next()){
                list.add( new Empresa(rs.getInt("ID"), rs.getString("CNPJ"), rs.getString("RAZAO"),
                TipoEmpresa.valueOf(rs.getString("TIPO"))));
        }

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            GerenciadorConexao.fechar(connection, statement, rs);
        }
        return list;    }

    @Override
    public void incluir(Empresa empresa) throws DaoException {
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO TB_EMPRESA(ID, CNPJ, RAZAO, TIPO) VALUES (?,?,?,?)");
            statement.setInt(1, empresa.getId());
            statement.setString(2, empresa.getCnpj());
            statement.setString(3, empresa.getRazaoSocial());
            statement.setString(4, String.valueOf(empresa.getTipoEmpresa()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(
                    "Não foi possivel incluir", ex);
        } finally {
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    @Override
    public void excluir(Empresa empresa) throws DaoException {
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM TB_EMPRESA WHERE ID=?");
            statement.setInt(1, empresa.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(
                    "Não foi possivel excluir", ex);
        } finally {
            GerenciadorConexao.fechar(connection, statement);
        }
    }
    

    @Override
    public void atualizar(Empresa empresa) throws DaoException {
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE TB_EMPRESA SET ID =?, CNPJ=?, RAZAO=?, TIPO=? WHERE ID = ?");
            statement.setInt(1, empresa.getId());
            statement.setString(2, empresa.getCnpj());
            statement.setString(3, empresa.getRazaoSocial());
            statement.setString(4, String.valueOf(empresa.getTipoEmpresa()));
            statement.setInt(5, empresa.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(
                    "Não foi possivel atualizar", ex);
        } finally {
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    @Override
    public Empresa getPorId(Integer id) throws DaoException {
        Empresa e = null;
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM TB_EMPRESA WHERE ID=?");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            rs.next();
            e = new Empresa(
                    rs.getInt("ID"),
                    rs.getString("CNPJ"),
                    rs.getString("RAZAO"),
                    TipoEmpresa.valueOf(rs.getString("TIPO"))
            );
        } catch (SQLException ex) {
            new DaoException(
                    "Não foi possivel pegar por id", ex);
        } finally {
            GerenciadorConexao.fechar(connection, statement, rs);
        }
        return e;
    }
    
    
}

