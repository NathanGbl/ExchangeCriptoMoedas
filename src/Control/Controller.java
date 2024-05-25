/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAO.InvestidoresDAO;
import DAO.Conexao;
import DAO.TransacoesDAO;
import Model.Investidor;
import Model.Moedas;
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
import java.sql.Array;
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

    // Função feita para instanciar somente 1 controller
    public static Controller getControl() {
        if (control == null) {
            control = new Controller();
        }
        return control;
    }
    
    // Função retorna true se o comprimento da senha e do cpf estiver certo e
    // o cpf não tiver ponto nem traço
    public Boolean verificaCpfSenha(String cpf, int senha) {
        String senhaString = String.valueOf(senha);
        Boolean cpfSenhaValidos = true;
        for(int i = 0; i < cpf.length(); i++) {
            char letra = cpf.charAt(i);
            String caracter = String.valueOf(letra);
            if (caracter.equals(".") || caracter.equals("-")) {
                cpfSenhaValidos = false;
            }
        }
        if (senhaString.length() != 6 || cpf.length() != 11) {
            cpfSenhaValidos = false;
        }
        return cpfSenhaValidos;
    }
    
    // Insere os dados na variável investidor e se já tiver feito uma transação,
    // o contrutor é passado com os saldos que estiverem no banco de dados.
    public void loginInvestidor(String cpf, int senha, Login login) {
        Conexao conexao = new Conexao();
//        System.out.println("foi");
        try {
//            System.out.println("foi");
            double saldoReal;
            double saldoBitcoin;
            double saldoEthereum;
            double saldoRipple;
            Connection conn = conexao.getConnection();
//            System.out.println("foi");
            if (verificaCpfSenha(cpf, senha)) {
                InvestidoresDAO daoInvestidores = new InvestidoresDAO(conn);
                TransacoesDAO daoTransacoes = new TransacoesDAO(conn);
                System.out.println("foi");
                ResultSet res = daoInvestidores.consultar(cpf, senha);
                ResultSet resTransacoes = daoTransacoes.consultar(cpf);
                if (res.next()) {
                    String nome = res.getString("nome");
                    cpf = res.getString("cpf");
                    senha = res.getInt("senha");
                    if (resTransacoes.next()) {
                        saldoReal = resTransacoes.getDouble("saldoreal");
                        saldoBitcoin = resTransacoes.getDouble("saldobitcoin");
                        saldoEthereum = resTransacoes.getDouble("saldoethereum");
                        saldoRipple = resTransacoes.getDouble("saldoripple");
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
                    JOptionPane.showMessageDialog(login, "Login nÃ£o efetuado!");
                }
            } else {
                JOptionPane.showMessageDialog(login, "Senha e/ou cpf incorretos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(login, e);
        }
    }
    
    // Manda uma requisição pedindo a última linha da tabela com base na data.
    public void consultarSaldo(ConsultarSaldo consultSaldo, int senha) {
        Conexao conexao = new Conexao();
        try {
            if (verificaCpfSenha(investidor.getCpf(), senha)) {
                Connection conn = conexao.getConnection();
                TransacoesDAO dao = new TransacoesDAO(conn);
                ResultSet res = dao.consultar(investidor.getCpf());
                if (res.next()) {
                  System.out.println("Foi3");
                    String info = String.format(
                            investidor.getNome() +
                            "\nCPF: " + investidor.getCpf() +
                            "\n\nSaldo Real: %.2f" +
                            "\nSaldo Bitcoin: %.2f" +
                            "\nSaldo Ethereum: %.2f" +
                            "\nSaldo Ripple: %.2f"
                    , res.getDouble("saldoreal"), 
                    res.getDouble("saldobitcoin"), 
                    res.getDouble("saldoethereum"), 
                    res.getDouble("saldoripple"));
                    consultSaldo.getConsultaSaldo().setText(info);
                }
            } else {
                    JOptionPane.showMessageDialog(consultSaldo, "Senha incorreta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(consultSaldo, "Erro de conexÃ£o!");
        }
    }
    
    // Manda uma requisição pedindo todas as ocorrências da senha e imprime o
    // resultado
    public void consultarExtrato(ConsultarExtrato consultarExtrato, int senha) {
        Conexao conexao = new Conexao();
        try {
            if (verificaCpfSenha(investidor.getCpf(), senha)) {
                Connection conn = conexao.getConnection();
                TransacoesDAO dao = new TransacoesDAO(conn);
                ResultSet res = dao.consultarExtrato(investidor.getCpf());
                String info = "";
                consultarExtrato.getConsultaExtrato().setText(info);
                int cont = 0;
                while (res.next()) {
                    if (cont == 0) {
                        info = investidor.getNome() + "\nCPF: " + 
                        investidor.getCpf();
                        consultarExtrato.getConsultaExtrato().setText(info);
                    }
                    cont++;
                    info = String.format(
                            "\n" + res.getTimestamp("data") + 
                            " | " + res.getString("operacao") +
                            " | %.2f" +
                            " | " + res.getString("moeda") + 
                            " | " + "CT: " + res.getObject("cotacao") +
                            " | " + "Taxa: %.2f" +
                            " | " + "Real: %.2f" +
                            " | " + "Bitcoin: %.2f" +
                            " | " + "Ethereum: %.2f" +
                            " | " + "Ripple: %.2f"
                    , res.getDouble("valor"), 
                    res.getDouble("taxa"), 
                    res.getDouble("saldoReal"), 
                    res.getDouble("saldoBitcoin"), 
                    res.getDouble("saldoEthereum"), 
                    res.getDouble("saldoRipple")
                    );
                    consultarExtrato.getConsultaExtrato().append(info);
                }
            } else {
                    JOptionPane.showMessageDialog(consultarExtrato, "Senha incorreta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(consultarExtrato, "Erro de conexÃ£o!");
        }
    }
    
    // Verifica se o valor está correto e depois faz o depósito.
    // Se o saldo não alterou, então o saldo ficaria menor que 0
    // Se o saldo alterou, faz a conta e manda inserir uma nova linha na tabela
    // transacoes
    public void depositar(DepositarReais depositarReais, 
                          String deposito) throws ParseException {
        Conexao conexao = new Conexao();
        double valor = Double.parseDouble(deposito);
        try {
            if (valor >= 0) {
                Connection conn = conexao.getConnection();
                TransacoesDAO dao = new TransacoesDAO(conn);
                double saldoAntes = investidor.getCarteira().getSaldoReal();
                investidor.getCarteira().deposito(valor);
                if(investidor.getCarteira().getSaldoReal() != saldoAntes) {
                    String data = investidor.getCarteira().getDataNow();
                    double[] cotacoes = {
                    investidor.getCarteira().getBitcoin().getCotacao(), 
                    investidor.getCarteira().getEthereum().getCotacao(), 
                    investidor.getCarteira().getRipple().getCotacao()};
                    dao.inserir(investidor, data, "+", valor, "Real", cotacoes, 0.0);
                    JOptionPane.showMessageDialog(depositarReais, 
                                          "Depósito realizado com sucesso");
                    ResultSet res = dao.consultar(investidor.getCpf());
                    if (res.next()) {
                        double saldoReal = res.getDouble("saldoreal");
                        double saldoBitcoin = res.getDouble("saldobitcoin");
                        double saldoEthereum = res.getDouble("saldoethereum");
                        double saldoRipple = res.getDouble("saldoripple");
                        String texto = String.format(
                                "Saldo Real: %.2f\n"
                              + "Saldo Bitcoin: %.2f\n"
                              + "Saldo Ethereum: %.2f\n"
                              + "Saldo Ripple: %.2f\n",
                        saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
                        depositarReais.getConsultaSaldo().setText(texto);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(depositarReais, "Valor inváSlido");
            }
//           
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // Verifica se o valor está correto e depois faz o saque.
    // Se o saldo não alterou, então o saldo ficaria menor que 0
    // Se o saldo alterou, faz a conta e manda inserir uma nova linha na tabela
    // transacoes
    public void sacar(SacarReais sacarReais, String valor) throws ParseException {
        Conexao conexao = new Conexao();
        double saque = Double.parseDouble(valor);
        try {
            if (saque >= 0) {
                Connection conn = conexao.getConnection();
                TransacoesDAO dao = new TransacoesDAO(conn);
                double saldoAntes = investidor.getCarteira().getSaldoReal();
                investidor.getCarteira().saque(saque, sacarReais);
                if (investidor.getCarteira().getSaldoReal() != saldoAntes) {
                    String data = investidor.getCarteira().getDataNow();
                    double[] cotacoes = {
                        investidor.getCarteira().getBitcoin().getCotacao(), 
                        investidor.getCarteira().getEthereum().getCotacao(), 
                        investidor.getCarteira().getRipple().getCotacao()
                    };
                    dao.inserir(
                            investidor, 
                            data, 
                            "-", 
                            saque, 
                            "Real", 
                            cotacoes, 
                            0.0
                    );
                    JOptionPane.showMessageDialog(sacarReais, 
                                              "Saque realizado com sucesso");
                    ResultSet res = dao.consultar(investidor.getCpf());
                    if (res.next()) {
                        double saldoReal = res.getDouble("saldoreal");
                        double saldoBitcoin = res.getDouble("saldobitcoin");
                        double saldoEthereum = res.getDouble("saldoethereum");
                        double saldoRipple = res.getDouble("saldoripple");
                        String texto = String.format(
                                "Saldo Real: %.2f\n"
                              + "Saldo Bitcoin: %.2f\n"
                              + "Saldo Ethereum: %.2f\n"
                              + "Saldo Ripple: %.2f\n",
                        saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
                        sacarReais.getConsultaSaldo().setText(texto);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(sacarReais, "Valor inválido");
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Realiza a compra pela opção escolhida do investidor e pelo valor.
    // Se o valor não deixar o saldoreal negativo, então realiza a operação.
    // Depois insere uma nova linha na tabela com os dados.
    public void comprarCripto(ComprarCriptoMoedas comprarCripto, 
            double compra, 
            int senha) 
            throws ParseException {
        Conexao conexao = new Conexao();
        try {
            if (verificaCpfSenha(investidor.getCpf(), senha)) {
                if (compra >= 0) {
                Boolean saldoNegativo = false;
                Connection conn = conexao.getConnection();
                TransacoesDAO dao = new TransacoesDAO(conn);
                String data = investidor.getCarteira().getDataNow();
                double[] cotacoes = {
                        investidor.getCarteira().getBitcoin().getCotacao(), 
                        investidor.getCarteira().getEthereum().getCotacao(), 
                        investidor.getCarteira().getRipple().getCotacao()
                };
                    if (comprarCripto.getBitcoinBtn().isSelected()) {
                        double taxa = 
                        investidor.getCarteira().getBitcoin().getTaxaCompra();
                        double saldoAntes = 
                                investidor.getCarteira().getSaldoBitcoin();
                        investidor.getCarteira().comprarCripto(compra, 
                                "Bitcoin", comprarCripto);
                        double saldoDepois = 
                                investidor.getCarteira().getSaldoBitcoin();
                        if (saldoAntes != saldoDepois) {
                            dao.inserir(investidor, data, "+", compra, 
                                    "Bitcoin", cotacoes, taxa);
                        } else {
                            saldoNegativo = true;
                        }
                    } else if (comprarCripto.getEthereumBtn().isSelected()) {
                        double taxa = 
                        investidor.getCarteira().getEthereum().getTaxaCompra();
                        double saldoAntes = 
                                investidor.getCarteira().getSaldoEthereum();
                        investidor.getCarteira().comprarCripto(compra, 
                                "Ethereum", comprarCripto);
                        double saldoDepois = 
                                investidor.getCarteira().getSaldoEthereum();
                        if (saldoAntes != saldoDepois) {
                            dao.inserir(investidor, data, "+", compra, 
                                    "Ethereum", cotacoes, taxa);
                        } else {
                            saldoNegativo = true;
                        }
                    } else if (comprarCripto.getRippleBtn().isSelected()) {
                        double taxa = 
                        investidor.getCarteira().getRipple().getTaxaCompra();
                        double saldoAntes = 
                                investidor.getCarteira().getSaldoRipple();
                        investidor.getCarteira().comprarCripto(compra, 
                                "Ripple", comprarCripto);
                        double saldoDepois = 
                                investidor.getCarteira().getSaldoRipple();
                        if (saldoAntes != saldoDepois) {
                            dao.inserir(investidor, data, "+", compra, 
                                    "Ripple", cotacoes, taxa);
                        } else {
                            saldoNegativo = true;
                        }
                    }
                    if (saldoNegativo == false) {
                        JOptionPane.showMessageDialog(comprarCripto, 
                                              "Compra realizado com sucesso");
                    }
                } else {
                    JOptionPane.showMessageDialog(comprarCripto, "Valor inválido");
                }
            } else {
                    JOptionPane.showMessageDialog(comprarCripto, "Senha incorreta");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // Realiza a venda pela opção escolhida do investidor e pelo valor.
    // Se o valor não deixar o saldo da moeda negativo, então realiza a operação.
    // Depois insere uma nova linha na tabela com os dados.
    public void venderCripto(VenderCriptoMoedas venderCripto, 
            double venda, 
            int senha) 
            throws ParseException {
        Conexao conexao = new Conexao();
        try {
            if (verificaCpfSenha(investidor.getCpf(), senha)) {
                if (venda >= 0) {
                Boolean saldoNegativo = false;
                Connection conn = conexao.getConnection();
                TransacoesDAO dao = new TransacoesDAO(conn);
                String data = investidor.getCarteira().getDataNow();
                double[] cotacoes = {
                        investidor.getCarteira().getBitcoin().getCotacao(), 
                        investidor.getCarteira().getEthereum().getCotacao(), 
                        investidor.getCarteira().getRipple().getCotacao()
                };
                    if (venderCripto.getBitcoinBtn().isSelected()) {
                        double taxa = 
                        investidor.getCarteira().getBitcoin().getTaxaVenda();
                        double saldoAntes = 
                                investidor.getCarteira().getSaldoBitcoin();
                        investidor.getCarteira().venderCripto(venda, 
                                "Bitcoin", venderCripto);
                        double saldoDepois = 
                                investidor.getCarteira().getSaldoBitcoin();
                        if (saldoAntes != saldoDepois) {
                            dao.inserir(investidor, data, "-", venda, 
                                    "Bitcoin", cotacoes, taxa);
                        } else {
                            saldoNegativo = true;
                        }
                    } else if (venderCripto.getEthereumBtn().isSelected()) {
                        double taxa = 
                        investidor.getCarteira().getEthereum().getTaxaVenda();
                        double saldoAntes = 
                                investidor.getCarteira().getSaldoEthereum();
                        investidor.getCarteira().venderCripto(venda, 
                                "Ethereum", venderCripto);
                        double saldoDepois = 
                                investidor.getCarteira().getSaldoEthereum();
                        if (saldoAntes != saldoDepois) {
                            dao.inserir(investidor, data, "-", venda, 
                                    "Ethereum", cotacoes, taxa);
                        } else {
                            saldoNegativo = true;
                        }
                        dao.inserir(investidor, data, "-", venda, 
                                    "Ethereum", cotacoes, taxa);
                    } else if (venderCripto.getRippleBtn().isSelected()) {
                        double taxa = 
                        investidor.getCarteira().getRipple().getTaxaVenda();
                        double saldoAntes = 
                                investidor.getCarteira().getSaldoRipple();
                        investidor.getCarteira().venderCripto(venda, 
                                "Ripple", venderCripto);
                        double saldoDepois = 
                                investidor.getCarteira().getSaldoRipple();
                        if (saldoAntes != saldoDepois) {
                            dao.inserir(investidor, data, "-", venda, 
                                    "Ripple", cotacoes, taxa);
                        } else {
                            saldoNegativo = true;
                        }
                        dao.inserir(investidor, data, "-", venda, 
                                    "Ripple", cotacoes, taxa);
                    }
                    if (saldoNegativo == false) {
                        JOptionPane.showMessageDialog(venderCripto, 
                                              "Venda realizado com sucesso");
                    }
                } else {
                    JOptionPane.showMessageDialog(venderCripto, 
                            "Valor inválido");
                }     
            } else {
                    JOptionPane.showMessageDialog(venderCripto, "Senha incorreta");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // Função que coloca um valor no text field da cotação da moeda selecionada
    public void novaCotacao(AtualizarCotacao atualizarCot) {
        double novaCotacao = Moedas.novaCotacao();
        String novaCot = String.valueOf(novaCotacao);
        if (atualizarCot.getBitcoinBtn().isSelected()) {
            atualizarCot.getCotBitcoin().setText(novaCot);
        } else if (atualizarCot.getEthereumBtn().isSelected()) {
            atualizarCot.getCotEthereum().setText(novaCot);
        } else if (atualizarCot.getRippleBtn().isSelected()) {
            atualizarCot.getCotRipple().setText(novaCot);
        }
    }
    
    // Troca o valor da cotação selecionada pelo usuário
    public void atualizarCotacao(AtualizarCotacao atualizarCot) {
        double novaCot = 0;
        double cotFormat = 0;
        if (atualizarCot.getBitcoinBtn().isSelected()) {
            novaCot = Double.parseDouble(atualizarCot.getCotBitcoin().getText());
            double cotAntiga = investidor.getCarteira().getBitcoin().getCotacao();
            cotFormat = Math.round((novaCot * cotAntiga) * 100) / 100;
            investidor.getCarteira().getBitcoin().setCotacao(cotFormat);
        } else if (atualizarCot.getEthereumBtn().isSelected()) {
            novaCot = Double.parseDouble(atualizarCot.getCotEthereum().getText());
            double cotAntiga = investidor.getCarteira().getEthereum().getCotacao();
            cotFormat = Math.round((novaCot * cotAntiga) * 100) / 100;
            investidor.getCarteira().getEthereum().setCotacao(cotFormat);
        } else if (atualizarCot.getRippleBtn().isSelected()) {
            novaCot = Double.parseDouble(atualizarCot.getCotRipple().getText());
            double cotAntiga = investidor.getCarteira().getRipple().getCotacao();
            cotFormat = Math.round((novaCot * cotAntiga) * 100) / 100;
            investidor.getCarteira().getRipple().setCotacao(cotFormat);
        }
        JOptionPane.showMessageDialog(atualizarCot, "Atualizou com sucesso!");
    }
}
