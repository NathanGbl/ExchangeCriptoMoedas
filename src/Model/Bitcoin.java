/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Random;

/**
 *
 * @author unifnleite
 */
public class Bitcoin extends Moedas implements Tarifacao {
    private double taxaCompra = 0.98;
    private double taxaVenda = 0.97;
    private double cotacao = Moedas.novaCotacao();

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    @Override
    public double getTaxaCompra() {
        return taxaCompra;
    }
    
    @Override
    public double getTaxaVenda() {
        return taxaVenda;
    }
    
    public double getCotacao() {
        return cotacao;
    }
    
    @Override
    public double saldo(double saldoBitcoin) {
        return saldoBitcoin;
    }
}
