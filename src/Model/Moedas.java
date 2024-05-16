package Model;

import java.util.Random;

/**
 *
 * @author Nathan Gabriel
 */
abstract class Moedas {
    abstract double saldo(double saldo);
    
    public static double novaCotacao() {
        double min = 0.95;
        double max = 1.05;

        Random random = new Random();
        double numeroAleatorio = min + (max - min) * random.nextDouble();
        double numFormatado = Math.round(numeroAleatorio * 100.0) / 100.0;
        
        return numFormatado;
    }
}
