package Model;

/**
 *
 * @author Nathan Gabriel
 */
abstract class Moedas {
    private double taxaCompra, taxaVenda, cotacao;
    abstract double novaCotacao();
}
