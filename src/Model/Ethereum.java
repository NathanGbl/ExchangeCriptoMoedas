/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author unifnleite
 */
public class Ethereum extends Moedas implements Tarifacao {
    private double taxaCompra = 1.01;
    private double taxaVenda = 1.02;
    
    private double cotacao;
    
    public double getTaxaCompra() {
        return taxaCompra;
    }
    public double getTaxaVenda() {
        return taxaVenda;
    }
    
    public double getCotacao() {
        return cotacao;
    }
    
    public double saldo(double saldoEthereum) {
        return saldoEthereum;
    }
}
