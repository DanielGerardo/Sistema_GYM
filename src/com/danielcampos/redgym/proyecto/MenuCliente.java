/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

import com.danielcampos.redgym.Clientespk.NuevoCliente;
import static com.danielcampos.redgym.proyecto.Menu.IconClientes;
import static com.danielcampos.redgym.proyecto.Menu.Menu1;
import static com.danielcampos.redgym.proyecto.Menu.PanelClientes;
import static com.danielcampos.redgym.proyecto.Menu.btnCerrarMenu;
import static com.danielcampos.redgym.proyecto.Menu.miniMenu;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Gerardo Campos García
 * Class JInternalFrame MenuCliente se crea para dejar como opcion que quiere hacer con el clientes "compar plan" o "agregar un nuevo cliente"
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 * Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 * 
 */
public class MenuCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cliente
     */
    public MenuCliente() {
         ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/img/robo3d.png"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
        setBorder(null);
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAPlan = new javax.swing.JPanel();
        txtPlan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtCliente = new javax.swing.JLabel();

        btnCerrar.setOpaque(false);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });
        btnCerrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCerrarKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");

        javax.swing.GroupLayout btnCerrarLayout = new javax.swing.GroupLayout(btnCerrar);
        btnCerrar.setLayout(btnCerrarLayout);
        btnCerrarLayout.setHorizontalGroup(
            btnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCerrarLayout.setVerticalGroup(
            btnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCerrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        btnAPlan.setBackground(new java.awt.Color(255, 204, 255));
        btnAPlan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAPlanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAPlanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAPlanMouseExited(evt);
            }
        });

        txtPlan.setBackground(new java.awt.Color(102, 153, 255));
        txtPlan.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        txtPlan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPlan.setText("Agregar Plan");

        javax.swing.GroupLayout btnAPlanLayout = new javax.swing.GroupLayout(btnAPlan);
        btnAPlan.setLayout(btnAPlanLayout);
        btnAPlanLayout.setHorizontalGroup(
            btnAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAPlanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPlan)
                .addContainerGap())
        );
        btnAPlanLayout.setVerticalGroup(
            btnAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPlan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        txtCliente.setBackground(new java.awt.Color(102, 153, 255));
        txtCliente.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        txtCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCliente.setText("Nuevo Cliente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCliente)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 442, Short.MAX_VALUE)
                .addComponent(btnAPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(446, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCerrarKeyPressed
      
    }//GEN-LAST:event_btnCerrarKeyPressed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
       dispose();
       btnCerrarMenu.setVisible(true);
        miniMenu.setVisible(true);
        Color cl = new Color(0, 117, 155);
         PanelClientes.setBackground(cl);
        //Icon icon = new ImageIcon(getClass().getResource("/img/gif.gif"));
        IconClientes.setIcon(null);
        PanelClientes.setEnabled(true);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
      
        NuevoCliente nc=new NuevoCliente();
       centrarVentana(nc);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
         btnCerrar.setOpaque(true);
        btnCerrar.setBackground(Color.red);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
       btnCerrar.setOpaque(false);
       btnCerrar.setBackground(null);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnAPlanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAPlanMouseClicked
       PlanesClientes pl=new PlanesClientes();
         centrarVentana(pl);
    }//GEN-LAST:event_btnAPlanMouseClicked
//133hws
    private void btnAPlanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAPlanMouseEntered
        btnAPlan.setBackground(new Color(239,142,239));
        txtPlan.setForeground(Color.white);
    }//GEN-LAST:event_btnAPlanMouseEntered

    private void btnAPlanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAPlanMouseExited
       btnAPlan.setBackground(new Color(255,204,255));
        txtPlan.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btnAPlanMouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setBackground(new Color(239,142,239));
        txtCliente.setForeground(Color.white);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setBackground(new Color(255,204,255));
        txtCliente.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jPanel3MouseExited
 
                                       
 /**
 *
 * Metodo para centrar la ventanas JInternalFrame centrado en un Desktop panel
 */
    void centrarVentana(JInternalFrame frame){
        
        Menu1.add(frame);
        Dimension dimension=Menu1.getSize();
        Dimension Dframe=frame.getSize();
        frame.setLocation((dimension.width-Dframe.width)/2,(dimension.height-Dframe.height));
        frame.show();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAPlan;
    private javax.swing.JPanel btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtPlan;
    // End of variables declaration//GEN-END:variables
}