/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.principal;

import beans.Sesion;
import beans.seguridad.Contrasena;
import beans.seguridad.Usuario;
import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import controllers.CContrasena;
import controllers.CSeguridad;
import controllers.CUsuario;
import gui.ErrorDialog;
import gui.InformationDialog;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import org.hibernate.Session;

/**
 *
 * @author msolorzano
 */
public class Login extends javax.swing.JFrame {

    public static String userAnteriorIntentoLogin = "";
    public static int numIntentosFallidos = 0;
    public static int numMaxIntentosFallidos = CSeguridad.getMaxIntentosFallidos();

    /**
     * Creates new form Login
     */
    public Login() {
        try {
            UIManager.setLookAndFeel(new GTKLookAndFeel());
        } catch (Exception e) {
        }
        initComponents();
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("imagenes/logo.png")).getImage());
        setLocationRelativeTo(null);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblOlvidoPass = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FlyTrack - Iniciar Sesión");
        setMaximumSize(new java.awt.Dimension(315, 240));
        setMinimumSize(new java.awt.Dimension(315, 240));
        setPreferredSize(new java.awt.Dimension(315, 240));
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuario");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 30));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña");
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 30));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 30));

        txtUser.setMaximumSize(new java.awt.Dimension(120, 30));
        txtUser.setMinimumSize(new java.awt.Dimension(120, 30));
        txtUser.setPreferredSize(new java.awt.Dimension(120, 30));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/in.png"))); // NOI18N
        btnLogin.setText("Ingresar");
        btnLogin.setMaximumSize(new java.awt.Dimension(120, 30));
        btnLogin.setMinimumSize(new java.awt.Dimension(120, 30));
        btnLogin.setPreferredSize(new java.awt.Dimension(120, 30));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblOlvidoPass.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        lblOlvidoPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOlvidoPass.setText("Olvidé mi contraseña");
        lblOlvidoPass.setMaximumSize(new java.awt.Dimension(150, 20));
        lblOlvidoPass.setMinimumSize(new java.awt.Dimension(150, 20));
        lblOlvidoPass.setName("2"); // NOI18N
        lblOlvidoPass.setPreferredSize(new java.awt.Dimension(150, 20));
        lblOlvidoPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOlvidoPassMouseClicked(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 0, 0));

        txtPass.setMaximumSize(new java.awt.Dimension(120, 30));
        txtPass.setMinimumSize(new java.awt.Dimension(120, 30));
        txtPass.setPreferredSize(new java.awt.Dimension(120, 30));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingrese su usuario y contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOlvidoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(lblOlvidoPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String usuario = txtUser.getText();
        char[] password = txtPass.getPassword();

        if( !usuario.isEmpty()  && password.length > 0 && 
            password != null    && password.length > 0){
            //Verificar si la constrasenia del usuario es la activa o no
            //manejar el numero de intentos fallidos aqui
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            Usuario usuarioValidado = null;
            
            //verificar que el username exista
            //verificar que el username este activo
            //verificar que el username tenga contrasena activa
            //verificar que la contrasena coincida con la contrasena activa
            
            if ((usuarioValidado = CSeguridad.verificarContrasenia(usuario, password)) != null) {
                //VERIFICACION EXITOSA
                lblError.setText("");
                
                //Se debe cambiar la contrasenia en el login cuando:
                //- El primer acceso de la cuenta
                //- La contrasenia ya caduco
                Contrasena contrasenaActiva = CSeguridad.getContrasenaActiva(usuarioValidado.getIdUsuario());
                boolean condicionCaducidad = contrasenaActiva.getFechaCaducidad().before(new Date());
                boolean condicionPrimerIngreso = !usuarioValidado.getPrimerAcceso();

                if(condicionCaducidad || condicionPrimerIngreso){
                    String error = "";
                    if(condicionCaducidad) error += "Su contraseña ha caducado, es necesario cambiarla. \n";
                    if(condicionPrimerIngreso) error += "Es la primera vez que ingresa al sistema, es necesario cambiar su contraseña. \n";
                    InformationDialog.mostrarInformacion(error, this);
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    CambiarContrasenaDialog cambiarContrasenia = new CambiarContrasenaDialog(this, Boolean.TRUE, usuarioValidado, contrasenaActiva);
                    usuarioValidado = cambiarContrasenia.showDialog();
                    if(condicionPrimerIngreso)
                        usuarioValidado = CUsuario.inicializarAccesos(usuarioValidado);//actualizo los accesos de usuario para que no lo vuelva a bloquear

                }
                
                if(usuarioValidado != null){
                    
                    usuarioValidado = CUsuario.incrementarAccesos(usuarioValidado);
                    Contrasena passIngresada = CSeguridad.getContrasenaActiva(usuarioValidado.getIdUsuario());
                    CContrasena.actualizarFechaUltimoUso(passIngresada);
                    Sesion.setUsuario(usuarioValidado);

                    PrincipalFrame pf = new PrincipalFrame();
                    pf.setVisible(Boolean.TRUE);
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

                    this.setVisible(Boolean.FALSE);
                    this.dispose();
                }
            } else {
                //VERIFICACION FALLO
                lblError.setText("Usuario y/o Contraseña Inválidos");
                Usuario usuarioAux = CUsuario.buscarXNombreUsuario(usuario);
                if(usuarioAux != null){// Si el nombre de usuario existe
                    if (usuario.equals(userAnteriorIntentoLogin)) {
                        numIntentosFallidos++;
                    } else {
                        numIntentosFallidos = 1;
                    }
                    userAnteriorIntentoLogin = usuario;
                    //Solo incremento si el usuario que ha intentado logearse es igual al
                    //usuario guardado, si no es asi, intetos fallidos regresa a 1 xD
                    // Si llega al limite de intentos fallidos se bloquea la cuenta
                    if (numIntentosFallidos >= numMaxIntentosFallidos && !usuarioAux.getPerfil().getNombre().equals("Administrador")) {
                        setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        CSeguridad.bloquearCuenta(usuario);
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        ErrorDialog.mostrarError("Usuario: " +usuario + 
                                " Cuenta bloqueada: Supero el numero maximo de intentos fallidos", this);
                    }
                }
            }
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else{
            ErrorDialog.mostrarError("Ingrese Usuario y Contraseña por favor", this);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblOlvidoPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOlvidoPassMouseClicked
        // TODO add your handling code here:
        OlvidoContrasenaDialog fpdialog = new OlvidoContrasenaDialog(this, Boolean.TRUE);
        fpdialog.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_lblOlvidoPassMouseClicked

    protected JRootPane createRootPane() { 
        JRootPane rootPane = new JRootPane();
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
        Action accion = new AbstractAction() { 
          public void actionPerformed(ActionEvent actionEvent) { 
            System.exit(0);
          } 
        } ;
        inputMap.put(stroke, "EXIT");
        rootPane.getActionMap().put("EXIT", accion);
        
        stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        accion = new AbstractAction() { 
          public void actionPerformed(ActionEvent actionEvent) { 
            btnLogin.doClick();
          } 
        } ;
        inputMap.put(stroke, "LOGIN");
        rootPane.getActionMap().put("LOGIN", accion);

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblOlvidoPass;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
