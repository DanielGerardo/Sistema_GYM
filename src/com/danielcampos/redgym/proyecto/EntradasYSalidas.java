/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;


import static com.danielcampos.redgym.proyecto.Menu.IconControl;
import static com.danielcampos.redgym.proyecto.Menu.IconIngreso;
import static com.danielcampos.redgym.proyecto.Menu.Menu1;
import static com.danielcampos.redgym.proyecto.Menu.PanelIngreso;
import static com.danielcampos.redgym.proyecto.PlanesClientes.fechaActual;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.danielcampos.redgym.proyecto.Menu.PanelGuardar;
import static com.danielcampos.redgym.proyecto.Menu.IconGuardar;
import static com.danielcampos.redgym.proyecto.Menu.PanelControl;

/**
 *
 * @author Daniel Gerardo Campos García
 Class JInternalFrame EntradasYSalidas. Se crear para visualizar las entradas de los Clientes y a la hora que salen por si llega a ver un robo de un articulo saber quienes estaban a esa hora
 Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 * 
 * 
 */
public class EntradasYSalidas extends javax.swing.JInternalFrame implements MetodosGraficar{

    public static String fechaActual(){
Date fecha = new Date();
DateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
return formatofecha.format(fecha);

}
     DefaultTableModel model;
    public EntradasYSalidas() {
        
        initComponents();
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        
    }
        
        
   
