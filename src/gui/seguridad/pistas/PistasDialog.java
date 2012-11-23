/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.seguridad.pistas;

import beans.*;
import beans.seguridad.*;
import controllers.CParametro;
import controllers.CPista;
import controllers.CValidator;
import gui.ErrorDialog;
import gui.reportes.IncidenciaDataSource;
import gui.reportes.PistasDataSource;
import gui.seguridad.usuarios.UsuarioPopup;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
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
 * @author msolorzano
 */
public class PistasDialog extends javax.swing.JDialog {

    Usuario usuarioBuscado = null;
    ArrayList<Pista> listaPistas;
    
    
    /**
     * Creates new form PistasDialog
     */
    public PistasDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public PistasDialog(){
        initComponents();
        llenarComboAccion();
        setLocationRelativeTo(null);
    }
    
    private void llenarComboAccion(){
        for(Parametro param : CParametro.buscar(null, null, "ACCION_LOG", null)){
            cmbAccion.addItem(param);
        }
    }
    
    private void llenarTabla(List<Pista> pistas){
        DefaultTableModel dtm = (DefaultTableModel) this.tblPistas.getModel();
        int rows = dtm.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            dtm.removeRow(0);
        }
        Object[] datos = new Object[7];
        for (int i = 0; i < pistas.size(); i++) {

            datos[0] = i;
            datos[1] = pistas.get(i).getUsuario();
            datos[2] = pistas.get(i).getModuloPrincipal();
            datos[3] = pistas.get(i).getModuloSecundario();
            datos[4] = pistas.get(i).getAccion();
            datos[5] = pistas.get(i).getFecha().toString();//imprimir fecha con un formato en especial
            datos[6] = pistas.get(i).getMensaje();

            dtm.addRow(datos);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPistas = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblFechaIni = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnBuscarUsuario = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblFechaFin = new javax.swing.JLabel();
        dtcFechaIni = new datechooser.beans.DateChooserCombo();
        dtcFechaFin = new datechooser.beans.DateChooserCombo();
        lblUsuario1 = new javax.swing.JLabel();
        cmbAccion = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flytrack - Seguridad - Logs de Auditoría");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/report.jpeg"))); // NOI18N
        jLabel1.setText("Logs de Auditoría");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# de Pista", "Usuario", "Modulo Principal", "Modulo Secundario", "Accion", "Fecha", "Mensaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPistas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPistas);
        tblPistas.getColumnModel().getColumn(0).setResizable(false);
        tblPistas.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblPistas.getColumnModel().getColumn(1).setResizable(false);
        tblPistas.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblPistas.getColumnModel().getColumn(2).setResizable(false);
        tblPistas.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblPistas.getColumnModel().getColumn(3).setResizable(false);
        tblPistas.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblPistas.getColumnModel().getColumn(4).setResizable(false);
        tblPistas.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblPistas.getColumnModel().getColumn(5).setResizable(false);
        tblPistas.getColumnModel().getColumn(5).setPreferredWidth(30);
        tblPistas.getColumnModel().getColumn(6).setResizable(false);

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblUsuario.setText("Usuario:");

        lblFechaIni.setText("Fecha Inicial:");

        txtUsuario.setEnabled(false);

        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnRegresar.setText("Regresar");

        lblFechaFin.setText("Fecha Final:");

        dtcFechaIni.setNothingAllowed(false);
        try {
            dtcFechaIni.setDefaultPeriods(new datechooser.model.multiple.PeriodSet());
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
            e1.printStackTrace();
        }
        dtcFechaIni.setLocale(new java.util.Locale("es", "PE", ""));

        dtcFechaFin.setNothingAllowed(false);
        try {
            dtcFechaFin.setDefaultPeriods(new datechooser.model.multiple.PeriodSet());
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
            e1.printStackTrace();
        }
        dtcFechaFin.setLocale(new java.util.Locale("es", "PE", ""));

        lblUsuario1.setText("Acción:");

        cmbAccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtcFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        listaPistas = new ArrayList<Pista>();

        String accion;
        if(cmbAccion.getSelectedIndex() != 0){
            accion = ((Parametro)cmbAccion.getSelectedItem()).getValor();
        }
        else{
            accion = null;
        }
        
        Calendar fechaIni = dtcFechaIni.getSelectedDate();
        Calendar fechaFin = dtcFechaFin.getSelectedDate();

        if(fechaIni != null && fechaFin != null){
            if(fechaIni.before(fechaFin)){
                List<Pista> pistas = CPista.obtenerPistas(txtUsuario.getText(), accion, fechaIni, fechaFin);
                llenarTabla(pistas);
                listaPistas.addAll(pistas);
            }
            else{
                ErrorDialog.mostrarError("La fecha inicial debe ser antes de la fecha final", this);
            }
        }
        else{
            List<Pista> pistas = CPista.obtenerPistas(txtUsuario.getText(), accion, fechaIni, fechaFin);
            llenarTabla(pistas);
            listaPistas.addAll(pistas);
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//        CPista.guardarPista("Pistas", "Buscar", "PistasDialog", "btnBuscarActionPerformed", null, null,"Ha realizado una búsqueda de las pistas");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        // TODO add your handling code here:
        UsuarioPopup usuarioPP = new UsuarioPopup();
        usuarioPP.setModal(true);
        usuarioBuscado = usuarioPP.showDialog();
        if(usuarioBuscado != null){
            txtUsuario.setText(usuarioBuscado.getLogIn());
        }
        else{
            txtUsuario.setText("");
        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
    PistasDataSource pistads = new PistasDataSource();
    pistads.setListaPistas(listaPistas);
    
    if (pistads!=null){
        try {
            //JasperReport reporte = JasperCompileManager.compileReport("NetBeansProjects/FlyTrack/src/gui/reportes/ReporteAlmacen.jrxml");
            String master = System.getProperty("user.dir") +
                                "/src/gui/reportes/ReporteLogsPistas.jasper";
            
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
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, pistads);
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH_mm");
            Date fechaactual = Calendar.getInstance().getTime(); 
            String reportDate = df.format(fechaactual);
            String nombreReporteLogs = "Reporte de Logs" +reportDate+ ".pdf";
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

    protected JRootPane createRootPane() { 
        JRootPane rootPane = new JRootPane();
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
        Action accion = new AbstractAction() { 
          public void actionPerformed(ActionEvent actionEvent) { 
              setVisible(false);
              dispose();
          } 
        } ;
        inputMap.put(stroke, "EXIT");
        rootPane.getActionMap().put("EXIT", accion);
        
        stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        accion = new AbstractAction() { 
          public void actionPerformed(ActionEvent actionEvent) { 
            btnBuscar.doClick();
          } 
        } ;
        inputMap.put(stroke, "BUSCAR");
        rootPane.getActionMap().put("BUSCAR", accion);

        return rootPane;
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
            java.util.logging.Logger.getLogger(PistasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PistasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PistasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PistasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PistasDialog dialog = new PistasDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox cmbAccion;
    private datechooser.beans.DateChooserCombo dtcFechaFin;
    private datechooser.beans.DateChooserCombo dtcFechaIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaIni;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JTable tblPistas;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
