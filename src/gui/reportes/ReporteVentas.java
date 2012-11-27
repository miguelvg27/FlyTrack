/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reportes;

import beans.Aeropuerto;
import beans.Envio;
import beans.Parametro;
import beans.seguridad.Pista;
import controllers.CAeropuerto;
import controllers.CEnvio;
import controllers.CValidator;
import controllers.CVuelo;
import gui.ErrorDialog;
    import gui.administracion.aeropuertos.AeropuertoPopup;
import java.awt.Cursor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jugox
 */
public class ReporteVentas extends javax.swing.JFrame {
    private Aeropuerto aeropuertoOrigen;
    private List<Parametro>ListaTipoDoc = null;
    private Aeropuerto aeropuertoDestino;
    private List<Parametro> ListaTipoEstado;
    private List<Envio> listaEnvios = null;
    private Object dt_fechini;
    
    ArrayList<Envio> listaEnviosaux;
    ArrayList<Venta>  listaventas = new  ArrayList<Venta>() ;
    ArrayList<Venta>  listaventasoficial= new ArrayList<Venta>() ;
    
    

    /**
     * Creates new form ReporteVentas
     */
    
      /*
         * select * from envio
where fecharegistro < ''
 and  fecharegistro > ''
 and  idorigen = 2
 and  iddestino = 3
 and  estado = 'dsd'
 and  tipodocventa = 
         */
    public ReporteVentas() {
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

        btnBuscar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dtFechaIni = new datechooser.beans.DateChooserCombo();
        dtFechaFin = new datechooser.beans.DateChooserCombo();
        jLabel5 = new javax.swing.JLabel();
        txt_origen = new javax.swing.JTextField();
        btn_origenAero = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ventas = new javax.swing.JTable();

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnRegresar.setText("Regresar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tarifa48x48.png"))); // NOI18N
        jLabel3.setText("Ventas");
        jLabel3.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Fecha Inicial:");

        dtFechaIni.setNothingAllowed(false);
        try {
            dtFechaIni.setDefaultPeriods(new datechooser.model.multiple.PeriodSet());
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
            e1.printStackTrace();
        }
        dtFechaIni.setLocale(new java.util.Locale("es", "PE", ""));

        dtFechaFin.setNothingAllowed(false);
        try {
            dtFechaFin.setDefaultPeriods(new datechooser.model.multiple.PeriodSet());
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
            e1.printStackTrace();
        }
        dtFechaFin.setLocale(new java.util.Locale("es", "PE", ""));

        jLabel5.setText("Fecha Final:");

        txt_origen.setEnabled(false);

        btn_origenAero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btn_origenAero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_origenAeroActionPerformed(evt);
            }
        });

        jLabel4.setText("Origen");

        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnRegresar1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_origen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_origenAero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addGap(71, 71, 71)
                        .addComponent(dtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_origen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_origenAero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar1)
                    .addComponent(btnBuscar1))
                .addGap(27, 27, 27))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte48x48.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        tbl_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aeropuerto", "Mes", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_ventas);
        tbl_ventas.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_ventas.getColumnModel().getColumn(2).setPreferredWidth(200);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
