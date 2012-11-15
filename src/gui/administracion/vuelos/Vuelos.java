/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.administracion.vuelos;

import beans.Aeropuerto;
import beans.Parametro;
import beans.Sesion;
import beans.Vuelo;
import beans.seguridad.Permiso;
import controllers.CSeguridad;
import controllers.CVuelo;
import gui.administracion.aeropuertos.AeropuertoPopup;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author jorge
 */
public class Vuelos extends javax.swing.JDialog {

    private Aeropuerto aeropuertoDestino =null;
    private Aeropuerto aeropuertoOrigen =null;
    private List<Parametro> ListatipoEst;
    // private List<Vuelo> listaVuelos;
    private List<Vuelo> listaVuelos = null;
    private Calendar fechini, fechfin;
    private Parametro a_origen, a_destino;

    /**
     * Creates new form Vuelos
     */
    public Vuelos() {
        initComponents();
        llenarComboEstado();
        this.setLocationRelativeTo(null); 
        definirPermisos();
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
        txt_origen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_origenAero = new javax.swing.JButton();
        btn_origenDest = new javax.swing.JButton();
        txt_destino = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbm_estado = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        dt_fechini = new datechooser.beans.DateChooserCombo();
        dt_fechfin = new datechooser.beans.DateChooserCombo();
        btn_regresar2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_vuelos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnIncidencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FlyTrack - Administración - Vuelos");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vuelo48x48.png"))); // NOI18N
        jLabel1.setText("Vuelos");
        jLabel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
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

        txt_origen.setToolTipText("");
        txt_origen.setEnabled(false);
        txt_origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_origenActionPerformed(evt);
            }
        });

        jLabel2.setText("Origen:");

        btn_origenAero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btn_origenAero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_origenAeroActionPerformed(evt);
            }
        });

        btn_origenDest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btn_origenDest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_origenDestActionPerformed(evt);
            }
        });

        txt_destino.setEnabled(false);
        txt_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_destinoActionPerformed(evt);
            }
        });

        jLabel3.setText("Destino:");

        jLabel4.setText("Estado:");

        jLabel5.setText("Fecha Final:");

        cbm_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbm_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbm_estadoActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha Inicial:");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        try {
            dt_fechini.setDefaultPeriods(new datechooser.model.multiple.PeriodSet());
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
            e1.printStackTrace();
        }
        dt_fechini.setLocale(new java.util.Locale("es", "PE", ""));

        dt_fechfin.setNothingAllowed(false);
        try {
            dt_fechfin.setDefaultPeriods(new datechooser.model.multiple.PeriodSet());
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
            e1.printStackTrace();
        }
        dt_fechfin.setLocale(new java.util.Locale("es", "PE", ""));

        btn_regresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btn_regresar2.setText("Regresar");
        btn_regresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbm_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_origen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btn_origenDest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btn_origenAero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_regresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dt_fechini, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt_fechfin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_origenAero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_origen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt_fechfin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_origenDest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt_fechini, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbm_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_regresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jScrollPane1.setToolTipText("");
        jScrollPane1.setAutoscrolls(true);

        tbl_vuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Origen", "Destino", "Fecha salida", "Fecha llegada", "Estado", "Capacidad", "Alquiler"
            }
        ));
        tbl_vuelos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_vuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_vuelosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_vuelos);
        tbl_vuelos.getColumnModel().getColumn(0).setPreferredWidth(65);
        tbl_vuelos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_vuelos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_vuelos.getColumnModel().getColumn(3).setPreferredWidth(112);
        tbl_vuelos.getColumnModel().getColumn(4).setPreferredWidth(112);
        tbl_vuelos.getColumnModel().getColumn(6).setPreferredWidth(80);
        tbl_vuelos.getColumnModel().getColumn(7).setPreferredWidth(75);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/xml.png"))); // NOI18N
        jButton1.setText("Carga Masiva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnIncidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        btnIncidencia.setText("Incidencia");
        btnIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncidenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarComboEstado() {
        ListatipoEst = CVuelo.llenarComboEstado();
        for (int i = 0; i < ListatipoEst.size(); i++) {
            Parametro TipoDocBE = (Parametro) ListatipoEst.get(i);
            cbm_estado.addItem(TipoDocBE);
        }
    }

    public void buscar() {
    }

    public void llenarGrillaVuelo() {
        Parametro TipoDoc;
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_vuelos.getModel();
        int rows = dtm.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            dtm.removeRow(0);
        }

       Object[] datos = new Object[8];



        for (int i = 0; i < listaVuelos.size(); i++) {

            datos[0] = listaVuelos.get(i).getIdVuelo();
            datos[1] = listaVuelos.get(i).getOrigen().getNombre();
            datos[2] = listaVuelos.get(i).getDestino().getNombre();
            datos[3] = listaVuelos.get(i).getFechaSalida();
            datos[4] = listaVuelos.get(i).getFechaLlegada();
            datos[5] = listaVuelos.get(i).getEstado().getValor();
            datos[6] = String.valueOf(listaVuelos.get(i).getCapacidadMax());
            datos[7] = String.valueOf(listaVuelos.get(i).getAlquiler());

            dtm.addRow(datos);

        }

    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        VuelosAgregar vVuelAgre = null;

        Parametro TipoDoc=null;
        if (cbm_estado.getSelectedIndex()>0) {
           TipoDoc = (Parametro)cbm_estado.getSelectedItem();
        }      
        
        vVuelAgre = new VuelosAgregar(this, true, null, 1);
    
        fechini = dt_fechini.getSelectedDate();
        fechfin = dt_fechfin.getSelectedDate();
        
        listaVuelos = CVuelo.BuscarVuelo(aeropuertoOrigen, aeropuertoDestino, fechini, fechfin, TipoDoc);
        vVuelAgre.setVisible(true);
        vVuelAgre.setModal(true);
        this.setEnabled(true);
        this.setVisible(true);
        //listaVuelos = CVuelo.BuscarVuelo(null, null, null, null, null);
        llenarGrillaVuelo();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        VuelosCarga DialogoCarga = new VuelosCarga(this, true);
        DialogoCarga.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_vuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_vuelosMouseClicked
        // TODO add your handling code here:
        
     
    }//GEN-LAST:event_tbl_vuelosMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:

        Parametro TipoDoc = null;
        fechini = dt_fechini.getSelectedDate();
        fechfin = dt_fechfin.getSelectedDate();
      
        if (cbm_estado.getSelectedIndex()>0) {
            TipoDoc = (Parametro)cbm_estado.getSelectedItem();
             listaVuelos = CVuelo.BuscarVuelo(aeropuertoOrigen, aeropuertoDestino, fechini, fechfin,TipoDoc);   
          }
        else
        {
            listaVuelos = CVuelo.BuscarVuelo(aeropuertoOrigen, aeropuertoDestino, fechini, fechfin,null );
        }
        
        
        llenarGrillaVuelo();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void cbm_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbm_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbm_estadoActionPerformed

    private void txt_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_destinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_destinoActionPerformed

    private void btn_origenDestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_origenDestActionPerformed
        // TODO add your handling code here:
        AeropuertoPopup aeropuertoPU = new AeropuertoPopup(this, true);
        aeropuertoDestino = aeropuertoPU.showDialog();
        if (aeropuertoDestino != null) {
            txt_destino.setText(aeropuertoDestino.getNombre());

        }
    }//GEN-LAST:event_btn_origenDestActionPerformed

    private void btn_origenAeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_origenAeroActionPerformed
        // TODO add your handling code here:
        AeropuertoPopup aeropuertoPU = new AeropuertoPopup(this, true);
        aeropuertoOrigen = aeropuertoPU.showDialog();
        if (aeropuertoOrigen != null) {
            txt_origen.setText(aeropuertoOrigen.getNombre());

        }
    }//GEN-LAST:event_btn_origenAeroActionPerformed

    private void txt_origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_origenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_origenActionPerformed

    private void btn_regresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresar2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_regresar2ActionPerformed

    private void btnIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncidenciaActionPerformed
        // TODO add your handling code here:
       
