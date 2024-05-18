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
                            ) throws SQLException {
        String sql = "insert into transacoes (senha, data, operacao, valor, "
                + "moeda, taxa, saldoreal, saldobitcoin, "
                + "saldoethereum, saldoripple)	"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getNome());
        statement.setString(2, investidor.getCpf());
        statement.setInt(3, investidor.getSenha());
        statement.setString(4, investidor.getNome());
        statement.setString(5, investidor.getCpf());
        statement.setInt(6, investidor.getSenha());
        statement.setString(7, investidor.getNome());
        statement.setString(8, investidor.getCpf());
        statement.setInt(9, investidor.getSenha());
        statement.setInt(10, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
    }
    public ResultSet consultar (Investidor investidor) throws SQLException {

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
    
    public void atualizarCotacao(Investidor investidor, 
                                 String moeda) throws SQLException {
        String sql = "update transacoes set cotacao = ? where moeda = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        double novaCotacao = Moedas.novaCotacao();

        if (moeda.equals("Bitcoin")) {
            investidor.getCarteira().getBitcoin().setCotacao(novaCotacao);
            statement.setDouble(1, investidor.getCarteira().getBitcoin().getCotacao());
            statement.setString(2, moeda);
        } else if (moeda.equals("Ethereum")) {
            investidor.getCarteira().getEthereum().setCotacao(novaCotacao);
            statement.setDouble(1, investidor.getCarteira().getEthereum().getCotacao());
            statement.setString(2, moeda);
        } else if (moeda.equals("Ripple")) {
            investidor.getCarteira().getRipple().setCotacao(novaCotacao);
            statement.setDouble(1, investidor.getCarteira().getRipple().getCotacao());
            statement.setString(2, moeda);
        }
        statement.execute();
    }
}
