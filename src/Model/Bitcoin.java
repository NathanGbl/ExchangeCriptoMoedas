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
    private double taxaCompra = 1.02;
    private double taxaVenda = 1.03;
    
    public double novaCotacao() {
        double num = new Random().nextDouble();
        double cotacao = num + 0.1;
        return cotacao;
    }
    
    private double cotacao = novaCotacao();
    
    public double getTaxaCompra() {
        return taxaCompra;
    }
    public double getTaxaVenda() {
        return taxaVenda;
    }
}
