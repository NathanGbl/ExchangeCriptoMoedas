/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.InvestidoresDAO;
import DAO.Conexao;
import Model.Investidor;
import View.Login;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.Menu;

/**
 *
 * @author unifnleite
 */
public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void loginAluno() {
        Investidor investidor = new Investidor(null, view.getTxtCpf()
                                      ,view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            InvestidoresDAO dao = new InvestidoresDAO(conn);
            ResultSet res = dao.consultar(investidor);
//            System.out.println(res.next());
            if (res.next()) {
                JOptionPane.showMessageDialog(view, "Login feito!");
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                Integer senha = res.getInt("senha");
                Menu viewMenu = new Menu(new Investidor (nome, cpf, senha));
                viewMenu.setVisible(true);
                view.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(view, "Login não efetuado!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
}
