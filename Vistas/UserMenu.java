/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mrl98
 */
public class UserMenu extends javax.swing.JFrame {

    Conexiones conexiones = new Conexiones();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados,contenidoTablaDepartamentos;
    ComboBoxModel enumDepartamentos, enumZona, enumTipoCalle;
            
    public UserMenu() {
        enumDepartamentos = new DefaultComboBoxModel(EnumDepartamento.values());
        enumZona = new DefaultComboBoxModel(EnumZona.values());
        enumTipoCalle = new DefaultComboBoxModel(EnumTipoCalle.values());
        initComponents();
        setLocationRelativeTo(null);
        listarEmpeados();
        listarDepartamentos();
    }

    private void listarDepartamentos(){
        String nombreDepartamento = txtDepartamento.getText();
        if (nombreDepartamento.isEmpty()){
          String query = "SELECT nombreSucursal, nombreDepartamento, CONCAT('Zona ',zona, '.-', tipoCalle, ' ', numero1, ' #No.' ,numero2, ' - ', numero3) AS direccion FROM `direccion` INNER JOIN `sucursal` ON idDIRECCION = FK_idDireccion ORDER BY nombreDepartamento;";

        System.out.println("Entro al metodo de listarDepartamentos");
        try {
            connection = conexiones.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Object[] departamento = new Object[3];
            contenidoTablaDepartamentos = (DefaultTableModel) tblDepartamentos.getModel();
            while (rs.next()) {
                departamento[0] = rs.getString("nombreSucursal");
                departamento[1] = rs.getString("nombreDepartamento");
                departamento[2] = rs.getString("direccion");
                //System.out.println("sucursal" + departamento[0] + "departamento" + departamento[1]);
                contenidoTablaDepartamentos.addRow(departamento);
                tblDepartamentos.setModel(contenidoTablaDepartamentos);

            }
        } catch (SQLException e) {
            System.out.println("Error");
        }   
        }else{
          String query = "SELECT nombreSucursal, nombreDepartamento, CONCAT('Zona ',zona, '. ', tipoCalle, ' ', numero1, ' #No.' ,numero2, ' - ', numero3) AS direccion FROM direccion INNER JOIN sucursal ON idDIRECCION = FK_idDireccion AND nombreDepartamento LIKE '%"+nombreDepartamento+"%'ORDER BY nombreDepartamento;"; 
        System.out.println(query);
        try {
            connection = conexiones.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Object[] departamento = new Object[3];
            contenidoTablaDepartamentos = (DefaultTableModel) tblDepartamentos.getModel();
            while (rs.next()) {
                departamento[0] = rs.getString("nombreSucursal");
                departamento[1] = rs.getString("nombreDepartamento");
                departamento[2] = rs.getString("direccion");
                //System.out.println("sucursal" + departamento[0] + "departamento" + departamento[1]);
                contenidoTablaDepartamentos.addRow(departamento);
                tblDepartamentos.setModel(contenidoTablaDepartamentos);

            }
        } catch (SQLException e) {
            System.out.println("Error");
        }  
        }
        
            
       

    }

    
    
