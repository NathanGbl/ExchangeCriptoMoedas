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
        Random rand = new Random();
        
        // Gerando um número aleatório entre 0 e 0.1
        double randomNumber = rand.nextDouble() * 0.1;
        
        // Ajustando o número para o intervalo desejado (0.95 a 1.05)
        double randomInRange = 0.95 + randomNumber;
        
        // Arredondando o número para duas casas decimais
        double roundedNumber = Math.round(randomInRange * 100.0) / 100.0;
        
        return roundedNumber;
    }
    
    private double cotacao = novaCotacao();
    
    public double getTaxaCompra() {
        return taxaCompra;
    }
    public double getTaxaVenda() {
        return taxaVenda;
    }
}
