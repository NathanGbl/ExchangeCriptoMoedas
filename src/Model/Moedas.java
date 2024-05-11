package Model;

import java.util.Random;

/**
 *
 * @author Nathan Gabriel
 */
abstract class Moedas {
    private double taxaCompra, taxaVenda, cotacao;
    abstract double saldo(double saldo);
}