    private void borrarDatosTablaDepartamentos() {
        for (int i = 0; i < tblDepartamentos.getRowCount(); i++) {
            contenidoTablaDepartamentos.removeRow(i);
            i -= 1;

        }
    }
    private void listarEmpeados() {
        
        
        String filtroBusqueda = txtSearch.getText();
        if (filtroBusqueda.isEmpty()) {
            String queryConsulta = "SELECT nombreEmp,apellidos,tipoDocumento,documento,correo, nombreSucursal FROM empleado INNER JOIN sucursal WHERE empleado.FK_idSucursal = sucursal.idSucursal AND nombreEmp LIKE '%" + filtroBusqueda + "%' OR apellidos LIKE '%" + filtroBusqueda + "%'";

            try {
                connection = conexiones.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryConsulta);
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmpleado.getModel();
                while (rs.next()) {
                    empleados[0] = rs.getString("nombreEmp");
                    empleados[1] = rs.getString("apellidos");
                    empleados[2] = rs.getString("tipoDocumento");
                    empleados[3] = rs.getString("documento");
                    empleados[4] = rs.getString("correo");
                    empleados[5] = rs.getString("nombreSucursal");
                    contenidoTablaEmpleados.addRow(empleados);
                    tblEmpleado.setModel(contenidoTablaEmpleados);
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        } else {
            String queryConsulta = "SELECT nombreEmp,apellidos,tipoDocumento,documento,correo, nombreSucursal FROM empleado INNER JOIN sucursal WHERE empleado.FK_idSucursal = sucursal.idSucursal AND nombreEmp LIKE '%" + filtroBusqueda + "%' OR apellidos LIKE '%" + filtroBusqueda + "%'";

            
            System.out.println(queryConsulta);
            try {
                connection = conexiones.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryConsulta);
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmpleado.getModel();
                while (rs.next()) {
                    empleados[0] = rs.getString("nombreEmp");
                    empleados[1] = rs.getString("apellidos");
                    empleados[2] = rs.getString("tipoDocumento");
                    empleados[3] = rs.getString("documento");
                    empleados[4] = rs.getString("correo");
                    empleados[5] = rs.getString("nombreSucursal");
                    contenidoTablaEmpleados.addRow(empleados);
                    tblEmpleado.setModel(contenidoTablaEmpleados);
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }

    }

    private void borrarDatosTabla() {
        for (int i = 0; i < tblEmpleado.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            i -= 1;

        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNumero1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbnombreDepartamento = new javax.swing.JComboBox<>();
        txtNumero3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNumero2 = new javax.swing.JTextField();
        cbZona = new javax.swing.JComboBox<>();
        cbCalle = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        txtDepartamento = new javax.swing.JTextField();
        btnSerachDepartamento = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleado = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Zona");

        txtNumero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumero1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo Calle");

        jLabel9.setText("Departamento");

        cbnombreDepartamento.setModel(enumDepartamentos);
        cbnombreDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnombreDepartamentoActionPerformed(evt);
            }
        });

        txtNumero3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumero3ActionPerformed(evt);
            }
        });

        jLabel10.setText("N°");

        jLabel11.setText("-");

        cbZona.setModel(enumZona);
        cbZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZonaActionPerformed(evt);
            }
        });

        cbCalle.setModel(enumTipoCalle);
        cbCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbnombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbnombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tblDepartamentos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sucursal", "Departamento", "Dirección"
            }
        ));
        tblDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblDepartamentosMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblDepartamentos);

        btnSerachDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnSerachDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerachDepartamentoActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/newUser.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSerachDepartamento)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jButton4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSerachDepartamento)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(53, 53, 53)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sucursales ", jPanel6);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 0, 204));
        jLabel1.setText("INFORMACIÓN EMPLEADO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre(s)", "Apellido(s)", "Tipo Documento", "Documento", "Correo", "Sucursal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleado);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/avatar2.png"))); // NOI18N
        btnAddUser.setText("Nuevo");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40))
                    .addComponent(jLabel2))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(798, 798, 798))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarDatosTabla();
        listarEmpeados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // Crear una istancia del dialogo
        AddUserForm addUserF = new AddUserForm(this, true);
        addUserF.setVisible(true);
        borrarDatosTabla();
        listarEmpeados();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadoMouseClicked
        int row = tblEmpleado.getSelectedRow();
        System.out.println("Fila seleccionada N°: " + row);
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Debes de seleccionar un empleado.", "", JOptionPane.WARNING_MESSAGE);
        } else {
           // int idEmp = Integer.parseInt(tblEmpleado.getValueAt(row, 0).toString());
            String nombreEmp = tblEmpleado.getValueAt(row, 0).toString();
            String apellidos = tblEmpleado.getValueAt(row, 1).toString();
            String tipoDocumento = tblEmpleado.getValueAt(row, 2).toString();
            String documento = tblEmpleado.getValueAt(row, 3).toString();
            String correo = tblEmpleado.getValueAt(row, 4).toString();
            String sucursal = tblEmpleado.getValueAt(row, 5).toString();
            System.out.println(", Nombre: " + nombreEmp + " " + apellidos + ", docuemnto: " + tipoDocumento + " " + documento + ", correo: " + correo + "Sucursal: " + sucursal);
            ShowUserForm showUserForm = new ShowUserForm(this, true);
            showUserForm.recibeDatos( nombreEmp, apellidos, tipoDocumento, documento, correo,sucursal);
            showUserForm.setVisible(true);
            borrarDatosTabla();
            listarEmpeados();

        }
    }//GEN-LAST:event_tblEmpleadoMouseClicked

    
    private void txtNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumero1ActionPerformed

    private void txtNumero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumero3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumero3ActionPerformed

    private void cbnombreDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnombreDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbnombreDepartamentoActionPerformed

    private void cbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbZonaActionPerformed

    private void cbCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCalleActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int row = tblDepartamentos.getSelectedRow();
        String sucursal = tblDepartamentos.getValueAt(row, 0).toString();
        String querySucursal = "SELECT idSucursal  FROM `sucursal` WHERE nombreSucursal = '" + sucursal + "';";
        System.out.println(querySucursal);
        try{
            connection = conexiones.getConnection();
            st= connection.createStatement();
            rs = st.executeQuery(querySucursal);
            while (rs.next()){
                int idSucursal = rs.getInt("idSucursal");
                EmpleadoForm empleadoForm = new EmpleadoForm(this, true);
                empleadoForm.setVisible(true);
                empleadoForm.recibeIdSucursal(idSucursal);
            }
        }catch(SQLException e){
            System.out.println(e);
            
        }
       
        System.out.println(querySucursal);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSerachDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerachDepartamentoActionPerformed
             
        this.borrarDatosTablaDepartamentos();
        this.listarDepartamentos();
        
    }//GEN-LAST:event_btnSerachDepartamentoActionPerformed

    private void tblDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentosMouseClicked
      
                
         int row = tblDepartamentos.getSelectedRow();
        if (row > -1) {
            String sucursal = tblDepartamentos.getValueAt(row, 0).toString();
            String departamento = tblDepartamentos.getValueAt(row, 1).toString();
            String query = " SELECT idDireccion  FROM `direccion` INNER JOIN `sucursal`  WHERE  direccion.idDireccion = sucursal.FK_idDireccion AND sucursal.nombreSucursal = '" +sucursal+ "';";
            System.out.println(query);
            try{
                connection = conexiones.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
            while(rs.next()){
                int idDireccion = rs.getInt("idDireccion");
                System.out.println("id capturado: " +idDireccion);
                String quryDireccion = "SELECT zona, nombreDepartamento, tipoCalle,numero1,numero2,numero3 FROM direccion WHERE idDireccion = "+idDireccion+";";
                System.out.println(quryDireccion);
                try {
                    rs = st.executeQuery(quryDireccion);
                    while (rs.next()) {
                        String zona = rs.getString("zona");
                        String tipoCalle = rs.getString("tipoCalle");
                        String numero1 = rs.getString("numero1");
                        String numero2 = rs.getString("numero2");
                        String numero3 = rs.getString("numero3");
                        GestionarSucursalesForm gestionarSucursales = new GestionarSucursalesForm(this, true);
                        gestionarSucursales.recibirDatosSucursal(idDireccion,sucursal,departamento,zona, tipoCalle , numero1,numero2,numero3);
                        //System.out.println(sucursal+" " +departamento+ "" +zona+ " " + tipoCalle + " " + numero1+ "" +numero2+ ""+numero3);
                        gestionarSucursales.setVisible(true);
                }
                }catch(SQLException e){
                   System.out.println(e);     
                }
                 
                }
                          
            }catch(SQLException e) {
                System.out.println(e);  
            }
               
        
    

                    }
        
    }//GEN-LAST:event_tblDepartamentosMouseClicked

    private void tblDepartamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentosMouseEntered
        
    }//GEN-LAST:event_tblDepartamentosMouseEntered

        
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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnSerachDepartamento;
    private javax.swing.JComboBox<String> cbCalle;
    private javax.swing.JComboBox<String> cbZona;
    private javax.swing.JComboBox<String> cbnombreDepartamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTable tblEmpleado;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtNumero3;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
