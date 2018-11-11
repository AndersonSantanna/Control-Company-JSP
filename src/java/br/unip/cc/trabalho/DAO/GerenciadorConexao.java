package br.unip.cc.trabalho.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GerenciadorConexao {

    private static final String URL = "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull";
    private static final String USUARIO = "aluno";
    private static final String SENHA = "";

    public static Connection getConnection() throws DaoException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            throw new DaoException(
                    "Não foi possivel conectar ao banco de dados",
                    ex);
        }
        return connection;
    }

    public static void fechar(Connection connection) throws DaoException {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new DaoException(
                    "Não foi possivel desconectar ao banco de dados",
                    ex);
        }
    }

    public static void fechar(Connection connection,
            Statement statement) throws DaoException {
        try {
            statement.close();
        } catch (SQLException ex) {
            throw new DaoException(
                    "Não foi possivel desconectar ao banco de dados",
                    ex);
        } finally {
            GerenciadorConexao.fechar(connection);
        }
    }

    public static void fechar(Connection connection,
            Statement statement,
            ResultSet resultSet) throws DaoException {
        try {
            resultSet.close();
        } catch (SQLException ex) {
            throw new DaoException(
                    "Não foi possivel desconectar ao banco de dados",
                    ex);
        } finally {
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    
    
}
