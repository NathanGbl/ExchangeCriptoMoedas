package Model;

/**
 *
 * @author Nathan Gabriel
 */
abstract class Moedas {
    private double taxaCompra, taxaVenda, cotacao, investimento;
    abstract double novaCotacao();
}
