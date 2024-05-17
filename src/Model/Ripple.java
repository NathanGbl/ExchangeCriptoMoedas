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
public class Ripple extends Moedas implements Tarifacao {
    private double taxaCompra = 1.01;
    private double taxaVenda = 1.01;
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
    public double saldo(double saldoRipple) {
        return saldoRipple;
    }
}
