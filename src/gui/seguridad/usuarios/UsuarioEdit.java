/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.seguridad.usuarios;

import beans.Aeropuerto;
import beans.Cliente;
import beans.Parametro;
import beans.seguridad.Perfil;
import beans.seguridad.Usuario;
import controllers.CUsuario;
import gui.ErrorDialog;
import gui.administracion.aeropuertos.AeropuertoPopup;
import gui.clientes.ClientesPopUp;
import java.util.HashSet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author joao
 */
public class UsuarioEdit extends javax.swing.JDialog {
    CUsuario Usuario = new CUsuario();
    List<Parametro> ListaTipoDoc ;
    List<Parametro> ListaEstado ;
            List<Perfil> ListaPerfiles ;
        Cliente  ClienteAux ;
            Aeropuerto AeropuertoAux;
                boolean isNuevo;
            
    /**
     * Creates new form UsuarioEdit
     */
    Integer idusuario=-1;
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }
    
    Integer bandera=-1;
    public void setBandera(Integer bandera) {
        this.bandera = bandera;
    }

    public Integer getBandera() {
        return bandera;
    }
    
    public UsuarioEdit(javax.swing.JDialog parent, boolean modal,int id) {
        super(parent, modal);
        initComponents();
        idusuario=id;
        isNuevo=true;
         
       // llenarcomboTipoDoc(); 
        llenarcomboEstado();
        llenarcomboPerfiles();
        if (idusuario!=-1){
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAeropuerto = new javax.swing.JTextField();
        btnBuscarAeropuerto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
        cboPerfil = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtLogIn = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnBuscarClientes = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario48x48.png"))); // NOI18N
        jLabel1.setText("Usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Perfil:");

        jLabel3.setText("Aeropuerto:");

        txtAeropuerto.setText("Jorge Chávez, Lima");

        btnBuscarAeropuerto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscarAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAeropuertoActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado:");

        cboPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPerfilActionPerformed(evt);
            }
        });

        jLabel7.setText("LogIn:");

        txtLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogInActionPerformed(evt);
            }
        });

        lblCliente.setText("Cliente:");

        btnBuscarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBuscarAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void cargarcampos(){
    
        Usuario UsuarioBE=Usuario.BuscarXid(idusuario);
        
        isNuevo=false;
        
           txtAeropuerto.setText(UsuarioBE.getIdAeropuerto().getNombre());
           txtLogIn.setText(UsuarioBE.getLogIn());
           txtCliente.setText(UsuarioBE.getIdCliente().getNombres()+" "+UsuarioBE.getIdCliente().getApellidos());
           
           
           for(int i=0;i<cboPerfil.getItemCount();i++){
               Perfil Perfil = (Perfil)cboPerfil.getItemAt(i);
               if (Perfil.getIdPerfil()==UsuarioBE.getPerfil().getIdPerfil())
               {
               cboPerfil.setSelectedIndex(i);
               break;
               
               }
           }
           
           for(int i=0;i<cboEstado.getItemCount();i++){
               Parametro estado = (Parametro)cboEstado.getItemAt(i);
               if (estado.getIdParametro()==UsuarioBE.getEstado().getIdParametro())
               {
               cboEstado.setSelectedIndex(i);
               break;
               
               }
           }

    }
    
    public void llenarcomboEstado(){
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session s = sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            Query q;
            
            q = s.getNamedQuery("ParametrosXTipo");
            q.setParameter("tipo", "ESTADO_USUARIO");
            ListaEstado = q.list();
//                        
            }
        catch(Exception e){
            System.out.println(e.getMessage());
                }
        finally {
            s.close();
        }
        for (int i=0;i<ListaEstado.size();i++)
        {
            Parametro TipoDocBE =(Parametro)ListaEstado.get(i);
            
            cboEstado.addItem(TipoDocBE);
        }
    }
    
    public void llenarcomboPerfiles(){
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session s = sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            Query q;
            
            q = s.getNamedQuery("Perfil");
            ListaPerfiles = q.list();
//                        
            }
        catch(Exception e){
            System.out.println(e.getMessage());
                }
        finally {
            s.close();
        }
        for (int i=0;i<ListaPerfiles.size();i++)
        {
            Perfil  CPerfil  =(Perfil)ListaPerfiles.get(i);
            
            cboPerfil.addItem(CPerfil);
        }
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          // TODO add your handling code here:
        Perfil perfil=(Perfil)cboPerfil.getSelectedItem();

        Aeropuerto nuevoAeropuerto;
        Cliente nuevoCliente;
        
        Cliente auxCliente;
        
        CUsuario Cusuario = new CUsuario();
        Integer valoraux;
        //solo valido  cuando es nuevo, que todos los campos esten llenos, los demas no
        
        
        Usuario UsuarioauxBE=Usuario.BuscarXid(idusuario);
        if (ClienteAux==null && idusuario!=-1){
        auxCliente=UsuarioauxBE.getIdCliente();
        }
        else 
        {auxCliente=ClienteAux;}
        
        
        if (ClienteAux!=null){
        valoraux=auxCliente.getIdCliente();
        }
        else {
        valoraux=0;
        }
        
        
        String error_message = Cusuario.validar(idusuario,valoraux ,isNuevo, txtAeropuerto.getText(), txtCliente.getText(), txtLogIn.getText(), (Parametro)cboEstado.getSelectedItem(),(Perfil)cboPerfil.getSelectedItem());
        
        if (error_message == null || error_message.isEmpty()) {
        
        if (idusuario==-1){
                Usuario.agregarUsuario(perfil, 
                AeropuertoAux,
                //aeropuerto,
                //txtAeropuerto.getText(), 
 //               idcliente, 
                ClienteAux,
                txtLogIn.getText(),
                (Parametro)cboEstado.getSelectedItem() , 
                0,
                false); 
        }
        else{
        txtCliente.setVisible(false);
        //getidusuario()
        Usuario UsuarioBE=Usuario.BuscarXid(idusuario);
        
        if (AeropuertoAux==null){
        nuevoAeropuerto=UsuarioBE.getIdAeropuerto();
        }
        else 
        {nuevoAeropuerto=AeropuertoAux;}
        
        if (ClienteAux==null){
        nuevoCliente=UsuarioBE.getIdCliente();
        }
        else 
        {nuevoCliente=ClienteAux;}
        
        
        Usuario.modificarUsuario(idusuario, 
                perfil, 
                nuevoAeropuerto,
                //AeropuertoAux, 
                nuevoCliente,
                //ClienteAux, 
                txtLogIn.getText(), (Parametro)cboEstado.getSelectedItem());

//                CUsuario.agregarUsuario(
//                        ClienteAux.getIdCliente(),
//                        perfil,
//                        aeropuerto,
//                        ClienteAux
//                        txtPerfil.getText(), 
//                txtAeropuerto.getText(), 
// //               idcliente, 
//                login   txtLogIn.getText(),
//                (Parametro)cboEstado.getSelectedItem());     
            
        }
            this.setVisible(false);
            this.dispose();
        
         } else {
            ErrorDialog.mostrarError(error_message, this);
        }
        
