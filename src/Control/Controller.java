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

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }
    
    private static Controller control;
    private Investidor investidor;

    public static Controller getControl() {
        if (control == null) {
            control = new Controller();
        }
        return control;
    }
    
    public void loginAluno(String cpf, int senha, Login login) {
        Conexao conexao = new Conexao();
        try {
//            System.out.println("Foi0");
            Connection conn = conexao.getConnection();
//            System.out.println("Foi1");
            InvestidoresDAO dao = new InvestidoresDAO(conn);
//            System.out.println("Foi-1");
            ResultSet res = dao.consultar(cpf, senha);
//            System.out.println("Foi2");
            if (res.next()) {
//                System.out.println("Foi3");
                String nome = res.getString("nome");
                cpf = res.getString("cpf");
                senha = res.getInt("senha");
                investidor = new Investidor(nome, cpf, senha);
                JOptionPane.showMessageDialog(login, "Login feito!");
                Menu menu = new Menu();
                menu.setVisible(true);
                login.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(login, "Login não efetuado!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(login, "Erro de conexão!");
        }
    }
    
    public void consultarSaldo(ConsultarSaldo consultSaldo, int senha) {
        Conexao conexao = new Conexao();
        try {
            System.out.println("Foi0");
            Connection conn = conexao.getConnection();
            System.out.println("Foi1");
            TransacoesDAO dao = new TransacoesDAO(conn);
            System.out.println("Foi-1");
            ResultSet res = dao.consultar(senha, "");
            System.out.println("Foi2");
            if (res.next()) {
              System.out.println("Foi3");
                String info = investidor.getNome() +
                        "\nCPF: " + investidor.getCpf() +
                        "\n\nSaldo Real: " + res.getDouble("saldoReal") +
                        "\nSaldo Bitcoin: " + res.getDouble("saldoBitcoin") +
                        "\nSaldo Ethereum: " + res.getDouble("saldoEthereum") +
                        "\nSaldo Ripple: " + res.getDouble("saldoRipple");
                consultSaldo.getConsultaSaldo().setText(info);
            } else {
                JOptionPane.showMessageDialog(consultSaldo, "Senha incorreta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(consultSaldo, "Erro de conexão!");
        }
    }
    
    public String linhaTabela(ResultSet res) {
        ResultSetMetaData resMT = res.getMetaData();
    }
    
    public void consultarExtrato(ConsultarExtrato consultarExtrato, int senha) {
        Conexao conexao = new Conexao();
        try {
//            System.out.println("Foi0");
            Connection conn = conexao.getConnection();
//            System.out.println("Foi1");
            TransacoesDAO dao = new TransacoesDAO(conn);
//            System.out.println("Foi-1");
            ResultSet res = dao.consultarExtrato(senha);
//            System.out.println("Foi2");
            String info = "";
            if (res.next()){
                info = investidor.getNome() + "\nCPF: " + investidor.getCpf();
                while (res.next()) {
                info += "\n" + res.getRow();
                System.out.println("Foi");
                }
                consultarExtrato.getConsultaExtrato().setText(info);
            } else {
                JOptionPane.showMessageDialog(consultarExtrato, "senha incorreta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(consultarExtrato, "Erro de conexão!");
        }
    }
}
