/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.simulacion;

import beans.Parametro;
import controllers.CParametro;
import controllers.CSimulator;
import controllers.CValidator;
import gui.InformationDialog;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
    public SimDialog() {
        initComponents();
        this.setLocationRelativeTo(null);
        listaCargada = false;
    }
    private ArrayList<VueloLite> vInicial;
    private ArrayList<EnvioLite> eInicial;
    private boolean listaCargada;

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

    private void llenarTablaAeroLites(ArrayList<AeroLite> aeropuertos) {
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
        Object[] datos = new Object[4];
        datos[0] = a;
        datos[1] = a.getCapacidadMax();
        datos[2] = a.getCapacidadMax();
        datos[3] = a.getCapacidadActual();
        dtm.addRow(datos);
    }

    private void llenarTablaVueloLites(ArrayList<VueloLite> vuelos) {
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
        Object[] datos = new Object[7];
        datos[0] = v.getNum();
        datos[1] = v.getNum();
        datos[2] = v.getOrigen();
        datos[3] = v.getDestino();
        datos[4] = v.getCapacidadMax();
        datos[5] = v.getCapacidadMax();
        datos[6] = v.getPlleno();
        dtm.addRow(datos);
    }

    private void llenarTablaEnvioLites(List<EnvioLite> envios) {
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
        Object[] datos = new Object[4];
        datos[0] = e.getNum();
        datos[1] = e.getNum();
        datos[2] = e.getOrigen();
        datos[3] = e.getDestino();
        dtm.addRow(datos);
    }

    private void llenarTablas(Date ahora, Date pasado, int num_envios, int num_vuelos) {
        CSimulator csim = new CSimulator();
        ArrayList<AeroLite> aeroLites = csim.calcularAeropuertos(ahora, pasado);
        if (aeroLites != null) {
            llenarTablaAeroLites(aeroLites);
            ArrayList<VueloLite> vueloLites = CSimulator.calcularVuelos(ahora, pasado, num_vuelos, aeroLites);
            llenarTablaVueloLites(vueloLites);
            ArrayList<EnvioLite> envioLites = CSimulator.calcularEnvios(ahora, pasado, num_envios, aeroLites);
            llenarTablaEnvioLites(envioLites);
            this.vInicial = vueloLites;
            this.eInicial = envioLites;
        }
    }

    private int[] desordenar(int num) {
        int[] a = new int[num];
        Random randomizer = new Random();
        int temp, rnd;

        for (int i = 0; i < num; i++) {
            a[i] = i;
        }

        for (int i = 0; i < num; i++) {
            rnd = randomizer.nextInt(num);
            temp = a[rnd];
            a[rnd] = a[i];
            a[i] = temp;
        }

        return a;
    }

    private ArrayList<AeroLite> reconstruirAeroLites(DefaultTableModel dtm) {
        ArrayList<AeroLite> aeroLites = new ArrayList<AeroLite>();

        for (int i = 0; i < dtm.getRowCount(); i++) {
            AeroLite aeroLite = (AeroLite) dtm.getValueAt(i, 0);
            int capacidadActual = (Integer) dtm.getValueAt(i, 1);
            int capacidadMax = (Integer) dtm.getValueAt(i, 2);

            if (aeroLite != null && capacidadActual >= 0 && capacidadMax > 0) {
                aeroLite.setCapacidadActual(capacidadActual);
                aeroLite.setCapacidadMax(capacidadMax);
                aeroLite.setCongestiona(false);
                aeroLite.setNecesidad(0);
                aeroLite.settCongestiona(0);
                aeroLites.add(aeroLite);
            }
        }

        return aeroLites;
    }

    private ArrayList<VueloLite> reconstruirVueloLites(DefaultTableModel dtm) {
        ArrayList<VueloLite> vueloLites = new ArrayList<VueloLite>();
        Random randomizer = new Random();

        int[] a = desordenar(dtm.getRowCount());
        int k = 0;

        for (int i = 0; i < dtm.getRowCount(); i++) {
            int num = (Integer) dtm.getValueAt(i, 0);
            AeroLite origen = (AeroLite) dtm.getValueAt(i, 1);
            AeroLite destino = (AeroLite) dtm.getValueAt(i, 2);
            int capacidadMax = (Integer) dtm.getValueAt(i, 3);
            double alquiler = (Double) dtm.getValueAt(i, 4);
            double plleno = (Double) dtm.getValueAt(i, 5);
            if (origen != null && destino != null && capacidadMax > 0 && alquiler >= 0 && num > 0) {
                for (int j = 0; j < num; j++) {
                    VueloLite v = new VueloLite(origen, destino, j, capacidadMax, alquiler, plleno);
                    v.setEvt(k++);
                    v.setDur(randomizer.nextInt(9));
                    v.setCapacidadActual((int) (plleno * capacidadMax));
                    v.setNecesidad(0);
                    v.setCongestiona(false);
                    vueloLites.add(v);
                    v.getOrigen().getVuelosSalida().add(v);
                    v.getDestino().getVuelosLlegada().add(v);
                }
            }
        }

        return vueloLites;
    }

    private ArrayList<EnvioLite> reconstruirEnvioLites(DefaultTableModel dtm) {
        ArrayList<EnvioLite> envioLites = new ArrayList<EnvioLite>();

        int[] a = desordenar(dtm.getRowCount());
        int k = 0;

        for (int i = 0; i < dtm.getRowCount(); i++) {
            int num = (Integer) dtm.getValueAt(i, 0);
            AeroLite origen = (AeroLite) dtm.getValueAt(i, 1);
            AeroLite destino = (AeroLite) dtm.getValueAt(i, 2);

            if (origen != null && destino != null && num > 0) {
                for (int j = 0; j < num; j++) {
                    EnvioLite v = new EnvioLite(origen, destino, j);
                    v.setEvt(k++);
                    envioLites.add(v);
                }
            }
        }

        return envioLites;
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
        tbl_envios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_aeropuertos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_vuelos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_actualizar = new javax.swing.JButton();
        btn_simular = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dt_inicio = new datechooser.beans.DateChooserCombo();
        dt_fin = new datechooser.beans.DateChooserCombo();
        txt_envios = new javax.swing.JTextField();
        txt_vuelos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FlyTrack - Simulación");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        setMaximumSize(null);
        setMinimumSize(null);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setName("envioDialog"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
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
                .addGap(405, 405, 405)
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
        jLabel5.setText("Envíos");

        tbl_envios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "# Nuevo", "Origen", "Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
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
        tbl_envios.getColumnModel().getColumn(1).setMinWidth(80);
        tbl_envios.getColumnModel().getColumn(1).setPreferredWidth(10);
        tbl_envios.getColumnModel().getColumn(1).setMaxWidth(80);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(190, 190, 190))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                "Nombre", "Max. paq.", "Max. paq. Nuevo", "# paq"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_aeropuertos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(176, 176, 176))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbl_vuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "# Nuevo", "Origen", "Destino", "Max. paq.", "Max. Nuevo", "%"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true, true
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
        tbl_vuelos.getColumnModel().getColumn(1).setMinWidth(80);
        tbl_vuelos.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl_vuelos.getColumnModel().getColumn(1).setMaxWidth(80);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vuelo48x48.png"))); // NOI18N
        jLabel9.setText("Vuelos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(185, 185, 185))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sim_actualizar.png"))); // NOI18N
        btn_actualizar.setText("Recalcular");
        btn_actualizar.setToolTipText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_simular.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btn_simular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sim_simular.png"))); // NOI18N
        btn_simular.setToolTipText("Simular");
        btn_simular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simularActionPerformed(evt);
            }
        });

        btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sim_regresar.png"))); // NOI18N
        btn_regresar.setText("Regresar");
        btn_regresar.setToolTipText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha inicio:");

        jLabel3.setText("Fecha fin:");

        jLabel4.setText("Núm. envíos:");

        jLabel6.setText("Núm. vuelos:");

        dt_inicio.setNothingAllowed(false);
        try {
            dt_inicio.setDefaultPeriods(new datechooser.model.multiple.PeriodSet());
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
            e1.printStackTrace();
        }
        dt_inicio.setLocale(new java.util.Locale("es", "PE", ""));

        dt_fin.setNothingAllowed(false);
        try {
            dt_fin.setDefaultPeriods(new datechooser.model.multiple.PeriodSet());
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
            e1.printStackTrace();
        }
        dt_fin.setEnabled(false);
        dt_fin.setLocale(new java.util.Locale("es", "PE", ""));

        txt_envios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enviosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_vuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dt_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_envios, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_simular)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dt_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_envios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_vuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_simular, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        try {
            Date ahora = dt_fin.getSelectedDate().getTime();
            Date pasado = dt_inicio.getSelectedDate().getTime();
            int num_envios = Integer.parseInt(txt_envios.getText());
            int num_vuelos = Integer.parseInt(txt_vuelos.getText());
            llenarTablas(ahora, pasado, num_envios, num_vuelos);
        } catch (Exception e) {
            InformationDialog.mostrarInformacion("Datos incorrectos", this);
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_simularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simularActionPerformed
        // TODO add your handling code here:

        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        DefaultTableModel dtm = (DefaultTableModel) tbl_aeropuertos.getModel();
        ArrayList<AeroLite> aeroLites = reconstruirAeroLites(dtm);

        dtm = (DefaultTableModel) tbl_vuelos.getModel();
        ArrayList<VueloLite> vueloLites = reconstruirVueloLites(dtm);

        dtm = (DefaultTableModel) tbl_envios.getModel();
        ArrayList<EnvioLite> envioLites = reconstruirEnvioLites(dtm);

        int fallas = CSimulator.simular(envioLites, aeroLites, vueloLites);

        Parametro pUmbral = CParametro.buscarXValorUnicoyTipo("SIM_PARAM", "p_umbral");
        double umbral = Double.parseDouble(pUmbral.getValor());

        String aNecesidad = "";
        String vNecesidad = "";
        String aLleno = "";
        String eLleno = "";

        for (AeroLite a : aeroLites) {
            a.setRojo(false);
            if (a.getNecesidad() > 0) {
                aNecesidad = aNecesidad + "+ El aeropuerto " + a.getNombre() + " congestiona a " + a.getNecesidad() + "envíos.\n";
                a.setRojo(true);
            }
            if (a.gettCongestiona() > 0) {
                double tLleno = a.gettCongestiona() / ((double) envioLites.size());
                aLleno = aLleno + "+ " + a.getNombre() + " - " + CValidator.formatNumber(tLleno * 100) + "% del tiempo.\n";
                a.setRojo(true);
            }
        }

        for (VueloLite vI : this.vInicial) {
            for (VueloLite v : vueloLites) {
                if (v.getOrigen().getId() == vI.getOrigen().getId() && v.getDestino().getId() == vI.getDestino().getId()) {
                    vI.setNecesidad(vI.getNecesidad() + v.getNecesidad());
                }
            }
        }

        for (VueloLite vI : this.vInicial) {
            vI.setRojo(false);
            if (vI.getNecesidad() > 0) {
                vNecesidad = vNecesidad + "+ El vuelo " + vI.getOrigen().getNombre() + " - " + vI.getDestino().getNombre() + " congestiona a " + vI.getNecesidad() + " \n";
                vI.setRojo(true);
            }
        }

        if (!aNecesidad.isEmpty()) {
            aNecesidad = "Congestionamientos detectados: \n" + aNecesidad;
        }
        if (!vNecesidad.isEmpty()) {
            vNecesidad = "Congestionamientos detectados: \n" + vNecesidad;
        }

        if (!aLleno.isEmpty()) {
            aLleno = "Los siguientes aeropuertos están llenos más del " + CValidator.formatNumber(umbral * 100) + "% del tiempo:" + "\n" + aLleno;
        }

        for (EnvioLite e : this.eInicial) {
            e.setCompletados(0);
        }


        for (EnvioLite eI : this.eInicial) {
            for (EnvioLite e : envioLites) {
                if (e.getOrigen().getId() == eI.getOrigen().getId() && e.getDestino().getId() == eI.getDestino().getId() && !e.isCompletado()) {
                    eI.setCompletados(eI.getCompletados() + 1);
                }
            }
        }

        if (fallas > 0) {
            eLleno = "No se concretaron " + fallas + " envíos:\n";

            for (EnvioLite e : eInicial) {
                e.setRojo(false);
                if (e.getCompletados() > 0) {
                    e.setRojo(true);
                    eLleno = eLleno + "+ " + e.getOrigen() + " - " + e.getDestino() + " (" + e.getCompletados() + ")\n";
                }
            }

        }

        String mensaje = aNecesidad + "\n" + vNecesidad + "\n" + aLleno + "\n" + eLleno;

        if (aNecesidad.isEmpty() && vNecesidad.isEmpty() && aLleno.isEmpty() && eLleno.isEmpty()) {
            mensaje = "La distribución de los almacenes y vuelos es correcta.";
        }

        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        InformationDialog.mostrarInformacion(mensaje, this);

        MonitoreoFrame moni = new MonitoreoFrame(aeroLites, this.vInicial, this.eInicial);
        moni.setVisible(true);
    }//GEN-LAST:event_btn_simularActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if (!listaCargada) {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));

            Parametro pDias = CParametro.buscarXValorUnicoyTipo("SIM_PARAM", "dias_historia");
            Parametro pNumEnvios = CParametro.buscarXValorUnicoyTipo("SIM_PARAM", "num_envios");
            Parametro pNumVuelos = CParametro.buscarXValorUnicoyTipo("SIM_PARAM", "num_vuelos");
            int dias_historia = Integer.parseInt(pDias.getValor());
            int num_envios = Integer.parseInt(pNumEnvios.getValor());
            int num_vuelos = Integer.parseInt(pNumVuelos.getValor());

            Calendar cal = Calendar.getInstance();
            dt_fin.setSelectedDate(cal);
            cal.add(Calendar.DATE, -dias_historia);
            dt_inicio.setSelectedDate(cal);

            txt_envios.setText(String.valueOf(num_envios));
            txt_vuelos.setText(String.valueOf(num_vuelos));

            Date ahora = dt_fin.getSelectedDate().getTime();
            Date pasado = dt_inicio.getSelectedDate().getTime();

            llenarTablas(ahora, pasado, num_envios, num_vuelos);

            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            listaCargada = true;
        }
    }//GEN-LAST:event_formWindowActivated

    private void txt_enviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enviosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enviosActionPerformed

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
    private datechooser.beans.DateChooserCombo dt_fin;
    private datechooser.beans.DateChooserCombo dt_inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTextField txt_envios;
    private javax.swing.JTextField txt_vuelos;
    // End of variables declaration//GEN-END:variables
}
