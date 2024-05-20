/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAO.InvestidoresDAO;
import DAO.Conexao;
import DAO.TransacoesDAO;
import Model.Investidor;
import View.AtualizarCotacao;
import View.ComprarCriptoMoedas;
import View.ConsultarExtrato;
import View.ConsultarSaldo;
import View.DepositarReais;
import View.Login;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.Menu;
import View.SacarReais;
import View.VenderCriptoMoedas;

/**
 *
 * @author unifnleite
 */
public class Controller {
    private static Controller control;
    private Login login;
    private ConsultarSaldo consultSaldo;
    private ConsultarExtrato consultarExtrato;
    private DepositarReais depositarReais;
    private SacarReais sacarReais;
    private ComprarCriptoMoedas comprarCripto;
    private VenderCriptoMoedas venderCripto;
    private AtualizarCotacao atualizarCotacao;
    private Investidor investidor;

    public Controller(Login view, 
                      ConsultarSaldo consultSaldo,
                      ConsultarExtrato consultarExtrato,
                      DepositarReais depositarReais,
                      SacarReais sacarReais,
                      ComprarCriptoMoedas comprarCripto,
                      VenderCriptoMoedas venderCripto,
                      AtualizarCotacao atualizarCotacao) {
        this.login = view;
        this.consultSaldo = consultSaldo;
        this.consultarExtrato = consultarExtrato;
        this.depositarReais = depositarReais;
        this.sacarReais = sacarReais;
        this.comprarCripto = comprarCripto;
        this.venderCripto = venderCripto;
        this.atualizarCotacao = atualizarCotacao;
    }
    
    public static Controller getControl(Login view, 
                                        ConsultarSaldo consultSaldo,
                                        ConsultarExtrato consultarExtrato,
                                        DepositarReais depositarReais,
                                        SacarReais sacarReais,
                                        ComprarCriptoMoedas comprarCripto,
                                        VenderCriptoMoedas venderCripto,
                                        AtualizarCotacao atualizarCotacao) {
        if (control == null) {
            control = new Controller(view, 
                    consultSaldo, 
                    consultarExtrato, 
                    depositarReais, 
                    sacarReais, 
                    comprarCripto, 
                    venderCripto, 
                    atualizarCotacao);
        }
        return control;
    }
    
    public void loginAluno() {
        Investidor investidor = new Investidor("", login.getTxtCpf().getText()
                                      , Integer.parseInt(login.getTxtSenha().getText()));
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
                JOptionPane.showMessageDialog(login, "Login feito!");
                Menu viewMenu = new Menu();
                viewMenu.setVisible(true);
                login.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(login, "Login não efetuado!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(login, "Erro de conexão!");
        }
    }
    
    public void consultarSaldo() {
        Conexao conexao = new Conexao();
        try {
//            System.out.println("Foi0");
            Connection conn = conexao.getConnection();
//            System.out.println("Foi1");
            TransacoesDAO dao = new TransacoesDAO(conn);
//            System.out.println("Foi-1");
            ResultSet res = dao.consultar(investidor);
//            System.out.println("Foi2");
            if (res.next()) {
//              System.out.println("Foi3");
                consultSaldo.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(consultSaldo, "Senha incorreta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(consultSaldo, "Erro de conexão!");
        }
    }
    
    public void consultarExtrato() {
        
    }
}
