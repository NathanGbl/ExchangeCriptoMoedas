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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nathan Gabriel
 */
public class TransacoesDAO {
    private Connection conn;
    public TransacoesDAO(Connection conn) {
        this.conn = conn;
    }
    
    /* Converte um array de double em string para inserir na tabela */
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
    
    // Converte a data para o formato que a tabela possui
    public Timestamp stringToTimeStamp(String data) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date dataDate = formatter.parse(data);
        Timestamp dataTimestamp = new Timestamp(dataDate.getTime());
        return dataTimestamp;
    }
    
    /* Insere todos os dados para uma nova linha na tabela */
    public void inserir (Investidor investidor, 
                         String data, 
                         String operacao, 
                         double valor, 
                         String moeda, 
                         double[] cotacao, 
                         double taxa) throws SQLException, ParseException {
        String sql = "insert into transacoes (senha, data, operacao, valor, "
                + "moeda, cotacao, taxa, saldoreal, saldobitcoin, "
                + "saldoethereum, saldoripple) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Timestamp insertData = stringToTimeStamp(data);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, investidor.getSenha());
        statement.setTimestamp(2, insertData);
        statement.setString(3, operacao);
        statement.setDouble(4, valor);
        statement.setString(5, moeda);
        statement.setObject(6, cotacao);
        statement.setDouble(7, taxa);
        statement.setDouble(8, investidor.getCarteira().getSaldoReal());
        statement.setDouble(9, investidor.getCarteira().getSaldoBitcoin());
        statement.setDouble(10, investidor.getCarteira().getSaldoEthereum());
        statement.setDouble(11, investidor.getCarteira().getSaldoRipple());
        statement.execute();
    }
    
    /* Seleciona todas as ocorrências da senha na tabela */
    public ResultSet consultarExtrato (int senha) throws SQLException {

        String sql = "select * from transacoes where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, senha);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
    
    /* Seleciona a última linha da tabela com base na data */
    public ResultSet consultar (int senha) throws SQLException {

        String sql = "select * from transacoes where senha = ? "
                + "order by data desc limit 1";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, senha);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
}
