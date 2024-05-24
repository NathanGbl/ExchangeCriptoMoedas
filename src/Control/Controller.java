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
import java.text.ParseException;

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
    
    public void loginInvestidor(String cpf, int senha, Login login) {
        Conexao conexao = new Conexao();
        try {
            double saldoReal;
            double saldoBitcoin;
            double saldoEthereum;
            double saldoRipple;
            Connection conn = conexao.getConnection();
            InvestidoresDAO daoInvestidores = new InvestidoresDAO(conn);
            TransacoesDAO daoTransacoes = new TransacoesDAO(conn);
            ResultSet res = daoInvestidores.consultar(cpf, senha);
            ResultSet resTransacoes = daoTransacoes.consultar(senha);
            if (res.next()) {
                String nome = res.getString("nome");
                cpf = res.getString("cpf");
                senha = res.getInt("senha");
                if (resTransacoes.next()) {
                    saldoReal = resTransacoes.getDouble("saldoReal");
                    saldoBitcoin = resTransacoes.getDouble("saldoBitcoin");
                    saldoEthereum = resTransacoes.getDouble("saldoEthereum");
                    saldoRipple = resTransacoes.getDouble("saldoRipple");
                } else {
                    saldoReal = 0;
                    saldoBitcoin = 0;
                    saldoEthereum = 0;
                    saldoRipple = 0;
                }
                investidor = new Investidor(nome, cpf, senha, saldoReal, 
                saldoBitcoin, saldoEthereum, saldoRipple);
                JOptionPane.showMessageDialog(login, "Login feito!");
                Menu menu = new Menu();
                menu.setVisible(true);
                login.dispose();
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
            ResultSet res = dao.consultar(senha);
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
                consultarExtrato.getConsultaExtrato().append(info);
                while (res.next()) {
                info = "\n" + res.getString("data") + 
                        " " + res.getString("operacao") + 
                        " " + res.getString("moeda") + 
                        " " + "CT: " + res.getDouble("cotacao") +
                        " " + "Taxa: " + res.getDouble("taxa") +
                        " " + "Real: " + res.getDouble("saldoReal") +
                        " " + "Bitcoin: " + res.getDouble("saldoBitcoin") +
                        " " + "Ethereum: " + res.getDouble("saldoEthereum") +
                        " " + "Ripple: " + res.getDouble("saldoRipple");
                consultarExtrato.getConsultaExtrato().append(info);
                }
            } else {
                JOptionPane.showMessageDialog(consultarExtrato, "senha incorreta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(consultarExtrato, "Erro de conexão!");
        }
    }
    
    public void depositar(DepositarReais depositarReais, 
                          String deposito) throws ParseException {
        Conexao conexao = new Conexao();
        double valor = Double.parseDouble(deposito);
        try {
//            System.out.println("Foi0");
            Connection conn = conexao.getConnection();
//            System.out.println("Foi1");
            TransacoesDAO dao = new TransacoesDAO(conn);
//            System.out.println("Foi-1");
            investidor.getCarteira().setSaldoReal(
                    investidor.getCarteira().getSaldoReal() + valor);
            String data = investidor.getCarteira().getDataNow();
//            System.out.println("Foi3");
            double[] cotacoes = {
                investidor.getCarteira().getBitcoin().getCotacao(), 
                investidor.getCarteira().getEthereum().getCotacao(), 
                investidor.getCarteira().getRipple().getCotacao()};
//            System.out.println("Foi4");
            dao.inserir(investidor, data, "+", valor, "Real", cotacoes, 0.0);
//            System.out.println("Foi5");
            JOptionPane.showMessageDialog(depositarReais, 
                                          "Depósito realizado com sucesso");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
//    public void sacar(SacarReais sacarReais, double saque) {
//        Conexao conexao = new Conexao();
//        try {
////            System.out.println("Foi0");
//            Connection conn = conexao.getConnection();
////            System.out.println("Foi1");
//            TransacoesDAO dao = new TransacoesDAO(conn);
////            System.out.println("Foi-1");
//            ResultSet res = dao.consultarExtrato(senha);
////            System.out.println("Foi2");
//            String info = "";
//            if (res.next()){
//                info = investidor.getNome() + "\nCPF: " + investidor.getCpf();
//                consultarExtrato.getConsultaExtrato().append(info);
//                while (res.next()) {
//                info = "\n" + res.getString("data") + 
//                        " " + res.getString("operacao") + 
//                        " " + res.getString("moeda") + 
//                        " " + "CT: " + res.getDouble("cotacao") +
//                        " " + "Taxa: " + res.getDouble("taxa") +
//                        " " + "Real: " + res.getDouble("saldoReal") +
//                        " " + "Bitcoin: " + res.getDouble("saldoBitcoin") +
//                        " " + "Ethereum: " + res.getDouble("saldoEthereum") +
//                        " " + "Ripple: " + res.getDouble("saldoRipple");
//                consultarExtrato.getConsultaExtrato().append(info);
//                }
//            } else {
//                JOptionPane.showMessageDialog(consultarExtrato, "senha incorreta");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(consultarExtrato, "Erro de conexão!");
//        }
//    }
//    
//    public void comprarCripto(ComprarCriptoMoedas comprarCripto, double compra) {
//        Conexao conexao = new Conexao();
//        try {
////            System.out.println("Foi0");
//            Connection conn = conexao.getConnection();
////            System.out.println("Foi1");
//            TransacoesDAO dao = new TransacoesDAO(conn);
////            System.out.println("Foi-1");
//            ResultSet res = dao.consultarExtrato(senha);
////            System.out.println("Foi2");
//            String info = "";
//            if (res.next()){
//                info = investidor.getNome() + "\nCPF: " + investidor.getCpf();
//                consultarExtrato.getConsultaExtrato().append(info);
//                while (res.next()) {
//                info = "\n" + res.getString("data") + 
//                        " " + res.getString("operacao") + 
//                        " " + res.getString("moeda") + 
//                        " " + "CT: " + res.getDouble("cotacao") +
//                        " " + "Taxa: " + res.getDouble("taxa") +
//                        " " + "Real: " + res.getDouble("saldoReal") +
//                        " " + "Bitcoin: " + res.getDouble("saldoBitcoin") +
//                        " " + "Ethereum: " + res.getDouble("saldoEthereum") +
//                        " " + "Ripple: " + res.getDouble("saldoRipple");
//                consultarExtrato.getConsultaExtrato().append(info);
//                }
//            } else {
//                JOptionPane.showMessageDialog(consultarExtrato, "senha incorreta");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(consultarExtrato, "Erro de conexão!");
//        }
//    }
//    
//    public void venderCripto(VenderCriptoMoedas venderCripto, double venda) {
//        Conexao conexao = new Conexao();
//        try {
////            System.out.println("Foi0");
//            Connection conn = conexao.getConnection();
////            System.out.println("Foi1");
//            TransacoesDAO dao = new TransacoesDAO(conn);
////            System.out.println("Foi-1");
//            ResultSet res = dao.consultarExtrato(senha);
////            System.out.println("Foi2");
//            String info = "";
//            if (res.next()){
//                info = investidor.getNome() + "\nCPF: " + investidor.getCpf();
//                consultarExtrato.getConsultaExtrato().append(info);
//                while (res.next()) {
//                info = "\n" + res.getString("data") + 
//                        " " + res.getString("operacao") + 
//                        " " + res.getString("moeda") + 
//                        " " + "CT: " + res.getDouble("cotacao") +
//                        " " + "Taxa: " + res.getDouble("taxa") +
//                        " " + "Real: " + res.getDouble("saldoReal") +
//                        " " + "Bitcoin: " + res.getDouble("saldoBitcoin") +
//                        " " + "Ethereum: " + res.getDouble("saldoEthereum") +
//                        " " + "Ripple: " + res.getDouble("saldoRipple");
//                consultarExtrato.getConsultaExtrato().append(info);
//                }
//            } else {
//                JOptionPane.showMessageDialog(consultarExtrato, "senha incorreta");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(consultarExtrato, "Erro de conexão!");
//        }
//    }
//    
//    public void atualizarCotacao(AtualizarCotacao atualizarCot, double novaCot, 
//            String moeda) {
//        Conexao conexao = new Conexao();
//        try {
////            System.out.println("Foi0");
//            Connection conn = conexao.getConnection();
////            System.out.println("Foi1");
//            TransacoesDAO dao = new TransacoesDAO(conn);
////            System.out.println("Foi-1");
//            ResultSet res = dao.consultarExtrato(senha);
////            System.out.println("Foi2");
//            String info = "";
//            if (res.next()){
//                info = investidor.getNome() + "\nCPF: " + investidor.getCpf();
//                consultarExtrato.getConsultaExtrato().append(info);
//                while (res.next()) {
//                info = "\n" + res.getString("data") + 
//                        " " + res.getString("operacao") + 
//                        " " + res.getString("moeda") + 
//                        " " + "CT: " + res.getDouble("cotacao") +
//                        " " + "Taxa: " + res.getDouble("taxa") +
//                        " " + "Real: " + res.getDouble("saldoReal") +
//                        " " + "Bitcoin: " + res.getDouble("saldoBitcoin") +
//                        " " + "Ethereum: " + res.getDouble("saldoEthereum") +
//                        " " + "Ripple: " + res.getDouble("saldoRipple");
//                consultarExtrato.getConsultaExtrato().append(info);
//                }
//            } else {
//                JOptionPane.showMessageDialog(consultarExtrato, "senha incorreta");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(consultarExtrato, "Erro de conexão!");
//        }
//    }
}
