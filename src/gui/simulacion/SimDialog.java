/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.simulacion;

import beans.Aeropuerto;
import beans.Cliente;
import beans.Envio;
import beans.Parametro;
import beans.Sesion;
import beans.seguridad.Permiso;
import controllers.CEnvio;
import controllers.CSeguridad;
import gui.envios.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import logic.AeroLite;
import logic.EnvioLite;
import logic.VueloLite;

/**
 *
 * @author miguelavg
 */
public class SimDialog extends javax.swing.JDialog {

    /**
     * Creates new form Envio
     */
    private CEnvio cenvio;
    private Aeropuerto a_destino, a_origen, a_actual;
    private Cliente c_cliente;
    private Parametro p_estado;

    public SimDialog() {
        initComponents();
        definirPermisos();
    }

    @Override
    protected JRootPane createRootPane() {
        JRootPane rootPane = new JRootPane();
        KeyStroke strokeESC = KeyStroke.getKeyStroke("ESCAPE");
        Action actionListener = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(Boolean.FALSE);
                dispose();
            }
        };
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(strokeESC, "ESCAPE");
        rootPane.getActionMap().put("ESCAPE", actionListener);

        return rootPane;
    }

    private void llenarTablaAeroLites(List<AeroLite> aeropuertos) {
        DefaultTableModel dtm = (DefaultTableModel) tbl_aeropuertos.getModel();

        for (int i = dtm.getRowCount(); i > 0; i--) {
            dtm.removeRow(0);
        }

        if (aeropuertos == null) {
            return;
        }

        for (AeroLite a : aeropuertos) {
            llenarLineaTablaAeroLite(a, dtm);
        }
    }

    private void llenarLineaTablaAeroLite(AeroLite a, DefaultTableModel dtm) {
        Object[] datos = new Object[3];
        datos[0] = a.getNombre();
        datos[1] = a.getCapacidadActual();
        datos[2] = a.getCapacidadMax();
        dtm.addRow(datos);
    }

    private void llenarTablaVueloLites(List<VueloLite> vuelos) {
        DefaultTableModel dtm = (DefaultTableModel) tbl_vuelos.getModel();

        for (int i = dtm.getRowCount(); i > 0; i--) {
            dtm.removeRow(0);
        }

        if (vuelos == null) {
            return;
        }

        for (VueloLite v : vuelos) {
            llenarLineaTablaVueloLite(v, dtm);
        }
    }

    private void llenarLineaTablaVueloLite(VueloLite v, DefaultTableModel dtm) {
        Object[] datos = new Object[4];
        datos[0] = v.getNum();
        datos[1] = v.getOrigen();
        datos[2] = v.getDestino();
        datos[3] = v.getCapacidadMax();
        dtm.addRow(datos);
    }

    private void llenarEnvioLites(List<EnvioLite> envios) {
        DefaultTableModel dtm = (DefaultTableModel) tbl_envios.getModel();

        for (int i = dtm.getRowCount(); i > 0; i--) {
            dtm.removeRow(0);
        }

        if (envios == null) {
            return;
        }

        for (EnvioLite e : envios) {
            llenarLineaTablaEnvioLite(e, dtm);
        }
    }

    private void llenarLineaTablaEnvioLite(EnvioLite e, DefaultTableModel dtm) {
        Object[] datos = new Object[3];
        datos[0] = e.getNum();
        datos[1] = e.getOrigen();
        datos[2] = e.getDestino();
        dtm.addRow(datos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_envios = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_aeropuertos = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_vuelos = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_actualizar = new javax.swing.JButton();
        btn_simular = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FlyTrack - Simulación");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(770, 601));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setName("envioDialog"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("tituloPanel"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/simulacion48x48.png"))); // NOI18N
        jLabel1.setText("Simulación");
        jLabel1.setAutoscrolls(true);
        jLabel1.setName("tituloLabel"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(463, 463, 463)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/envio4848.png"))); // NOI18N
        jLabel5.setText("Envíos:");

        tbl_envios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Origen", "Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_envios);
        tbl_envios.getColumnModel().getColumn(0).setMinWidth(40);
        tbl_envios.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbl_envios.getColumnModel().getColumn(0).setMaxWidth(40);
        tbl_envios.getAccessibleContext().setAccessibleParent(jPanel3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(233, 233, 233))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aeropuerto48x48.png"))); // NOI18N
        jLabel8.setText("Aeropuertos");

        tbl_aeropuertos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "#paq", "Max. paq."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_aeropuertos);
        tbl_aeropuertos.getAccessibleContext().setAccessibleParent(jPanel2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(198, 198, 198))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbl_vuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Origen", "Destino", "Max. paq."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbl_vuelos);
        tbl_vuelos.getColumnModel().getColumn(0).setMinWidth(40);
        tbl_vuelos.getColumnModel().getColumn(0).setMaxWidth(40);
        tbl_vuelos.getAccessibleContext().setAccessibleParent(jPanel6);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vuelo48x48.png"))); // NOI18N
        jLabel9.setText("Vuelos:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar_sim.png"))); // NOI18N
        btn_actualizar.setToolTipText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_simular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/play_sim.png"))); // NOI18N
        btn_simular.setToolTipText("Simular");
        btn_simular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simularActionPerformed(evt);
            }
        });

        btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar_sim.png"))); // NOI18N
        btn_regresar.setToolTipText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(btn_actualizar)
                .addGap(18, 18, 18)
                .addComponent(btn_simular, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_regresar)
                .addGap(30, 30, 30))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_regresar)
                    .addComponent(btn_simular)
                    .addComponent(btn_actualizar))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("FlyTrack - Simulación");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_simularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simularActionPerformed
        // TODO add your handling code here:
        MonitoreoFrame monitoreoDialog = new MonitoreoFrame(null);
        monitoreoDialog.setVisible(true);
    }//GEN-LAST:event_btn_simularActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(SimDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimDialog().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_simular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbl_aeropuertos;
    private javax.swing.JTable tbl_envios;
    private javax.swing.JTable tbl_vuelos;
    // End of variables declaration//GEN-END:variables

    private void definirPermisos() {

        List<Permiso> permisos = Sesion.getUsuario().getPerfil().getPermisos();
        boolean crear = CSeguridad.validarPermiso(2, "Envios", "Crear", permisos);
        //boolean cargaMasiva = CSeguridad.validarPermiso(2, "Envios", "Carga Masiva", permisos);

        this.setLocationRelativeTo(null);
        pack();
    }
}
