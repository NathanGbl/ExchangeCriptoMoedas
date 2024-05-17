/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

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
        Investidor investidor = new Investidor("", view.getTxtCpf().getText()
                                      , Integer.parseInt(view.getTxtSenha().getText()));
        Conexao conexao = new Conexao();
        try {
//            System.out.println("Foi0");
            Connection conn = conexao.getConnection();
//            System.out.println("Foi1");
            InvestidoresDAO dao = new InvestidoresDAO(conn);
//            System.out.println("Foi-1");
            ResultSet res = dao.consultar(investidor);
//            System.out.println("Foi2");
            if (res.next()) {
//                System.out.println("Foi3");
                JOptionPane.showMessageDialog(view, "Login feito!");
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                Integer senha = res.getInt("senha");
                Menu viewMenu = new Menu();
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
