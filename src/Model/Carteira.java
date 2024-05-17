/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
        setBitcoin(new Bitcoin());
        setEthereum(new Ethereum());
        setRipple(new Ripple());
        setSaldoReal(saldoReal);
        setSaldoBitcoin(saldoBitcoin);
        setSaldoEthereum(saldoEthereum);
        setSaldoRipple(saldoRipple);
    }

    public Carteira() {
        setBitcoin(new Bitcoin());
        setEthereum(new Ethereum());
        setRipple(new Ripple());
        setSaldoReal(0);
        setSaldoBitcoin(0);
        setSaldoEthereum(0);
        setSaldoRipple(0);
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

    public Moedas getRipple() {
        return ripple;
    }

    public void setRipple(Ripple ripple) {
        this.ripple = ripple;
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
}
