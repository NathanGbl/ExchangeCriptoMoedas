/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
}
