/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

import static com.danielcampos.redgym.proyecto.Menu.IconVentas;
import static com.danielcampos.redgym.proyecto.Menu.PanelVentas;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Gerardo Campos García 
 * Class NuevaVenta. Se crear para Vender los productos
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 * Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 */
public class NuevaVenta extends javax.swing.JInternalFrame {

    
    Productos pd = new Productos();
    EntidadEntrenador En = new EntidadEntrenador();
    ProductosDAO pdao = new ProductosDAO();
    Venta v = new Venta();
    VentasDAO vdao = new VentasDAO();
    DetalleVentas dv = new DetalleVentas();

    int idp;
    double tpagar;
    int cat;
    double preci;
    DefaultTableModel modelo = new DefaultTableModel();

    public NuevaVenta() {

        initComponents();
        setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        cmbMostarEntidades();
        generarSerie();
    }
/**
 * Carga todas las entidades en los ComboBox 
 */
    void cmbMostarEntidades() {

        DefaultComboBoxModel modeloProducto = new DefaultComboBoxModel(pd.mostrarProducto());
        cmbPro.setModel(modeloProducto);
        DefaultComboBoxModel modeloEntrenador = new DefaultComboBoxModel(En.mostrarEntrenador());
        cmbEn.setModel(modeloEntrenador);
        Color myColor = new Color(255, 153, 102);
        Color myColo = new Color(255, 51, 51);
        Table.setBackground(myColor);
        Table.getTableHeader().setBackground(myColo);
        Table.getTableHeader().setForeground(Color.black);
        Table.getTableHeader().setOpaque(false);
        Table.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 15));
        cmbEn.setBackground(myColor);

    }

    void generarSerie() {
        String serie = vdao.serieVenta();
        if (serie == null) {
            txtSerie.setText("1");
        } else {

            int increment = Integer.parseInt(serie);
            increment = increment + 1;
            
            txtSerie.setText("" + increment);
        }
    }

    void agregarProductoTabla() {

        double total;
        String uni;
        int item = 0;
        modelo = (DefaultTableModel) Table.getModel();
        item = item + 1;
        Productos des = (Productos) cmbPro.getSelectedItem();
        idp = des.getId();
        uni = des.getUnidad();
        double pre = Double.parseDouble(txtPrecio.getText());
        int cant = Integer.parseInt(SpCantidad.getValue().toString());
        int stock = Integer.parseInt(txtStock.getText());
        int cal = stock - (cant);
        if (cant <= stock) {
            txtStock.setText(String.valueOf(cal));
        }
        total = cant * pre;
        ArrayList lista = new ArrayList();
        if (stock > 0 && cant <= stock) {

            lista.add(item);
            lista.add(idp);
            lista.add(des);
            lista.add(uni);
            lista.add(pre);
            lista.add(cant);
            lista.add(total);
            Object[] ob = new Object[7];
            ob[0] = lista.get(0);
            ob[1] = lista.get(1);
            ob[2] = lista.get(2);
            ob[3] = lista.get(3);
            ob[4] = lista.get(4);
            ob[5] = lista.get(5);
            ob[6] = lista.get(6);
            modelo.addRow(ob);

            Table.setModel(modelo);
            calcularTotal();

        } else {
            JOptionPane.showMessageDialog(this, "Stock Producto no disponible");
        }
    }

    void calcularTotal() {
        tpagar = 0;
        for (int i = 0; i < Table.getRowCount(); i++) {
            cat = Integer.parseInt(Table.getValueAt(i, 5).toString());
            preci = Double.parseDouble(Table.getValueAt(i, 4).toString());
            tpagar = tpagar + (cat * preci);
        }
        txtTotal.setText("$" + tpagar);
    }

    void limpiar() {
        limpiarTabla();
        cmbPro.setSelectedItem(null);
        cmbEn.setSelectedItem(null);
        SpCantidad.setValue(0);
        txtTotal.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }

    void limpiarTabla() {
        for (int i = 0; i < Table.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void actulizarStock() {
        for (int i = 0; i < Table.getRowCount(); i++) {
            Productos pr = new Productos();
            idp = Integer.parseInt(Table.getValueAt(i, 1).toString());
            cat = Integer.parseInt(Table.getValueAt(i, 5).toString());
            pr = pdao.listarPorID(idp);
            int sa = pr.getCan() - cat;
            pdao.actulizarStock(sa, idp);
        }
    }

    void guardarVenta() {
        EntidadEntrenador en = (EntidadEntrenador) cmbEn.getSelectedItem();
        int idE = en.getIdE();
        String serie = txtSerie.getText();
        String fecha = "";
        double monto = tpagar;
        String estado = "1";

        v.setIdEntrenador(idE);
        v.setSerie(serie);
        v.setFecha(fecha);
        v.setMonto(monto);
        v.setEstado(estado);
        vdao.GuardarVentas(v);
    }

    void guardarDetalleVenta() {
        String idV = vdao.IdVentas();
        int idve = Integer.parseInt(idV);
        for (int i = 0; i < Table.getRowCount(); i++) {
            int idp = Integer.parseInt(Table.getValueAt(i, 1).toString());
            String Unidad = (Table.getValueAt(i, 3).toString());
            int cant = Integer.parseInt(Table.getValueAt(i, 5).toString());
            double pre = Double.parseDouble(Table.getValueAt(i, 6).toString());
            dv.setIdVenta(idve);
            dv.setIdPro(idp);
            dv.setUnidad(Unidad);
            dv.setCantidad(cant);
            dv.setPreventa(pre);
            vdao.GuardarDetalleVentas(dv);
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
        cerrar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnVenta = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnCandelar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbEn = new javax.swing.JComboBox<>();
        cmbPro = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SpCantidad = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(750, 582));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        cerrar.setForeground(new java.awt.Color(255, 255, 255));
        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setText("X");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(cerrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 20, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total a pagar:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 102));
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 110, -1));

        btnVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentaMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel9.setText("Realizar Venta");

        javax.swing.GroupLayout btnVentaLayout = new javax.swing.GroupLayout(btnVenta);
        btnVenta.setLayout(btnVentaLayout);
        btnVentaLayout.setHorizontalGroup(
            btnVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVentaLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnVentaLayout.setVerticalGroup(
            btnVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        getContentPane().add(btnVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));

        btnCandelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCandelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCandelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCandelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCandelarMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setText("Cancelar");

        javax.swing.GroupLayout btnCandelarLayout = new javax.swing.GroupLayout(btnCandelar);
        btnCandelar.setLayout(btnCandelarLayout);
        btnCandelarLayout.setHorizontalGroup(
            btnCandelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCandelarLayout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnCandelarLayout.setVerticalGroup(
            btnCandelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCandelarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(btnCandelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, -1, -1));

        cmbEn.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cmbEn.setOpaque(false);
        getContentPane().add(cmbEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 256, -1));

        cmbPro.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cmbPro.setOpaque(false);
        cmbPro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 149, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("No.Serie:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, 20));

        txtSerie.setEditable(false);
        txtSerie.setBackground(new java.awt.Color(255, 255, 255));
        txtSerie.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        txtSerie.setForeground(new java.awt.Color(255, 153, 102));
        txtSerie.setBorder(null);
        txtSerie.setOpaque(false);
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 75, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 60, -1));

        txtStock.setEditable(false);
        txtStock.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        txtStock.setForeground(new java.awt.Color(255, 153, 102));
        txtStock.setBorder(null);
        txtStock.setOpaque(false);
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 100, 20));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agregar");

        javax.swing.GroupLayout btnAgregarLayout = new javax.swing.GroupLayout(btnAgregar);
        btnAgregar.setLayout(btnAgregarLayout);
        btnAgregarLayout.setHorizontalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAgregarLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        btnAgregarLayout.setVerticalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 85, -1));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(255, 153, 102));
        txtPrecio.setBorder(null);
        txtPrecio.setOpaque(false);
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 99, 20));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 85, -1));

        SpCantidad.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        SpCantidad.setBorder(null);
        getContentPane().add(SpCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 60, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ventas.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 220));

        Table.setBackground(new java.awt.Color(0, 0, 0));
        Table.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.Serie", "ID", "Nombre", "Unidad", "Precio", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setEnabled(false);
        Table.setFocusable(false);
        Table.setGridColor(new java.awt.Color(0, 0, 0));
        Table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        Table.setOpaque(false);
        Table.setSelectionBackground(new java.awt.Color(255, 102, 51));
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 710, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Productos est = (Productos) cmbPro.getSelectedItem();
            txtPrecio.setText("" + est.getPrecio());
            txtStock.setText("" + est.getCan());

        }

    }//GEN-LAST:event_cmbProItemStateChanged

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        agregarProductoTabla();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        Color myColor = new Color(255, 153, 102);

        btnAgregar.setBackground(myColor);
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        Color myColor = new Color(255, 255, 255);

        btnAgregar.setBackground(myColor);
    }//GEN-LAST:event_btnAgregarMouseExited

    private void btnCandelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandelarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnCandelarMouseClicked

    private void btnCandelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandelarMouseEntered
        Color myColor = new Color(255, 153, 102);

        btnCandelar.setBackground(myColor);
    }//GEN-LAST:event_btnCandelarMouseEntered

    private void btnCandelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandelarMouseExited
        Color myColor = new Color(255, 255, 255);

        btnCandelar.setBackground(myColor);
    }//GEN-LAST:event_btnCandelarMouseExited

    private void btnVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseClicked
        if (txtTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe de ingresar datos");
        } else {
            guardarVenta();
            guardarDetalleVenta();
            actulizarStock();
            JOptionPane.showMessageDialog(this, "Venta Realizada");
            cmbMostarEntidades();
            limpiar();
            generarSerie();
        }
    }//GEN-LAST:event_btnVentaMouseClicked

    private void btnVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseEntered
        Color myColor = new Color(255, 153, 102);

        btnVenta.setBackground(myColor);
    }//GEN-LAST:event_btnVentaMouseEntered

    private void btnVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseExited
        Color myColor = new Color(255, 255, 255);

        btnVenta.setBackground(myColor);
    }//GEN-LAST:event_btnVentaMouseExited

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        dispose();
        Color cl = new Color(0, 117, 155);
        PanelVentas.setBackground(cl);
        //Icon icon = new ImageIcon(getClass().getResource("/img/gif.gif"));
        IconVentas.setIcon(null);
        PanelVentas.setEnabled(true);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        jPanel1.setBackground(Color.red);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        jPanel1.setBackground(Color.black);
    }//GEN-LAST:event_jPanel1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpCantidad;
    private javax.swing.JTable Table;
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnCandelar;
    private javax.swing.JPanel btnVenta;
    private javax.swing.JLabel cerrar;
    private javax.swing.JComboBox<String> cmbEn;
    private javax.swing.JComboBox<String> cmbPro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
