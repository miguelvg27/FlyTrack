/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.envios;

import beans.Cliente;
import beans.Envio;
import beans.Escala;
import beans.Parametro;
import beans.Vuelo;
import controllers.CAeropuerto;
import controllers.CCliente;
import controllers.CEnvio;
import controllers.CParametro;
import controllers.CSerializer;
import controllers.CValidator;
import controllers.CVuelo;
import gui.ErrorDialog;
import gui.InformationDialog;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import xml.XmlEnvio;
import xml.xmlVueloString;

/**
 *
 * @author jugox
 */
public class EnvioCarga extends javax.swing.JDialog {

    /**
     * Creates new form EnvioCarga
     */
    
    boolean archivovalido=false;
    
    public EnvioCarga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
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
        txtRuta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnRuta = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("tituloPanel"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/envio4848.png"))); // NOI18N
        jLabel1.setText("Envíos");
        jLabel1.setAutoscrolls(true);
        jLabel1.setName("tituloLabel"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtRuta.setEnabled(false);

        jLabel2.setText("Seleccionar archivo");

        btnRuta.setText("...");
        btnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaActionPerformed(evt);
            }
        });

        btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRuta)
                .addGap(29, 29, 29))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        int rslt = jfc.showSaveDialog(this);
        if (rslt == JFileChooser.APPROVE_OPTION){
            String strArch = jfc.getSelectedFile().getName();
            if (!strArch.trim().isEmpty()){
                String ruta = jfc.getSelectedFile().getPath().trim();
                if (!ruta.isEmpty()){
                    try{
                        if (!ruta.endsWith(".xml")){
                            ErrorDialog.mostrarError("Debe especificar un archivo xml", this);
                        }
                        else{

                            archivovalido=true;
                            txtRuta.setText(ruta);
                        }

                    }
                    catch (Exception e){
                        e.printStackTrace();
                        ErrorDialog.mostrarError("El archivo debe ser xml.",this);
                    }
                }
                else
                ErrorDialog.mostrarError("Especifique una ruta válida para guardar el archivo",this);
            }
            else
            ErrorDialog.mostrarError("Especifique un nombre al archivo",this);
        }

    }//GEN-LAST:event_btnRutaActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed
    private ArrayList<beans.Envio>  PasaValores(ArrayList<XmlEnvio> xmlenvios){
        CParametro cparametro = new CParametro();
        CAeropuerto caeropuerto = new CAeropuerto();
        CCliente ccliente = new CCliente();
        ArrayList<Envio> listaenvios=null;
        
        
        try{
            
            listaenvios = new ArrayList<Envio>();

            for (Integer s=0; s<xmlenvios.size();s++){


                XmlEnvio xmlenvioaux=(XmlEnvio)xmlenvios.get(s);


                Envio envio  = new Envio();
                
                
                // DATOS DEL ENVIO
                envio.setNumPaquetes(xmlenvioaux.getNumPaquetes());
                envio.setMonto(xmlenvioaux.getMonto());
                envio.setIva(xmlenvioaux.getIva());
                envio.setUnitario(xmlenvioaux.getUnitario());
                envio.setImpuesto(xmlenvioaux.getUnitario());
                envio.setNumDocVenta(xmlenvioaux.getNumDocVenta());
                
                Integer anosal= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(0,4));
                Integer anolle= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(0,4));
                Integer messal= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(5,7));
                Integer meslle= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(5,7));
                Integer diasal= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(8,10));
                Integer dialle= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(8,10));
                Integer horasal= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(11,13));
                Integer horalle= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(11,13));
                Integer minsal= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(14,16));
                Integer minlle= Integer.parseInt(xmlenvios.get(s).getFecharegis().substring(14,16));
                
                Calendar calendario = Calendar.getInstance();
                Calendar calendario2 = Calendar.getInstance();
                calendario.set(anosal, messal-1, diasal, horasal, minsal);
                Date fecha = calendario.getTime();
                calendario2.set(anolle, meslle-1, dialle, horalle, minlle);
                Date fecha2 = calendario2.getTime();
                
                envio.setFechaRecojo(fecha2);
                envio.setFechaRegistro(fecha);
                
                Parametro moneda= CParametro.buscarXValorUnicoyTipo("TIPO_MONEDA", xmlenvios.get(s).getMoneda());
                if (moneda==null) {
                    ErrorDialog.mostrarError("moneda inválido en registro "+ s.toString(), this);
                    return null;
                }
                else envio.setMoneda(moneda);
                Parametro tipodoc= CParametro.buscarXValorUnicoyTipo("TIPO_DOC_PAGO_ENVIO", xmlenvios.get(s).getTipodoc());
                if (tipodoc==null) {
                    ErrorDialog.mostrarError("tipodoc inválido en registro "+ s.toString(), this);
                    return null;
                }
                else envio.setTipoDocVenta(tipodoc);
                Parametro estado= CParametro.buscarXValorUnicoyTipo("ESTADO_ENVIO", xmlenvios.get(s).getEstado());
                if (estado==null) {
                    ErrorDialog.mostrarError("Estado inválido en registro "+ s.toString(), this);
                    return null;
                }
                else envio.setEstado(estado);
                Parametro estadofactura= CParametro.buscarXValorUnicoyTipo("ESTADO_FACTURA", xmlenvios.get(s).getEstadofac());
                if (estadofactura==null) {
                    ErrorDialog.mostrarError("Estado factura inválido en registro "+ s.toString(), this);
                    return null;
                }
                else envio.setEstadoFactura(estadofactura);
                
                beans.Aeropuerto aerodes= CAeropuerto.BuscarNombre(xmlenvios.get(s).getDestino());
                if (aerodes==null) {
                    ErrorDialog.mostrarError("Aeropuerto destino inválido en registro "+ s.toString(), this);
                    return null;
                }
                else envio.setDestino(aerodes);
                beans.Aeropuerto aeroori= CAeropuerto.BuscarNombre(xmlenvios.get(s).getOrigen());
                if (aeroori==null) {
                    ErrorDialog.mostrarError("Aeropuerto origen inválido en registro "+ s.toString(), this);
                    return null;
                }
                else envio.setOrigen(aeroori);
                beans.Aeropuerto aeroact= CAeropuerto.BuscarNombre(xmlenvios.get(s).getActual());
                if (aeroact==null) {
                    ErrorDialog.mostrarError("Aeropuerto actual inválido en registro "+ s.toString(), this);
                    return null;
                }
                else envio.setActual(aeroact);
                
                Cliente clienterem = ccliente.BuscarXid(1);
                Cliente clientedes = ccliente.BuscarXid(2);
                
                envio.setRemitente(clienterem);
                envio.setDestinatario(clientedes);
                
                
                // Datos de escala
                Escala e=new Escala();
                e.setNumEscala(1);
                e.setOriginal(true);
                Parametro estadoescala= CParametro.buscarXValorUnicoyTipo("ESTADO_ESCALA", xmlenvios.get(s).getEstado());
                if (estadoescala==null) {
                    ErrorDialog.mostrarError("Estado inválido en registro "+ s.toString(), this);
                    return null;
                }
                else e.setEstado(estadoescala);
                
                Vuelo v = CVuelo.buscarVueloId(xmlenvioaux.getVuelo());
                e.setVuelo(v);
                e.setEnvio(envio);
                                
                envio.getEscalas().add(e);
                
                listaenvios.add(envio);
                              

            }
        
        }
            catch(ClassCastException e){
                    
                    ErrorDialog.mostrarError("Ocurrió un error al cargar el archivo.",this);
                    return null;    
            
        }
        return listaenvios;
    }
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        //        generaraeropuertos();
        //        serializar(listaaero, "PruebaCargaAero.xml");
        //
        CEnvio cenvio = new CEnvio();
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (archivovalido) {
            try {
                ArrayList<XmlEnvio> xmlEnvios = CSerializer.deserializar(txtRuta.getText());
                //          ArrayList aeropuertos=CSerializer.deserializar("PruebaCargaAero.xml");\
                ArrayList<beans.Envio> envios = PasaValores(xmlEnvios);
                if (envios != null ) {
                    try {
                        
                        for (int i = 0; i < envios.size(); i++) {
                            Envio envio = (Envio) envios.get(i);
                            cenvio.guardarEnvio(envio);
                         
                        }
                        //setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        InformationDialog.mostrarInformacion("La operación se realizó con éxito ", this);
                        this.dispose();
                    } catch (Exception e) {
                        //e.printStackTrace();
                        ErrorDialog.mostrarError("Ocurrió un error al cargar los archivos xml.", this);
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
                ErrorDialog.mostrarError("Ocurrió un error al cargar los archivos xml.", this);
            }
        }else {
            ErrorDialog.mostrarError("Ocurrió un error al cargar los archivos xml.", this);
        }

        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btn_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(EnvioCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnvioCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnvioCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnvioCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EnvioCarga dialog = new EnvioCarga(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnRuta;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