       void centrarVentana(JInternalFrame frame){
        
        Menu1.add(frame);
        Dimension dimension=Menu1.getSize();
        Dimension Dframe=frame.getSize();
        frame.setLocation((dimension.width-Dframe.width)/2,(dimension.height-Dframe.height));
        frame.show();
        
    }  
    void cargarTablaEntradasYSalidas(){
        java.sql.Date fechaInicio = MetodosGraficar.getFecha(fechaInicial);        
        java.sql.Date fechafin = MetodosGraficar.getFecha(fechaFinal);
        Color myColor = new Color(255,255,255);
        
        tablaEntradasYSalidas.setBackground(myColor);
        tablaEntradasYSalidas.getTableHeader().setBackground(new Color(0,102,204));
        tablaEntradasYSalidas.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 14));
        tablaEntradasYSalidas.getTableHeader().setForeground(new Color(255,255,255));
        tablaEntradasYSalidas.getTableHeader().setOpaque(false);
        tablaEntradasYSalidas.getTableHeader().setEnabled(false);
       String[] titulos = {"User","Nombre","Entrada","Salida","Fecha"};
        
        model = new DefaultTableModel(null, titulos);
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colu;
        try {
             ps = cn.prepareStatement("SELECT UserName,nombre,horaEntrada,horaSalida,fechahoy FROM Entradas WHERE fechahoy BETWEEN '" + fechaInicio + "' and '" + fechafin + "'");
            
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            colu = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[colu];
                for(int indice=0; indice<colu; indice++){
                fila[indice] = rs.getString(indice + 1); 
                }
                model.addRow(fila);
            }
            tablaEntradasYSalidas.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        foto = new JPanelWebCam.JPanelWebCam();
        txtDire = new javax.swing.JTextField();
        txtTelA = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fechaInicial = new com.toedter.calendar.JDateChooser();
        cerrar = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnVen = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnVen1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEntradasYSalidas = new javax.swing.JTable();
        fechaFinal = new com.toedter.calendar.JDateChooser();
        btnGraficar = new javax.swing.JPanel();
        txtGraficar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(751, 582));

        foto.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout fotoLayout = new javax.swing.GroupLayout(foto);
        foto.setLayout(fotoLayout);
        fotoLayout.setHorizontalGroup(
            fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        fotoLayout.setVerticalGroup(
            fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        txtDire.setEditable(false);
        txtDire.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtDire.setForeground(new java.awt.Color(51, 153, 255));
        txtDire.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDire.setBorder(null);
        txtDire.setOpaque(false);

        txtTelA.setEditable(false);
        txtTelA.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtTelA.setForeground(new java.awt.Color(51, 153, 255));
        txtTelA.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelA.setBorder(null);
        txtTelA.setOpaque(false);

        txtTel.setEditable(false);
        txtTel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtTel.setForeground(new java.awt.Color(51, 153, 255));
        txtTel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTel.setBorder(null);
        txtTel.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Tel.Adicional:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Telefono:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Direccion:");

        fechaInicial.setBackground(new java.awt.Color(255, 255, 255));
        fechaInicial.setForeground(new java.awt.Color(255, 255, 255));
        fechaInicial.setDateFormatString("yyyy-MM-dd");
        fechaInicial.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        fechaInicial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaInicialMouseClicked(evt);
            }
        });

        cerrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setText("X");
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarMouseExited(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(102, 204, 255));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Buscar");

        javax.swing.GroupLayout btnBuscarLayout = new javax.swing.GroupLayout(btnBuscar);
        btnBuscar.setLayout(btnBuscarLayout);
        btnBuscarLayout.setHorizontalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBuscarLayout.setVerticalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Entradas y Salidas");

        btnVen.setBackground(new java.awt.Color(255, 255, 255));
        btnVen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVenMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<");

        javax.swing.GroupLayout btnVenLayout = new javax.swing.GroupLayout(btnVen);
        btnVen.setLayout(btnVenLayout);
        btnVenLayout.setHorizontalGroup(
            btnVenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVenLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );
        btnVenLayout.setVerticalGroup(
            btnVenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btnVen1.setBackground(new java.awt.Color(255, 255, 255));
        btnVen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVen1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVen1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVen1MouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(">");

        javax.swing.GroupLayout btnVen1Layout = new javax.swing.GroupLayout(btnVen1);
        btnVen1.setLayout(btnVen1Layout);
        btnVen1Layout.setHorizontalGroup(
            btnVen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVen1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );
        btnVen1Layout.setVerticalGroup(
            btnVen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        tablaEntradasYSalidas.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        tablaEntradasYSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaEntradasYSalidas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaEntradasYSalidas.setOpaque(false);
        tablaEntradasYSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEntradasYSalidasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaEntradasYSalidas);

        fechaFinal.setBackground(new java.awt.Color(255, 255, 255));
        fechaFinal.setForeground(new java.awt.Color(255, 255, 255));
        fechaFinal.setDateFormatString("yyyy-MM-dd");
        fechaFinal.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        fechaFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaFinalMouseClicked(evt);
            }
        });

        btnGraficar.setBackground(new java.awt.Color(102, 204, 255));
        btnGraficar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGraficarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGraficarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGraficarMouseExited(evt);
            }
        });

        txtGraficar.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtGraficar.setForeground(new java.awt.Color(255, 255, 255));
        txtGraficar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGraficar.setText("Graficar");

        javax.swing.GroupLayout btnGraficarLayout = new javax.swing.GroupLayout(btnGraficar);
        btnGraficar.setLayout(btnGraficarLayout);
        btnGraficarLayout.setHorizontalGroup(
            btnGraficarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGraficarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtGraficar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnGraficarLayout.setVerticalGroup(
            btnGraficarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtGraficar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDire, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cerrar)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDire, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaInicialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaInicialMouseClicked
        
    }//GEN-LAST:event_fechaInicialMouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        dispose();
        Color cl= new Color(0,117,155);
     PanelControl.setBackground(cl);
     
     IconControl.setIcon(null);
     PanelControl.setEnabled(true);
    }//GEN-LAST:event_cerrarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
       cargarTablaEntradasYSalidas();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
       btnBuscar.setBackground(new java.awt.Color(0,102,204));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
       btnBuscar.setBackground(new java.awt.Color(102, 204, 255));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnVenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenMouseClicked
         dispose();
       Vencimiento cn=new Vencimiento();
       centrarVentana(cn);
    }//GEN-LAST:event_btnVenMouseClicked

    private void btnVen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVen1MouseClicked
         dispose();
       Imprimir cn=new Imprimir();
       centrarVentana(cn);
    }//GEN-LAST:event_btnVen1MouseClicked

    private void tablaEntradasYSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEntradasYSalidasMouseClicked
        try {
            int fila = tablaEntradasYSalidas.getSelectedRow();
            int id = Integer.parseInt(tablaEntradasYSalidas.getValueAt(fila, 0).toString());

            Conexion cc = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection cn = cc.Conexion();

            ps = cn.prepareStatement("SELECT Direccion,Telefono,Tel_Adicional,Fotografia FROM Clientes WHERE UserName=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                txtDire.setText(rs.getString("Direccion"));
                txtTel.setText(rs.getString("Telefono"));
                txtTelA.setText(rs.getString("Tel_Adicional"));
                byte[] imagen = rs.getBytes("Fotografia");
                foto.setImagen(imagen);
                
            }
            if(txtDire.getText().length()>=32){
                 txtDire.setEditable(true);
                }else{
                txtDire.setEditable(false);
                }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());

        }
    }//GEN-LAST:event_tablaEntradasYSalidasMouseClicked

    private void btnVen1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVen1MouseEntered
      btnVen1.setBackground(new Color(0,102,204));
      
    }//GEN-LAST:event_btnVen1MouseEntered

    private void btnVen1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVen1MouseExited
      btnVen1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnVen1MouseExited

    private void btnVenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenMouseEntered
        btnVen.setBackground(new Color(0,102,204));
    }//GEN-LAST:event_btnVenMouseEntered

    private void btnVenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenMouseExited
        btnVen.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnVenMouseExited

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered
       cerrar.setForeground(Color.RED);
    }//GEN-LAST:event_cerrarMouseEntered

    private void cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseExited
        cerrar.setForeground(Color.BLACK);
    }//GEN-LAST:event_cerrarMouseExited

    private void fechaFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaFinalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFinalMouseClicked

    private void btnGraficarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficarMouseClicked
        java.sql.Date fechaInicio = MetodosGraficar.getFecha(fechaInicial);        
        java.sql.Date fechafin = MetodosGraficar.getFecha(fechaFinal);
        MetodosGraficar.graficaBarrasEntrasYSalidas(fechaInicio, fechafin);
    }//GEN-LAST:event_btnGraficarMouseClicked

    private void btnGraficarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficarMouseEntered
        btnGraficar.setBackground(new java.awt.Color(0,102,204));
    }//GEN-LAST:event_btnGraficarMouseEntered

    private void btnGraficarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficarMouseExited
        btnGraficar.setBackground(new java.awt.Color(102, 204, 255));
    }//GEN-LAST:event_btnGraficarMouseExited

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBuscar;
    private javax.swing.JPanel btnGraficar;
    private javax.swing.JPanel btnVen;
    private javax.swing.JPanel btnVen1;
    private javax.swing.JLabel cerrar;
    private com.toedter.calendar.JDateChooser fechaFinal;
    private com.toedter.calendar.JDateChooser fechaInicial;
    private JPanelWebCam.JPanelWebCam foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEntradasYSalidas;
    private javax.swing.JTextField txtDire;
    private javax.swing.JLabel txtGraficar;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTelA;
    // End of variables declaration//GEN-END:variables

  
}
