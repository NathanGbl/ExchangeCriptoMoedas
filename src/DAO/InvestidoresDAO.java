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
    
    // Verifica se existe algum investidor cadastrado com tal cpf e tal senha
    public ResultSet consultar (String cpf, int senha) throws SQLException {


        String sql = "select * from investidores where cpf = ? and senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        statement.setInt(2, senha);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
       
        return resultado;
    }
}