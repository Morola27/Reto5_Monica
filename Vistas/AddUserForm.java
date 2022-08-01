/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import Controlador.ComboboxSucursal;
import Modelo.Conexiones;
import Controlador.EnumTipoDocumento;
import Modelo.Sucursal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class AddUserForm extends javax.swing.JDialog {
                
    Conexiones conexiones = new Conexiones ();
    Connection connection;
    Statement st;
    ResultSet rs;
    ComboBoxModel modeloEnumTipoDocumento;
    ArrayList mListaSucursales;
    ComboboxSucursal instanciaClaseComboboxSucursal;
    
    
    public AddUserForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        modeloEnumTipoDocumento = new DefaultComboBoxModel(EnumTipoDocumento.values());
        initComponents();
        instanciaClaseComboboxSucursal = new ComboboxSucursal();
        mListaSucursales = new ArrayList();
        llenarComboboxSucursales();
        this.setLocationRelativeTo(parent);
        
        
        
    }

  public String llenarComboboxSucursales(){
      mListaSucursales = instanciaClaseComboboxSucursal.getListaSucursales();
      Iterator interator = mListaSucursales.iterator();
      while (interator.hasNext()) {
          Sucursal sucursal = (Sucursal) interator.next();
          cbSucursal.addItem(sucursal);
          
     }

     //System.out.println(mListaSucursales);
      String nombreSucursal = cbSucursal.getSelectedItem().toString();
      //String query = "SLECT idSucursal FROM sucursal WHERE nombreSucursales = '"+nombreSucursal+"';";
      String query =" SELECT idSucursal FROM sucursal WHERE nombreSucursal= '"+nombreSucursal+"';";
      //  System.out.println(query);
      return query;
  }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        cbTipoDocumento = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGrardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbSucursal = new javax.swing.JComboBox<>();
        btnSubirFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel2.setText("FORMULARIO DE REGISTRO");

        jLabel3.setText("Nombre");

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        jLabel4.setText("Apellidos");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de documento ");

        jLabel6.setText("Numero documento");

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        cbTipoDocumento.setModel(modeloEnumTipoDocumento);
        cbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDocumentoActionPerformed(evt);
            }
        });

        jLabel7.setText("Correo");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cancelIcon.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGrardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/confirmIcon.png"))); // NOI18N
        btnGrardar.setText("Guardar");
        btnGrardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrardarActionPerformed(evt);
            }
        });

        jLabel9.setText("Sucursal");

        cbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSucursalActionPerformed(evt);
            }
        });

        btnSubirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/newUser.png"))); // NOI18N
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(108, 108, 108)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnGrardar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addGap(53, 53, 53)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellidos)
                            .addComponent(txtNombre)
                            .addComponent(cbTipoDocumento, 0, 237, Short.MAX_VALUE)
                            .addComponent(txtDocumento)
                            .addComponent(txtCorreo)
                            .addComponent(cbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnSubirFoto)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(btnSubirFoto))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrardar)
                    .addComponent(btnCancelar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoDocumentoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
         this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void btnGrardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrardarActionPerformed
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        // | C.C. | C.E. | Libreta militar | Pasaporte | Otro |
        String tipoDocumento = cbTipoDocumento.getSelectedItem().toString();
        String documento = txtDocumento.getText();
        String correo  = txtCorreo.getText();     
        String queryNombreSucursal = llenarComboboxSucursales();
        System.out.println(queryNombreSucursal);
        
                //Validar que alguno de los campos no este vacío
        if (nombre.isEmpty() || apellidos.isEmpty() || documento.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Faltan campos por diligenciar", "Nuevo empleado",JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                connection = conexiones.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryNombreSucursal);
                while (rs.next()) {
                    int idSucursal = rs.getInt("idSucursal");
                    String queryCrearEmpleado = "INSERT INTO `empleado`(`nombreEmp`, `apellidos`, `tipoDocumento`, `documento`, `correo`, `FK_idSucursal`) VALUES  ('"+nombre+"','"+apellidos+"','"+tipoDocumento+"','"+documento+"','"+correo+"','"+idSucursal+"')";
                    System.out.println(queryCrearEmpleado);
                    System.out.println("Nombre: " + nombre +" "+ apellidos + ", Docuemnto: " + tipoDocumento + " " + documento + ", Correo: " + correo + ", sucursal: "+idSucursal);
                    try {
                        connection = conexiones.getConnection();
                        st = connection.createStatement();
                        st.executeUpdate(queryCrearEmpleado);
                        JOptionPane.showMessageDialog(this, "Registro exitoso", "Nuevo empleado",
                                JOptionPane.INFORMATION_MESSAGE);
                    }catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "No se pudo crear el empleado", "Nuevo empleado",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        this.dispose();
          
             
    
    }//GEN-LAST:event_btnGrardarActionPerformed

    private void cbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSucursalActionPerformed

    private void btnSubirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFotoActionPerformed
       // CargueArchivos cargueFoto = new CargueArchivos(parent, true);
       // cargueFoto.setVisible(true);
    }//GEN-LAST:event_btnSubirFotoActionPerformed

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
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            AddUserForm dialog = new AddUserForm(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGrardar;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JComboBox<Sucursal> cbSucursal;
    private javax.swing.JComboBox<String> cbTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
