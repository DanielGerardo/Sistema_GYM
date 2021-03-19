/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Gerardo Campos García
 * Class Historial se crea para visualizar las Entradas y Salidas de todos los productos
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 * Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 * 
 * 
 */
public class Historial extends javax.swing.JFrame {

    /**
     * Creates new form Historial
     */
    DefaultTableModel model;

    public Historial() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/pesa.png")).getImage()); 
        this.setLocationRelativeTo(null);
        cargarTablaHistorial("");
        tablaHistorial.setDefaultRenderer(Object.class, new FormatoTbHistorial());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
    }

    void cargarTablaHistorial(String valor) {
        Color myColor = new Color(255, 255, 208);
        tablaHistorial.setBackground(myColor);
        tablaHistorial.getTableHeader().setBackground(myColor);
        tablaHistorial.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 14));
        tablaHistorial.getTableHeader().setForeground(Color.black);
        tablaHistorial.getTableHeader().setOpaque(false);
        String[] titulos = {"Movimiento", "Fecha", "Unidad", "ID.Producto", "Descripcion", "Cantidad"};
        String[] registros = new String[6];
        model = new DefaultTableModel(null, titulos);
        String sql = "SELECT * FROM historial";

        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("movimiento");
                registros[1] = rs.getString("fecha");
                registros[2] = rs.getString("id_producto");
                registros[3] = rs.getString("descripcion");
                registros[4] = rs.getString("unidad");
                registros[5] = rs.getString("cantidad");
                model.addRow(registros);
            }
            tablaHistorial.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();

        setTitle("Movimientos");

        tablaHistorial.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaHistorial.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaHistorial.setOpaque(false);
        jScrollPane1.setViewportView(tablaHistorial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
