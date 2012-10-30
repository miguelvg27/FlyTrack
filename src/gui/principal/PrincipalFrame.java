/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.principal;

import beans.Vuelo;
import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import gui.clientes.Clientes;
import gui.aeropuerto.Aeropuerto;
import gui.envios.EnvioDialog;
import gui.reporte.ReporteFrame;
import gui.vuelos.Vuelos;
import javax.swing.UIManager;

/**
 *
 * @author ronald
 */
public class PrincipalFrame extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalFrame
     */
    public PrincipalFrame() {
        try {
        UIManager.setLookAndFeel(new GTKLookAndFeel());
    } catch (Exception e) { }
        
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        envioButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        simulacionButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        administracionButton = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        administracionButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        administracionButton3 = new javax.swing.JButton();
        administracionButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FlyTrack");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        envioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/envio4848.png"))); // NOI18N
        envioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envioButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel2.setText("Envíos");

        simulacionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/simulacion48x48.png"))); // NOI18N
        simulacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulacionButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel5.setText("Simulación");

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setText("Administración");

        administracionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Configuration.png"))); // NOI18N
        administracionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administracionButtonActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit48x48.png"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel6.setText("Cerrar Sesión");

        administracionButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte48x48.png"))); // NOI18N
        administracionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administracionButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel7.setText("Reportes");

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel8.setText("Clientes");

        administracionButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario48x48.png"))); // NOI18N
        administracionButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administracionButton3ActionPerformed(evt);
            }
        });

        administracionButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seguridad48x48.png"))); // NOI18N
        administracionButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administracionButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel9.setText("Seguridad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administracionButton)
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(administracionButton3)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(envioButton)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(administracionButton4)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(administracionButton2)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(simulacionButton)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCerrar)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)))
                .addGap(300, 300, 300))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(administracionButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(administracionButton4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(envioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(simulacionButton)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(administracionButton3)
                        .addGap(18, 18, 18)
                        .addComponent(administracionButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jLabel3.setText("Copyleft (l). Todos los derechos compartidos.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void administracionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administracionButtonActionPerformed
        // TODO add your handling code here:
        MenuAdministracionFrame menuAdmin = new MenuAdministracionFrame();
        menuAdmin.setVisible(true);
    }//GEN-LAST:event_administracionButtonActionPerformed

    private void envioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envioButtonActionPerformed
        // TODO add your handling code here:
        EnvioDialog envio = new EnvioDialog();
        envio.setVisible(true);
    }//GEN-LAST:event_envioButtonActionPerformed

    private void simulacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulacionButtonActionPerformed
        // TODO add your handling code here:
        //Simulacion simulacion = new Simulacion();
        //simulacion.setVisible(true);
    }//GEN-LAST:event_simulacionButtonActionPerformed

    private void administracionButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administracionButton3ActionPerformed
        // TODO add your handling code here:
        Clientes clientes = new Clientes();
        clientes.setVisible(true);
    }//GEN-LAST:event_administracionButton3ActionPerformed

    private void administracionButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administracionButton2ActionPerformed
        // TODO add your handling code here:
        ReporteFrame reporteFrame = new ReporteFrame();
        reporteFrame.setVisible(true);
    }//GEN-LAST:event_administracionButton2ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login login = new Login();
        login.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void administracionButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administracionButton4ActionPerformed
        // TODO add your handling code here:
        MenuSeguridadFrame menuSeguridad = new MenuSeguridadFrame();
        menuSeguridad.setVisible(true);
    }//GEN-LAST:event_administracionButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton administracionButton;
    private javax.swing.JButton administracionButton2;
    private javax.swing.JButton administracionButton3;
    private javax.swing.JButton administracionButton4;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton envioButton;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton simulacionButton;
    // End of variables declaration//GEN-END:variables
}
