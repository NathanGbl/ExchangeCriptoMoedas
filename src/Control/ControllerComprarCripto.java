/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Bitcoin;

import View.ComprarCriptoMoedas;

/**
 *
 * @author Nathan Gabriel
 */
public class ControllerComprarCripto {
    private ComprarCriptoMoedas view;
    
    public ControllerComprarCripto(ComprarCriptoMoedas view) {
        this.view = view;
    }
    
    public void investir() {
        try {
            double investimento = Double.parseDouble(view.getTxtSaque().getText());
            String moeda;
            double cotacao;
            if (view.getBitcoinBtn().isSelected()) {
                moeda = "Bitcoin";
                cotacao = Double.parseDouble(view.getCotBitcoin().getText());
            } else if (view.getEthereumBtn().isSelected()) {
                moeda = "Ethereum";
                cotacao = Double.parseDouble(view.getCotEthereum().getText());
            } else if (view.getRippleBtn().isSelected()) {
                moeda = "Ripple";
                cotacao = Double.parseDouble(view.getCotRipple().getText());
            }
            
        }
    }
}
