/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package es.iesellago.tema2.MascotasApp.View;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Este JPanel dispone de varios botones y otro panel, donde se visualizará lo
 * que accione cada botón.
 *
 * @author mauri_
 */
public class VentanaDelete extends javax.swing.JPanel {

    /**
     * Creates new form VentanaInsercciones
     */
    public VentanaDelete() {
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
        btnEliminarVacuna = new javax.swing.JButton();
        btnEliminarPaciente = new javax.swing.JButton();
        btnEliminarPeso = new javax.swing.JButton();
        pnFormEliminarPaciente = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(755, 400));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIMINACIÓN DE DATOS");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);

        btnEliminarVacuna.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminarVacuna.setText("ELIMINAR VACUNA");
        btnEliminarVacuna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarVacunaMouseClicked(evt);
            }
        });
        btnEliminarVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVacunaActionPerformed(evt);
            }
        });

        btnEliminarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminarPaciente.setText("ELIMINAR PACIENTE");
        btnEliminarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarPacienteMouseClicked(evt);
            }
        });
        btnEliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPacienteActionPerformed(evt);
            }
        });

        btnEliminarPeso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminarPeso.setText("ELIMINAR PESO");
        btnEliminarPeso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarPesoMouseClicked(evt);
            }
        });
        btnEliminarPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPesoActionPerformed(evt);
            }
        });

        pnFormEliminarPaciente.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnFormEliminarPacienteLayout = new javax.swing.GroupLayout(pnFormEliminarPaciente);
        pnFormEliminarPaciente.setLayout(pnFormEliminarPacienteLayout);
        pnFormEliminarPacienteLayout.setHorizontalGroup(
            pnFormEliminarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnFormEliminarPacienteLayout.setVerticalGroup(
            pnFormEliminarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminarPaciente)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(btnEliminarVacuna))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(btnEliminarPeso))
                    .addComponent(pnFormEliminarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarVacuna)
                    .addComponent(btnEliminarPeso)
                    .addComponent(btnEliminarPaciente))
                .addGap(29, 29, 29)
                .addComponent(pnFormEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPacienteActionPerformed

    }//GEN-LAST:event_btnEliminarPacienteActionPerformed

    private void btnEliminarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarPacienteMouseClicked
        FormularioEliminarPaciente formElimPaciente = new FormularioEliminarPaciente();
        insertarPanel(formElimPaciente);
    }//GEN-LAST:event_btnEliminarPacienteMouseClicked

    private void btnEliminarPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPesoActionPerformed

    private void btnEliminarVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVacunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarVacunaActionPerformed

    private void btnEliminarVacunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarVacunaMouseClicked
        FormularioEliminarVacuna formElimVacuna = new FormularioEliminarVacuna();
        insertarPanel(formElimVacuna);
    }//GEN-LAST:event_btnEliminarVacunaMouseClicked

    private void btnEliminarPesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarPesoMouseClicked
        FormularioEliminarPeso formElimPeso = new FormularioEliminarPeso();
        insertarPanel(formElimPeso);
    }//GEN-LAST:event_btnEliminarPesoMouseClicked
    /**
     * Función de incialización de panel.
     *
     * @param panel El panel que se quiere ver.
     */

    public void insertarPanel(JPanel panel) {
        int ancho = pnFormEliminarPaciente.getWidth();
        int alto = pnFormEliminarPaciente.getHeight();

        panel.setSize(ancho, alto);
        panel.setLocation(0, 0);
        pnFormEliminarPaciente.removeAll();
        pnFormEliminarPaciente.add(panel, BorderLayout.CENTER);
        pnFormEliminarPaciente.revalidate();
        pnFormEliminarPaciente.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarPaciente;
    private javax.swing.JButton btnEliminarPeso;
    private javax.swing.JButton btnEliminarVacuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnFormEliminarPaciente;
    // End of variables declaration//GEN-END:variables
}