//        ListaEnviosDataSource listaenviosds= new ListaEnviosDataSource();
//        listaenviosds.setListaEnvios(listaEnvios);
        
        VentaDataSource listaventasds= new VentaDataSource();
        listaventasds.setListaVentas(listaventasoficial);
        
    if (listaventasds!=null){
        try {
            //JasperReport reporte = JasperCompileManager.compileReport("NetBeansProjects/FlyTrack/src/gui/reportes/ReporteAlmacen.jrxml");
            String master = System.getProperty("user.dir") +
                                "/src/gui/reportes/ReporteVentas.jasper";
            
            JasperReport masterReport = null;
            try
            {
                masterReport = (JasperReport) JRLoader.loadObjectFromFile(master);//.loadObject(master);
            }
            catch (JRException e)
            {
                //JOptionPane.showMessageDialog(null, "Error cargando la Guía de Remisión: " + e.getMessage(), "Mensaje",0);
                return;
            }
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, listaventasds);
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH_mm");
            Date fechaactual = Calendar.getInstance().getTime(); 
            String reportDate = df.format(fechaactual);
            String nombreReporteLogs = "Reporte_Ventas_" +reportDate+ ".pdf";
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(nombreReporteLogs));
            exporter.exportReport();
            
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(nombreReporteLogs);
            jviewer.setVisible(true);
            //exportar=true;
            
            //CReportes.mostrarMensajeSatisfaccion("Se guardó satisfactoriamente el reporte Nro " + nombreReporteAlmacen + "\n");
        } catch (JRException e) {
            e.printStackTrace();
            ErrorDialog.mostrarError("Ocurrió un error ", this);
            
        }
    }
    else {
    ErrorDialog.mostrarError("No se han seleccionado datos validos.", this);
    }            
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:

        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Parametro TipoDoc = null;
        Parametro Estado = null;
        Calendar fechini = dtFechaIni.getSelectedDate();
        Calendar fechfin = dtFechaFin.getSelectedDate();

        if (txt_origen.getText().trim().equals("")) {
            aeropuertoOrigen = null;
        }

        listaEnvios =  CEnvio.BuscarRepoEnviar(
            null,
            aeropuertoOrigen,
            null,
            fechini,
            fechfin,
            null);
        //  }

        llenarGrillaEnvio();

        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btn_origenAeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_origenAeroActionPerformed
        // TODO add your handling code here:
        AeropuertoPopup aeropuertoPU = new AeropuertoPopup(this, true);
        aeropuertoOrigen = aeropuertoPU.showDialog();
        if (aeropuertoOrigen != null) {
            txt_origen.setText(aeropuertoOrigen.getNombre());
        } else {
            txt_origen.setText("");
        }
    }//GEN-LAST:event_btn_origenAeroActionPerformed

    public int BuscarAeropuertoxMes(Envio e){
       
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        int indiceaeropuerto=-1;
        
        for (int s=0; s<listaventas.size();s++){
            Venta v = listaventas.get(s);
            if (v.getAero().getNombre().equals(e.getOrigen().getNombre())){
               
                if (v.getMes()!=null && !v.getMes().equals("") && v.getMes().equals(dateFormat.format(e.getFechaRegistro()))){                    
                    v.setMonto(v.getMonto()+e.getMonto());
                    return 0;
                }
                
                indiceaeropuerto=s;

            }
                    
         }
         if (indiceaeropuerto!=-1){
             Venta venta = new Venta();
             venta.setAero(e.getOrigen());
             venta.setMes(dateFormat.format(e.getFechaRegistro()));
             venta.setMonto(e.getMonto());
             listaventas.add(indiceaeropuerto, venta);
             return 0;
         }
         return -1;
        
    }
    
       public void llenarGrillaEnvio() {
           
           
    
        ArrayList<Aeropuerto> listaaeropuertos= new ArrayList<Aeropuerto>();
           
        if (txt_origen.getText().equals("")) 
            listaaeropuertos = CAeropuerto.GenerarListaAeropuerto2();
        else{
            Aeropuerto aero= CAeropuerto.BuscarNombre(aeropuertoOrigen.getNombre());
            listaaeropuertos.add(aero);
        }
        
        for (int s=0; s<listaaeropuertos.size();s++){
            Venta venta= new Venta();
            venta.setAero(listaaeropuertos.get(s));
            venta.setMes("");
            venta.setMonto(0);
            listaventas.add(venta);
        }
               
        for (Envio e : listaEnvios){
            
            int i=BuscarAeropuertoxMes(e);           
            
        }
        
        for(Venta v :listaventas){
            if (v.getMes()!=""){
                listaventasoficial.add(v);
            }
        }
          
        
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_ventas.getModel();
        int rows = dtm.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            dtm.removeRow(0);
        }

        Object[] datos = new Object[3];

        for (int i = 0; i < listaventasoficial.size(); i++) {


            datos[0] = listaventasoficial.get(i).getAero();
            datos[1] = listaventasoficial.get(i).getMes();
            datos[2] = listaventasoficial.get(i).getMonto();

       

            dtm.addRow(datos);

        }
        
        
        //listaEnviosaux.addAll(listaEnvios);

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
            java.util.logging.Logger.getLogger(ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteVentas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btn_origenAero;
    private datechooser.beans.DateChooserCombo dtFechaFin;
    private datechooser.beans.DateChooserCombo dtFechaIni;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_ventas;
    private javax.swing.JTextField txt_origen;
    // End of variables declaration//GEN-END:variables

   
    
}
