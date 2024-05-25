package Model;

import java.util.Random;

/**
 *
 * @author Nathan Gabriel
 */
public abstract class Moedas {
    abstract double saldo(double saldo);
    
    public static double novaCotacao() {
        double min = 0.95;
        double max = 1.05;

        Random random = new Random();
        double numeroAleatorio = min + (max - min) * random.nextDouble();
        double numFormatado = Math.round(numeroAleatorio * 100.0) / 100.0;
        
        return numFormatado;
    }
    
    public static Moedas fabricaMoedas(String tipo) {
        if (tipo.equals("Bitcoin")) {
            return new Bitcoin();
        } else if (tipo.equals("Ethereum")) {
            return new Ethereum();
        } else if (tipo.equals("Ripple")) {
            return new Ripple();
        } else {
            return null;
        }
    }
}