//        CUsuario.agregarUsuario(txtPerfil.getText(), 
//                txtAeropuerto.getText(), 
// //               idcliente, 
//                login   txtLogIn.getText(),
//                (Parametro)cboEstado.getSelectedItem() , 
//                numAcceso,
//                primerAcceso); 
   
        //el idcliente puede salir de la tabla clientes, ahi usaria nombres, apellidos, tipodoc,numdoc y sacaria el idcliente
            
        //select idCliente from Cliente where Nombres nombres and Apellidos apellidos and TipoDoc tipodoc and NumDodc numdoc 
        
//(Parametro)cboTipoDoc.getSelectedItem()

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible (false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogInActionPerformed

    private void btnBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClientesActionPerformed
        // TODO add your handling code here:
        ClientesPopUp usuarioClientesPopUp = new ClientesPopUp(this,true);
        usuarioClientesPopUp.setVisible(true);
        ClienteAux=usuarioClientesPopUp.showDialog();
       txtCliente.setText(ClienteAux.getNombres()+" "+ClienteAux.getApellidos());
    }//GEN-LAST:event_btnBuscarClientesActionPerformed

    private void btnBuscarAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAeropuertoActionPerformed
        // TODO add your handling code here:
        AeropuertoPopup usuarioAeropuertoPopUp = new AeropuertoPopup(this,true); 
        usuarioAeropuertoPopUp.setVisible(true);
         AeropuertoAux=usuarioAeropuertoPopUp.showDialog();
         txtAeropuerto.setText(AeropuertoAux.getNombre());
    }//GEN-LAST:event_btnBuscarAeropuertoActionPerformed

    private void cboPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPerfilActionPerformed
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
            java.util.logging.Logger.getLogger(UsuarioEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsuarioEdit dialog = new UsuarioEdit(new javax.swing.JDialog(), true,-1);
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
    private javax.swing.JButton btnBuscarAeropuerto;
    private javax.swing.JButton btnBuscarClientes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JComboBox cboPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JTextField txtAeropuerto;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtLogIn;
    // End of variables declaration//GEN-END:variables
}
