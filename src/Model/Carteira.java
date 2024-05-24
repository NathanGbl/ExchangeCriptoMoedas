/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.ComprarCriptoMoedas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import View.SacarReais;
import View.VenderCriptoMoedas;
import javax.swing.JOptionPane;

/**
 *
 * @author Nathan Gabriel
 */
public class Carteira{
    private double saldoReal, saldoBitcoin, saldoEthereum, saldoRipple;
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;
    public Carteira(double saldoReal, double saldoBitcoin, double saldoEthereum, double saldoRipple) {
        this.bitcoin = ((Bitcoin)Moedas.fabricaMoedas("Bitcoin"));
        this.ethereum = ((Ethereum)Moedas.fabricaMoedas("Ethereum"));
        this.ripple = ((Ripple)Moedas.fabricaMoedas("Ripple"));
        setSaldoReal(saldoReal);
        setSaldoBitcoin(saldoBitcoin);
        setSaldoEthereum(saldoEthereum);
        setSaldoRipple(saldoRipple);
    }

    public Carteira() {
        this.bitcoin = ((Bitcoin)Moedas.fabricaMoedas("Bitcoin"));
        this.ethereum = ((Ethereum)Moedas.fabricaMoedas("Ethereum"));
        this.ripple = ((Ripple)Moedas.fabricaMoedas("Ripple"));
        setSaldoReal(0);
        setSaldoBitcoin(0);
        setSaldoEthereum(0);
        setSaldoRipple(0);
    }

    public double getSaldoReal() {
        return saldoReal;
    }

    public void setSaldoReal(double saldoReal) {
        this.saldoReal = saldoReal;
    }

    public double getSaldoBitcoin() {
        return saldoBitcoin;
    }

    public void setSaldoBitcoin(double saldoBitcoin) {
        this.saldoBitcoin = saldoBitcoin;
    }

    public double getSaldoEthereum() {
        return saldoEthereum;
    }

    public void setSaldoEthereum(double saldoEthereum) {
        this.saldoEthereum = saldoEthereum;
    }

    public double getSaldoRipple() {
        return saldoRipple;
    }

    public void setSaldoRipple(double saldoRipple) {
        this.saldoRipple = saldoRipple;
    }

    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(Bitcoin bitcoin) {
        this.bitcoin = bitcoin;
    }

    public Ethereum getEthereum() {
        return ethereum;
    }

    public void setEthereum(Ethereum ethereum) {
        this.ethereum = ethereum;
    }

    public Ripple getRipple() {
        return ripple;
    }

    public void setRipple(Ripple ripple) {
        this.ripple = ripple;
    }
    
    public String getDataNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dataHoraAtual = now.format(forma);
        return dataHoraAtual;
    }
    
    public void deposito(double valor) {
        double montante = getSaldoReal() + valor;
        setSaldoReal(montante);
    }
    
    public void saque(double valor, SacarReais sacarReais) {
        double montante = getSaldoReal() - valor;
        if (montante < 0) {
            JOptionPane.showMessageDialog(sacarReais, "Saldo não pode ficar negativo");
        } else {
            setSaldoReal(montante);
        }
    }
    
    public void comprarCripto(double valor, String moeda, ComprarCriptoMoedas comprarCripto) {
        double montante;
        double saldoFuturo;
        Boolean error = false;
        if (moeda.equals("Bitcoin")) {
            saldoFuturo = saldoReal - valor * bitcoin.getTaxaCompra();
            if (saldoFuturo >= 0) {
                setSaldoReal(saldoFuturo);
                montante = valor / bitcoin.getCotacao();
                saldoBitcoin += montante;
            } else {
                error = true;
            }
        } else if (moeda.equals("Ethereum")) {
            saldoFuturo = saldoReal - valor * ethereum.getTaxaCompra();
            if (saldoFuturo >= 0) {
                setSaldoReal(saldoFuturo);
                montante = valor / bitcoin.getCotacao();
                saldoEthereum += montante;
            } else {
                error = true;
            }
        } else if (moeda.equals("Ripple")) {
            saldoFuturo = saldoReal - valor * ripple.getTaxaCompra();
            if (saldoFuturo >= 0) {
                setSaldoReal(saldoFuturo);
                montante = valor / bitcoin.getCotacao();
                saldoRipple += montante;
            } else {
                error = true;
            }
        }
        if (error) {
            JOptionPane.showMessageDialog(comprarCripto, "Saldo não pode ficar negativo");
        }
    }
    
    public void venderCripto(double valor, String moeda, VenderCriptoMoedas venderCripto) {
        double montante;
        double saldoFuturo;
        Boolean saldoNegativo = false;
        if (moeda.equals("Bitcoin")) {
            saldoFuturo = saldoBitcoin - valor * bitcoin.getTaxaVenda();
            if (saldoFuturo >= 0) {
                saldoBitcoin -= saldoFuturo;
                setSaldoReal(saldoFuturo);
                montante = saldoFuturo * bitcoin.getCotacao();
                saldoReal += montante;
            } else {
                saldoNegativo = true;
            }
        } else if (moeda.equals("Ethereum")) {
            saldoFuturo = saldoEthereum - valor * ethereum.getTaxaVenda();
            if (saldoFuturo >= 0) {
                saldoEthereum -= saldoFuturo;
                setSaldoReal(saldoFuturo);
                montante = saldoFuturo * ethereum.getCotacao();
                saldoReal += montante;
            } else {
                saldoNegativo = true;
            }
        } else if (moeda.equals("Ripple")) {
            saldoFuturo = saldoRipple - valor * ripple.getTaxaVenda();
            if (saldoFuturo >= 0) {
                saldoRipple -= saldoFuturo;
                setSaldoReal(saldoFuturo);
                montante = saldoFuturo * ripple.getCotacao();
                saldoReal += montante;
            } else {
                saldoNegativo = true;
            }
        }
        if (saldoNegativo) {
            JOptionPane.showMessageDialog(venderCripto, "Saldo não pode ficar negativo");
        }
    }
}
