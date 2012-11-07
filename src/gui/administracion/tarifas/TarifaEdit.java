/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.administracion.tarifas;

import beans.Aeropuerto;
import beans.Cliente;
import beans.Parametro;
import beans.Tarifa;
import controllers.CTarifa;
import controllers.CValidator;
import gui.ErrorDialog;
import gui.administracion.aeropuertos.AeropuertoPopup;
import gui.clientes.ClientesEdit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author joao
 */
public class TarifaEdit extends javax.swing.JDialog {

    /**
     * Creates new form TarifaEdit
     */
    CTarifa TarifaBL = new CTarifa();
    Aeropuerto AeroOri=null;
    Aeropuerto AeroDes=null;
    List<Parametro> ListaMonedas;
    List<Parametro> ListaEstadoTarifa;
    int idtarifa=-1;
    Tarifa TarifaBE;
    
    public TarifaEdit(javax.swing.JDialog parent, boolean modal,int id) {
        super(parent, modal);
        idtarifa=id;
        initComponents();
        cargarcombos();
        
        if (idtarifa!=-1){
            cargarcampos();
        }
        
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
        jPanel2 = new javax.swing.JPanel();
        txtAeroOri = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtAeroDes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaAct = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFechaDes = new javax.swing.JTextField();
        cboMoneda = new javax.swing.JComboBox();
        cboEstado = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tarifa48x48.png"))); // NOI18N
        jLabel1.setText("TARIFA");
        jLabel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtAeroOri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAeroOriActionPerformed(evt);
            }
        });

        jLabel2.setText("Origen:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtAeroDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAeroDesActionPerformed(evt);
            }
        });

        jLabel3.setText("Destino:");

        jLabel6.setText("Monto:");

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        jLabel7.setText("Moneda:");

        jLabel8.setText("Estado:");

        jLabel9.setText("Fecha Activacion:");

        txtFechaAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha Desactivacion:");

        txtFechaDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaDesActionPerformed(evt);
            }
        });

        cboMoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAeroOri, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAeroDes, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFechaAct, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFechaDes, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAeroOri, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAeroDes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaAct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaDes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void cargarcampos(){
        
        TarifaBE=TarifaBL.BuscarXid(idtarifa);
           txtAeroOri.setText(TarifaBE.getOrigen().getNombre());
           txtAeroDes.setText(TarifaBE.getDestino().getNombre());
           txtMonto.setText(CValidator.formatNumber(TarifaBE.getMonto()));
           txtFechaAct.setText((CValidator.formatDate(TarifaBE.getFechaActivacion())).substring(0,10).replace("/", "-"));
           txtFechaDes.setText(CValidator.formatDate(TarifaBE.getFechaDesactivacion()).substring(0,10).replace("/", "-"));
           
           for(int i=1;i<cboMoneda.getItemCount();i++){
               Parametro moneda = (Parametro)cboMoneda.getItemAt(i);
               if (moneda.getIdParametro()==TarifaBE.getMoneda().getIdParametro())
               {
               cboMoneda.setSelectedIndex(i);
               break;
               
               }
           }
           
           for(int i=1;i<cboEstado.getItemCount();i++){
               Parametro estado = (Parametro)cboEstado.getItemAt(i);
               if (estado.getIdParametro()==TarifaBE.getEstado().getIdParametro())
               {
               cboEstado.setSelectedIndex(i);
               break;
               
               }
           }
                 
    }
    public void cargarcombos(){
        ListaMonedas=TarifaBL.ListarMonedas();
        ListaEstadoTarifa=TarifaBL.ListarEstadoMonedas();
        
        for (int i=0;i<ListaMonedas.size();i++)
        {
            Parametro Moneda =(Parametro)ListaMonedas.get(i);
            
            cboMoneda.addItem(Moneda);
        }
        for (int i=0;i<ListaEstadoTarifa.size();i++)
        {
            Parametro EstadoTarifa =(Parametro)ListaEstadoTarifa.get(i);
            
            cboEstado.addItem(EstadoTarifa);
        }
        
    }
    private void txtAeroOriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAeroOriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAeroOriActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AeropuertoPopup AeropuertoPU = new AeropuertoPopup(this, true);
        AeroOri = AeropuertoPU.showDialog();

        if (AeroOri != null) {
            txtAeroOri.setText(AeroOri.getNombre()+ ", "+AeroOri.getCiudad().getValor());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AeropuertoPopup AeropuertoPU = new AeropuertoPopup(this, true);
        AeroDes = AeropuertoPU.showDialog();

        if (AeroDes != null) {
            txtAeroDes.setText(AeroDes.getNombre()+ ", "+AeroDes.getCiudad().getValor());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtAeroDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAeroDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAeroDesActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtFechaActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActActionPerformed

    private void txtFechaDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String error_message = validarcampos();
        if (error_message.isEmpty()){
            if (idtarifa==-1){
                TarifaBL.agregarTarifa(AeroOri, AeroDes, txtMonto.getText(), (Parametro)cboMoneda.getSelectedItem(),(Parametro)cboMoneda.getSelectedItem() , txtFechaAct.getText(),txtFechaDes.getText());

            }
            else{
                Aeropuerto nuevoaeroori;
                Aeropuerto nuevoaerodes;
                if (AeroOri==null){
                    nuevoaeroori=TarifaBE.getOrigen();
                } 
                else{
                    nuevoaeroori=AeroOri;
                }

                if (AeroDes==null){
                    nuevoaerodes=TarifaBE.getDestino();
                } 
                else{
                    nuevoaerodes=AeroDes;
                }

                TarifaBL.ModificarTarifa(TarifaBE.getIdTarifa(),nuevoaeroori,nuevoaerodes,txtMonto.getText(),txtFechaAct.getText(),txtFechaDes.getText()
                        ,(Parametro)cboMoneda.getSelectedItem(),(Parametro)cboEstado.getSelectedItem());

            }
            setVisible(false);
            dispose();
        }
        
        else{
            
            ErrorDialog.mostrarError(error_message, this);
            
        }
        //TarifaBL.agregarTarifa(AeroOri, AeroDes, txtMonto.getText(), (Parametro)cboMoneda.getSelectedItem(),(Parametro)cboMoneda.getSelectedItem() , txtFechaAct.getText(),txtFechaDes.getText());
        
    }//GEN-LAST:event_jButton4ActionPerformed
    private String validarcampos(){
        
        String error_message = "";
        
        if (txtAeroOri.getText().isEmpty()||txtAeroDes.getText().isEmpty() || txtMonto.getText().isEmpty() ||
                    txtFechaAct.getText().isEmpty() ||  txtFechaDes.getText().isEmpty()
                ||cboEstado.getSelectedIndex()==0 || cboMoneda.getSelectedIndex()==0  ){
            
            error_message = error_message + CValidator.buscarError("ERROR_FT001") + "\n";
            
        }
        else{
            
//            if (idCliente==-1){
//
//                error_message = error_message+ ClienteBL.ValidarDocumento((Parametro)cboTipoDoc.getSelectedItem(),txtNumeroDoc.getText());
//            }
                      
            if (!CValidator.isInteger(txtMonto.getText())){
                
                error_message = "El monto es inválido";
                return null;
            }
                
            
            
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
            
            Date fechaact = null;
            Date fechades=null;
            try {

                fechaact = formatoDelTexto.parse(txtFechaAct.getText());
                fechades = formatoDelTexto.parse(txtFechaDes.getText());

            } catch (ParseException ex) {

                ex.printStackTrace();
                error_message = "La fecha es incorrecta";
                return error_message;
            }
            if (fechaact.after(fechades)){
                error_message = error_message + "La fecha de activación no puede ser menor a la de desactivación";
            }
            if (txtAeroOri.getText().equals(txtAeroDes.getText())){
                error_message = error_message + "La fecha de activación no puede ser menor a la de desactivación";
            }
                        
            if (idtarifa==-1){
                Aeropuerto nuevoaeroori;
                Aeropuerto nuevoaerodes;
                if (AeroOri==null){
                    nuevoaeroori=TarifaBE.getOrigen();
                } 
                else{
                    nuevoaeroori=AeroOri;
                }

                if (AeroDes==null){
                    nuevoaerodes=TarifaBE.getDestino();
                } 
                else{
                    nuevoaerodes=AeroDes;
                }

                error_message=TarifaBL.ValidarRuta(nuevoaeroori,nuevoaerodes);
            }
            
        }
                      
        return error_message;
        
        
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
    public int showDialog(){
            setVisible(true);
            return 1;
    }
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
            java.util.logging.Logger.getLogger(TarifaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarifaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarifaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarifaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TarifaEdit dialog = new TarifaEdit(new javax.swing.JDialog(), true,-1);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JComboBox cboMoneda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAeroDes;
    private javax.swing.JTextField txtAeroOri;
    private javax.swing.JTextField txtFechaAct;
    private javax.swing.JTextField txtFechaDes;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
