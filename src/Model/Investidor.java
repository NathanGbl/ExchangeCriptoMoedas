/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nathan Gabriel
 */
public class Investidor extends Pessoa{

    public Carteira getCarteira() {
        return carteira;
    }
    
    private Carteira carteira;
    
    public Investidor(String nome, String cpf, int senha) {
        super(nome, cpf, senha);
        carteira = new Carteira();
    }
    
    public Investidor(String nome, String cpf, int senha, double saldoReal, double saldoBitcoin, double saldoEthereum, double saldoRipple) {
        super(nome, cpf, senha);
        carteira = new Carteira(saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
    }
}
