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
import Model.Moedas;
import java.sql.Timestamp;

/**
 *
 * @author Nathan Gabriel
 */
public class TransacoesDAO {
    private Connection conn;
    public TransacoesDAO(Connection conn) {
        this.conn = conn;
    }
    
    public String doubleToString(double[] valores) {
        StringBuilder stringB = new StringBuilder("{");
        for(int i = 0; i < valores.length; i++) {
            stringB.append(valores[i]);
            if (i < valores.length - 1) {
                stringB.append(",");
            }
        }
        stringB.append("}");
        return stringB.toString();
    }
    public void inserir (Investidor investidor, 
                         Timestamp data, 
                         String operacao, 
                         double valor, 
                         String moeda, 
                         double[] cotacao, 
                         double taxa) throws SQLException {
        String sql = "insert into transacoes (senha, data, operacao, valor, "
                + "moeda, cotacao, taxa, saldoreal, saldoBitcoin, "
                + "saldoEthereum, saldoRipple)	"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        String insertCotacao = doubleToString(cotacao);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, investidor.getSenha());
        statement.setTimestamp(2, data);
        statement.setString(3, operacao);
        statement.setDouble(4, valor);
        statement.setString(5, moeda);
        statement.setObject(6, insertCotacao);
        statement.setDouble(7, taxa);
        statement.setDouble(8, investidor.getCarteira().getSaldoReal());
        statement.setDouble(9, investidor.getCarteira().getSaldoBitcoin());
        statement.setDouble(10, investidor.getCarteira().getSaldoEthereum());
        statement.setDouble(11, investidor.getCarteira().getSaldoRipple());
        statement.execute();
    }
    public ResultSet consultarExtrato (int senha) throws SQLException {

//        String sql = "select * from aluno where usuário = '"
//                     + aluno.getUsuario() + "'and senha = '"
//                     + aluno.getSenha() + "'";

        String sql = "select * from transacoes where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, senha);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    public ResultSet consultar (int senha) throws SQLException {

//        String sql = "select * from aluno where usuário = '"
//                     + aluno.getUsuario() + "'and senha = '"
//                     + aluno.getSenha() + "'";

        String sql = "select * from transacoes where senha = ? "
                + "order by senha desc limit 1";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, senha);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    public void atualizarCotacao(double[] novaCotacao) throws SQLException {
        String sql = "update transacoes set cotacao = ? where data = (SELECT MAX(data) FROM transacoes)";
        PreparedStatement statement = conn.prepareStatement(sql);

        String insertCot = doubleToString(novaCotacao);
        statement.setObject(1, insertCot);
        statement.execute();
    }
}