//         if (objV.getEstado().getValorUnico().compareTo("FIN")== 0){
//            bandera = false;
//        }
//            
//        if (objV.getEstado().getValorUnico().compareTo("CAN")== 0){
//           bandera = false;
//        }

    // if tbl_vuelos.   
       if (tbl_vuelos.getSelectedRow()>-1) {
        Incidencias DialogoInc = new Incidencias(this, true, listaVuelos.get(tbl_vuelos.getSelectedRow()));
        DialogoInc.setVisible(true);
        Parametro TipoDoc;
         fechini = dt_fechini.getSelectedDate();
         fechfin = dt_fechfin.getSelectedDate();
     
       if (cbm_estado.getSelectedIndex()>0) {
          TipoDoc = (Parametro)cbm_estado.getSelectedItem();
          listaVuelos = CVuelo.BuscarVuelo(aeropuertoOrigen, aeropuertoDestino, fechini, fechfin, TipoDoc);
  
        }else {
         listaVuelos = CVuelo.BuscarVuelo(aeropuertoOrigen, aeropuertoDestino, fechini, fechfin,null);
        }

        llenarGrillaVuelo();
       }else{
        JOptionPane.showMessageDialog(this,"Debe seleccionar un Vuelo", "Advertencia", 1);
       }
    }//GEN-LAST:event_btnIncidenciaActionPerformed

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
            java.util.logging.Logger.getLogger(Vuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vuelos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnIncidencia;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_origenAero;
    private javax.swing.JButton btn_origenDest;
    private javax.swing.JButton btn_regresar2;
    private javax.swing.JComboBox cbm_estado;
    private datechooser.beans.DateChooserCombo dt_fechfin;
    private datechooser.beans.DateChooserCombo dt_fechini;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_vuelos;
    private javax.swing.JTextField txt_destino;
    private javax.swing.JTextField txt_origen;
    // End of variables declaration//GEN-END:variables

    private void definirPermisos() {
        List<Permiso> permisos = Sesion.getUsuario().getPerfil().getPermisos();
        boolean crear = CSeguridad.validarPermiso(3, "Vuelos", "Crear", permisos);
        this.btnAgregar.setEnabled(crear);
        boolean modificar = CSeguridad.validarPermiso(3, "Vuelos", "Modificar", permisos);
        this.btnIncidencia.setEnabled(modificar);
        boolean buscar = CSeguridad.validarPermiso(3, "Vuelos", "Buscar/Listar", permisos);
        this.btn_buscar.setEnabled(buscar);
//        boolean cargaMasiva = CSeguridad.validarPermiso(3, "Vuelos", "Carga Masiva", permisos);
//        this.btnCargaMasiva.setEnabled(cargaMasiva);

        this.setLocationRelativeTo(null);
        pack();
    }
}
