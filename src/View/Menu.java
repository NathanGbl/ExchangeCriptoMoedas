/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author Nathan Gabriel
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        opcao1 = new javax.swing.JLabel();
        opcao2 = new javax.swing.JLabel();
        opcao3 = new javax.swing.JLabel();
        opcao4 = new javax.swing.JLabel();
        opcao5 = new javax.swing.JLabel();
        opcao6 = new javax.swing.JLabel();
        opcao7 = new javax.swing.JLabel();
        opcao8 = new javax.swing.JLabel();
        txtOpcao = new javax.swing.JTextField();
        lblOpcao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Menu");

        opcao1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcao1.setText("1. Consultar saldo");

        opcao2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcao2.setText("2. Consultar extrato");

        opcao3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcao3.setText("3. Depositar reais");

        opcao4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcao4.setText("4. Sacar reais");

        opcao5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcao5.setText("5. Comprar criptomoedas");

        opcao6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcao6.setText("6. Vender criptomoedas");

        opcao7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcao7.setText("7. Atualizar cotação");

        opcao8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcao8.setText("8. Sair");

        txtOpcao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblOpcao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOpcao.setText("Opção:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opcao2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(opcao5)
                                .addComponent(opcao6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(opcao8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblOpcao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOpcao))
                                    .addComponent(opcao7, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(opcao3)
                            .addComponent(opcao1)
                            .addComponent(opcao4))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(opcao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcao3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcao4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcao5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcao6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcao7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opcao8)
                        .addGap(18, 18, 18)
                        .addComponent(lblOpcao))
                    .addComponent(txtOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblOpcao;
    private javax.swing.JLabel opcao1;
    private javax.swing.JLabel opcao2;
    private javax.swing.JLabel opcao3;
    private javax.swing.JLabel opcao4;
    private javax.swing.JLabel opcao5;
    private javax.swing.JLabel opcao6;
    private javax.swing.JLabel opcao7;
    private javax.swing.JLabel opcao8;
    private javax.swing.JTextField txtOpcao;
    // End of variables declaration//GEN-END:variables
}
