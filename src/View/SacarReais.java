/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Control.Controller;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Nathan Gabriel
 */
public class SacarReais extends javax.swing.JFrame {

    public JTextArea getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(JTextArea consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLblSaque() {
        return lblSaque;
    }

    public void setLblSaque(JLabel lblSaque) {
        this.lblSaque = lblSaque;
    }

    public JButton getSacaBtn() {
        return sacaBtn;
    }

    public void setSacaBtn(JButton sacaBtn) {
        this.sacaBtn = sacaBtn;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public JTextField getTxtSaque() {
        return txtSaque;
    }

    public void setTxtSaque(JTextField txtSaque) {
        this.txtSaque = txtSaque;
    }

    /**
     * Creates new form SacarReais
     */
    public SacarReais() {
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

        titulo = new javax.swing.JLabel();
        lblSaque = new javax.swing.JLabel();
        txtSaque = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        consultaSaldo = new javax.swing.JTextArea();
        sacaBtn = new javax.swing.JButton();
        voltarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo.setText("Sacar Reais");

        lblSaque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSaque.setText("Saque:");

        txtSaque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        consultaSaldo.setColumns(20);
        consultaSaldo.setRows(5);
        jScrollPane1.setViewportView(consultaSaldo);

        sacaBtn.setText("Sacar");
        sacaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacaBtnActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSaque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sacaBtn)
                            .addComponent(txtSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(137, 137, 137))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addComponent(voltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSaque)
                    .addComponent(txtSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(sacaBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarBtnActionPerformed

    private void sacaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacaBtnActionPerformed
        try {
            control.sacar(this, this.getTxtSaque().getText());
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_sacaBtnActionPerformed

    private Controller control;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea consultaSaldo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaque;
    private javax.swing.JButton sacaBtn;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtSaque;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
