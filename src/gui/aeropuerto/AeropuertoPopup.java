/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.aeropuerto;

import beans.Parametro;
import controllers.CAeropuerto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class AeropuertoPopup extends javax.swing.JDialog {
 
    private CAeropuerto Caeropuerto = new CAeropuerto();
    
    private List<Parametro> ListatipoPar; 
    private List<Parametro> ListatipoEst; 
    private List<Parametro> ListatipoHijo;
    private beans.Aeropuerto ObjAero = new beans.Aeropuerto();
    
     List<beans.Aeropuerto> listaAeropuertos;
    /**
     * Creates new form AeropuertoPopup
     */
    public AeropuertoPopup(javax.swing.JDialog parent, boolean modal) {
        initComponents();
        llenarComboPais();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        cbm_Pais = new javax.swing.JComboBox();
        cbm_ciudad = new javax.swing.JComboBox();
        cbm_estado = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_aeropuerto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("País:");

        jLabel3.setText("Ciudad:");

        jLabel4.setText("Estado:");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        cbm_Pais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perú" }));
        cbm_Pais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbm_PaisMouseReleased(evt);
            }
        });
        cbm_Pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbm_PaisActionPerformed(evt);
            }
        });

        cbm_ciudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lima" }));

        cbm_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo" }));
        cbm_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbm_estadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbm_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbm_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbm_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbm_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbm_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbm_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbl_aeropuerto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Ciudad", "País", "Estado", "X", "Y", "Capacidad max de almacenamiento", "Capacidad actual de almacenamiento"
            }
        ));
        tbl_aeropuerto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_aeropuertoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_aeropuerto);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
          listaAeropuertos = CAeropuerto.BuscarAeropuerto(ListatipoPar.get(cbm_Pais.getSelectedIndex()).getIdParametro(),
                ListatipoHijo.get(cbm_ciudad.getSelectedIndex()).getIdParametro(),ListatipoEst.get(cbm_estado.getSelectedIndex()).getIdParametro());
        
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_aeropuerto.getModel();
        Object[] datos = new Object[9];
        
        for (int i = 0; i < listaAeropuertos.size(); i++) {
            
           datos[0] = listaAeropuertos.get(i).getNombre();
           datos[1] = listaAeropuertos.get(i).getCiudad();
           datos[2] = listaAeropuertos.get(i).getPais();
           datos[3] = listaAeropuertos.get(i).getCoordX();
           datos[4] = listaAeropuertos.get(i).getCoordY();
           
           datos[5] = listaAeropuertos.get(i).getCapacidadMax();
           datos[6] = listaAeropuertos.get(i).getCapacidadActual();
           
           dtm.addRow(datos);
       }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void cbm_PaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbm_PaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbm_PaisActionPerformed

    private void cbm_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbm_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbm_estadoActionPerformed

    private void cbm_PaisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbm_PaisMouseReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cbm_PaisMouseReleased

    private void tbl_aeropuertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_aeropuertoMouseClicked
        // TODO add your handling code here:
        
        
         ObjAero = listaAeropuertos.get(tbl_aeropuerto.getSelectedRow());
         
         this.dispose();
        
    }//GEN-LAST:event_tbl_aeropuertoMouseClicked

   
            
            
    private void llenarComboPais(){
        List<Parametro> ListatipoPar; 
        
        ListatipoPar = Caeropuerto.llenarComboPais();
      for (int i=0;i<ListatipoPar.size();i++)
        {
            Parametro TipoDocBE =(Parametro)ListatipoPar.get(i);
            
            cbm_Pais.addItem(TipoDocBE);
        }
     }
    
     private void llenarComboEstado(){
      
        
        ListatipoEst = CAeropuerto.llenarComboEstado();
      for (int i=0;i<ListatipoEst.size();i++)
        {
            Parametro TipoDocBE =(Parametro)ListatipoEst.get(i);
            
            cbm_estado.addItem(TipoDocBE);
        }
     }
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
            java.util.logging.Logger.getLogger(AeropuertoPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AeropuertoPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AeropuertoPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AeropuertoPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AeropuertoPopup().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JComboBox cbm_Pais;
    private javax.swing.JComboBox cbm_ciudad;
    private javax.swing.JComboBox cbm_estado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_aeropuerto;
    // End of variables declaration//GEN-END:variables
}
