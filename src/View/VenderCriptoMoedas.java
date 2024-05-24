/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Nathan Gabriel
 */
public class VenderCriptoMoedas extends javax.swing.JFrame {

    public JRadioButton getBitcoinBtn() {
        return bitcoinBtn;
    }

    public void setBitcoinBtn(JRadioButton bitcoinBtn) {
        this.bitcoinBtn = bitcoinBtn;
    }

    public ButtonGroup getButtons() {
        return buttons;
    }

    public void setButtons(ButtonGroup buttons) {
        this.buttons = buttons;
    }

    public JTextField getCotBitcoin() {
        return cotBitcoin;
    }

    public void setCotBitcoin(JTextField cotBitcoin) {
        this.cotBitcoin = cotBitcoin;
    }

    public JTextField getCotEthereum() {
        return cotEthereum;
    }

    public void setCotEthereum(JTextField cotEthereum) {
        this.cotEthereum = cotEthereum;
    }

    public JTextField getCotRipple() {
        return cotRipple;
    }

    public void setCotRipple(JTextField cotRipple) {
        this.cotRipple = cotRipple;
    }

    public JRadioButton getEthereumBtn() {
        return ethereumBtn;
    }

    public void setEthereumBtn(JRadioButton ethereumBtn) {
        this.ethereumBtn = ethereumBtn;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JLabel getLblCotBitcoin() {
        return lblCotBitcoin;
    }

    public void setLblCotBitcoin(JLabel lblCotBitcoin) {
        this.lblCotBitcoin = lblCotBitcoin;
    }

    public JLabel getLblCotEthereum() {
        return lblCotEthereum;
    }

    public void setLblCotEthereum(JLabel lblCotEthereum) {
        this.lblCotEthereum = lblCotEthereum;
    }

    public JLabel getLblCotRipple() {
        return lblCotRipple;
    }

    public void setLblCotRipple(JLabel lblCotRipple) {
        this.lblCotRipple = lblCotRipple;
    }

    public JLabel getLblVenda() {
        return lblVenda;
    }

    public void setLblVenda(JLabel lblVenda) {
        this.lblVenda = lblVenda;
    }

    public JRadioButton getRippleBtn() {
        return rippleBtn;
    }

    public void setRippleBtn(JRadioButton rippleBtn) {
        this.rippleBtn = rippleBtn;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public JTextField getTxtVenda() {
        return txtVenda;
    }

    public void setTxtVenda(JTextField txtVenda) {
        this.txtVenda = txtVenda;
    }

    public JButton getVenderBtn() {
        return venderBtn;
    }

    public void setVenderBtn(JButton venderBtn) {
        this.venderBtn = venderBtn;
    }

    /**
     * Creates new form VenderCriptoMoedas
     */
    public VenderCriptoMoedas() {
        initComponents();
        control = Controller.getControl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttons = new javax.swing.ButtonGroup();
        lblVenda = new javax.swing.JLabel();
        txtVenda = new javax.swing.JTextField();
        venderBtn = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bitcoinBtn = new javax.swing.JRadioButton();
        ethereumBtn = new javax.swing.JRadioButton();
        rippleBtn = new javax.swing.JRadioButton();
        lblCotBitcoin = new javax.swing.JLabel();
        lblCotEthereum = new javax.swing.JLabel();
        lblCotRipple = new javax.swing.JLabel();
        cotRipple = new javax.swing.JTextField();
        cotEthereum = new javax.swing.JTextField();
        cotBitcoin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        voltarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVenda.setText("Venda:");

        txtVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        venderBtn.setText("Vender");
        venderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderBtnActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo.setText("Vender Criptomoedas");

        buttons.add(bitcoinBtn);
        bitcoinBtn.setText("Bitcoin");

        buttons.add(ethereumBtn);
        ethereumBtn.setText("Ethereum");

        buttons.add(rippleBtn);
        rippleBtn.setText("Ripple");

        lblCotBitcoin.setText("Cotação:");

        lblCotEthereum.setText("Cotação:");

        lblCotRipple.setText("Cotação:");

        jLabel2.setText("Taxa de venda: 3%");

        jLabel4.setText("Taxa de venda: 2%");

        jLabel6.setText("Taxa de venda: 1%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bitcoinBtn)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCotBitcoin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cotBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCotEthereum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cotEthereum, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ethereumBtn))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCotRipple)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cotRipple, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rippleBtn)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bitcoinBtn)
                    .addComponent(ethereumBtn)
                    .addComponent(rippleBtn))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cotRipple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCotRipple)
                    .addComponent(lblCotEthereum)
                    .addComponent(lblCotBitcoin)
                    .addComponent(cotEthereum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cotBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        voltarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/voltarIcon.png"))); // NOI18N
        voltarBtn.setBorder(null);
        voltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(venderBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(titulo)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titulo)
                    .addComponent(voltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVenda))
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(venderBtn)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void venderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderBtnActionPerformed
        Double venda = Double.parseDouble(this.getTxtVenda().getText());
        control.comprarCripto(this, venda);// TODO add your handling code here:
    }//GEN-LAST:event_venderBtnActionPerformed

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
       Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarBtnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VenderCriptoMoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VenderCriptoMoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VenderCriptoMoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VenderCriptoMoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VenderCriptoMoedas().setVisible(true);
//            }
//        });
//    }

    private Controller control;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bitcoinBtn;
    private javax.swing.ButtonGroup buttons;
    private javax.swing.JTextField cotBitcoin;
    private javax.swing.JTextField cotEthereum;
    private javax.swing.JTextField cotRipple;
    private javax.swing.JRadioButton ethereumBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCotBitcoin;
    private javax.swing.JLabel lblCotEthereum;
    private javax.swing.JLabel lblCotRipple;
    private javax.swing.JLabel lblVenda;
    private javax.swing.JRadioButton rippleBtn;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtVenda;
    private javax.swing.JButton venderBtn;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
