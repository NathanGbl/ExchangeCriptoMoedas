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

/**
 *
 * @author Nathan Gabriel
 */
public class TransacoesDAO {
    private Connection conn;
    public TransacoesDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir (Investidor investidor, 
                         String data, 
                         String operacao, 
                         double valor, 
                         String moeda, 
                         double taxa) throws SQLException {
        String sql = "insert into transacoes (senha, data, operacao, valor, "
                + "moeda, taxa, saldoreal, saldobitcoin, "
                + "saldoethereum, saldoripple)	"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, investidor.getSenha());
        statement.setString(2, data);
        statement.setString(3, operacao);
        statement.setDouble(4, valor);
        statement.setString(5, moeda);
        statement.setDouble(6, taxa);
        statement.setDouble(7, investidor.getCarteira().getSaldoReal());
        statement.setDouble(8, investidor.getCarteira().getSaldoBitcoin());
        statement.setDouble(9, investidor.getCarteira().getSaldoEthereum());
        statement.setDouble(10, investidor.getCarteira().getSaldoRipple());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
    }
    public ResultSet consultarExtrato (Investidor investidor) throws SQLException {

//        String sql = "select * from aluno where usuário = '"
//                     + aluno.getUsuario() + "'and senha = '"
//                     + aluno.getSenha() + "'";

        String sql = "select * from transacoes where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    public ResultSet consultar (Investidor investidor, String dado) throws SQLException {

//        String sql = "select * from aluno where usuário = '"
//                     + aluno.getUsuario() + "'and senha = '"
//                     + aluno.getSenha() + "'";

        String sql = "select * from transacoes where senha = ?"
                + "order by senha desc limit 1";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    public String doubleToString(double[] cotacao) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < cotacao.length; i++) {
            sb.append(cotacao[i]);
            if (i < cotacao.length - 1) {
                    sb.append(',');
            }
        }
        sb.append('}');
        String stringformatada = sb.toString();
        return stringformatada;
    }
    
    public void atualizarCotacao(Investidor investidor, 
                                 String moeda, double novaCotacao) throws SQLException {
        String sql = "update transacoes set cotacao = ? where moeda = ?";
        PreparedStatement statement = conn.prepareStatement(sql);

        if (moeda.equals("Bitcoin")) {
            investidor.getCarteira().getBitcoin().setCotacao(novaCotacao);
            statement.setDouble(1,
                    investidor.getCarteira().getBitcoin().getCotacao());
            statement.setString(2, moeda);
        } else if (moeda.equals("Ethereum")) {
            investidor.getCarteira().getEthereum().setCotacao(novaCotacao);
            statement.setDouble(1, 
                    investidor.getCarteira().getEthereum().getCotacao());
            statement.setString(2, moeda);
        } else if (moeda.equals("Ripple")) {
            investidor.getCarteira().getRipple().setCotacao(novaCotacao);
            statement.setDouble(1, 
                    investidor.getCarteira().getRipple().getCotacao());
            statement.setString(2, moeda);
        }
        statement.execute();
    }
}
