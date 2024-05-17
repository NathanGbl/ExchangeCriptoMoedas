/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Investidor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Nathan Gabriel
 */
public class TransacoesDAO {
    private Connection conn;
    public TransacoesDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir (Investidor investidor) throws SQLException {
        String sql = "insert into transacoes (nome, cpf, senha) values (?, ?, ?)";
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

        String sql = "select * from transacoes where cpf = ? and senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setInt(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    public ResultSet consultarSaldos (Investidor investidor) throws SQLException {

//        String sql = "select * from aluno where usuário = '"
//                     + aluno.getUsuario() + "'and senha = '"
//                     + aluno.getSenha() + "'";

        String sql = "select * from transacoes where senha = ?"
                   + " order by senha desc limit 1";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    public void atualizarCotacao(Investidor investidor, String moeda) throws SQLException {
        String sql = "update transacoes set cotacao = ? where moeda = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        if (moeda.equals("Bitcoin")) {
            statement.setDouble(1, investidor.getCarteira().getBitcoin());
        } else if (moeda.equals("Ethereum")) {
            
        } else if (moeda.equals("Ripple")) {
            
        }
        statement.setString(2, investidor.getCpf());
        statement.execute();
    }
}
