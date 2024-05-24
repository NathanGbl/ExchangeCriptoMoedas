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
        String sql = "insert into investidores (nome, cpf, senha) values (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getNome());
        statement.setString(2, investidor.getCpf());
        statement.setInt(3, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
    }
    public ResultSet consultar (Investidor investidor) throws SQLException {

//        String sql = "select * from aluno where usuário = '"
//                     + aluno.getUsuario() + "'and senha = '"
//                     + aluno.getSenha() + "'";

        String sql = "select * from investidores where cpf = ? and senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setInt(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    public void atualizar(Investidor investidor) throws SQLException {
        String sql = "update investidores set senha = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, investidor.getSenha());
        statement.setString(2, investidor.getCpf());
        statement.execute();
    }
    
    public void remover(Investidor investidor) throws SQLException {
        String sql = "delete from investidores where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.execute();
    }
}