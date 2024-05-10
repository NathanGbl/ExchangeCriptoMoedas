/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Nathan Gabriel
 */
import Model.Investidor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class InvestidoresDAO {
    private Connection conn;
    
    public InvestidoresDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir (Investidor investidor) throws SQLException {
        String sql = "insert into aluno (nome, cpf, senha) values (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getNome());
        statement.setString(2, investidor.getCpf());
        statement.setString(3, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
    }
    public ResultSet consultar (Investidor investidor) throws SQLException {

//        String sql = "select * from aluno where usuário = '"
//                     + aluno.getUsuario() + "'and senha = '"
//                     + aluno.getSenha() + "'";

        String sql = "select * from aluno where usuario = ? and senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getUsuario());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    public void atualizar(Investidor investidor) throws SQLException {
        String sql = "update aluno set senha = ? where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getSenha());
        statement.setString(2, investidor.getUsuario());
        statement.execute();
    }
    
    public void remover(Investidor investidor) throws SQLException {
        String sql = "delete from aluno where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getUsuario());
        statement.execute();
    }
}