/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

import static com.danielcampos.redgym.proyecto.Menu.IconProductos;
import static com.danielcampos.redgym.proyecto.Menu.PanelProducto;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Gerardo Campos García 
 * Class NuevoProcuto. Se crea para agregar nuevos prodcutos a la BD 
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 * Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 */
public class NuevoProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form NuevoProducto
     * Cada caja de texto debe de llevar la clase TextPrompt
     * TextPrompt; Se usa para colocar text de fondo en cada caja de text.
     */
    ColorCelda co = new ColorCelda();

    public NuevoProducto() {
        initComponents();
        setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        cargarTabla();
        //txtId.setVisible(false);
        TextPrompt formato1 = new TextPrompt("ID", txtId);
        TextPrompt formato2 = new TextPrompt("Descripcion", txtDesc);
        TextPrompt formato3 = new TextPrompt("Unidad", txtUnidad);
        TextPrompt formato4 = new TextPrompt("Stock", txtStock);
        TextPrompt formato5 = new TextPrompt("Precio", txtPrecio);
        txtCantidad.setVisible(false);
        Cancelar.setVisible(false);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

    }
    Conexion cc = new Conexion();
    Connection cn = cc.Conexion();

    void guardarHistorialSalidas() {
        String fecha, id_producto, descripcion, unidad, cantidad;
        String sql = "";

        id_producto = txtId.getText();
        descripcion = txtDesc.getText();
        unidad = txtUnidad.getText();
        cantidad = txtCantidad.getText();

        sql = "INSERT INTO historial (movimiento, fecha, id_producto, descripcion, unidad, cantidad)"
                + "VALUES (?,GETDATE(),?,?,?,?)";
        try {
            PreparedStatement p = cn.prepareStatement(sql);
            p.setString(1, "SALIDA");
            p.setString(2, id_producto);
            p.setString(3, descripcion);
            p.setString(4, unidad);
            p.setString(5, cantidad);

            int n = p.executeUpdate();

            if (n > 0) {
            }
            cargarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void guardarHistorialEntrada() {
        String fecha, id_producto, descripcion, unidad, cantidad;
        String sql = "";

        id_producto = txtId.getText();
        descripcion = txtDesc.getText();
        unidad = txtUnidad.getText();
        cantidad = txtCantidad.getText();

        sql = "INSERT INTO historial (movimiento, fecha, id_producto, descripcion, unidad, cantidad)"
                + "VALUES (?,GETDATE(),?,?,?,?)";
        try {
            PreparedStatement p = cn.prepareStatement(sql);
            p.setString(1, "ENTRADA");
            p.setString(2, id_producto);
            p.setString(3, descripcion);
            p.setString(4, unidad);
            p.setString(5, cantidad);

            int n = p.executeUpdate();

            if (n > 0) {
            }
            cargarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void cargarTabla() {

        tablaProductos.getTableHeader().setBackground(new Color(255, 255, 208));
        tablaProductos.getTableHeader().setForeground(Color.black);
        tablaProductos.getTableHeader().setOpaque(false);

        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        model.setRowCount(0);
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colu;
        try {
            ps = cn.prepareStatement("SELECT Id_producto,Descripcion,Unidad,Cantidad,Precio,Fecha FROM Productos");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            colu = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[colu];
                for (int indice = 0; indice < colu; indice++) {
                    fila[indice] = rs.getString(indice + 1);
                }
                model.addRow(fila);
            }
            tablaProductos.setModel(model);

            txtId.setText("");
            txtDesc.setText("");
            txtUnidad.setText("");
            txtStock.setText("");
            txtPrecio.setText("");
            tablaProductos.setDefaultRenderer(Object.class, co);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
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

        txtId = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        txtUnidad = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEntradas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnSalidas = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnHistorial = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 171, 101));
        setPreferredSize(new java.awt.Dimension(750, 582));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtId.setBackground(new java.awt.Color(255, 171, 101));
        txtId.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 171, 101), new java.awt.Color(255, 171, 101), new java.awt.Color(102, 102, 102), new java.awt.Color(255, 171, 101)));
        txtId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtIdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtIdMouseExited(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 67, 58, 20));

        txtDesc.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtDesc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 171, 101), new java.awt.Color(255, 171, 101), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDescMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDescMouseExited(evt);
            }
        });
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
        });
        getContentPane().add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 97, 180, -1));

        txtUnidad.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtUnidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 171, 101), new java.awt.Color(255, 171, 101), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtUnidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUnidadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUnidadMouseExited(evt);
            }
        });
        txtUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUnidadKeyPressed(evt);
            }
        });
        getContentPane().add(txtUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 127, 70, -1));

        txtStock.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtStock.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 171, 101), new java.awt.Color(255, 171, 101), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtStockMouseExited(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockKeyPressed(evt);
            }
        });
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 157, 54, -1));

        txtPrecio.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtPrecio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 171, 101), new java.awt.Color(255, 171, 101), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPrecioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPrecioMouseExited(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
        });
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 187, 54, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(-3);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 30, 30));

        tablaProductos.setBackground(new java.awt.Color(255, 255, 208));
        tablaProductos.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Unidad", "Cantidad", "Precio", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setToolTipText("");
        tablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaProductos.setDoubleBuffered(true);
        tablaProductos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaProductos.setOpaque(false);
        tablaProductos.setSelectionBackground(new java.awt.Color(255, 153, 51));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 295, 750, 290));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gymp1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setIconTextGap(-3);
        jLabel1.setInheritsPopupMenu(false);
        jLabel1.setMaximumSize(new java.awt.Dimension(305, 300));
        jLabel1.setPreferredSize(new java.awt.Dimension(304, 299));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 0, -1, 273));

        btnEliminar.setBackground(new java.awt.Color(255, 171, 101));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel3.setText("Eliminar");

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 227, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 171, 101));
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
        jLabel4.setText("Buscar");

        javax.swing.GroupLayout btnBuscarLayout = new javax.swing.GroupLayout(btnBuscar);
        btnBuscar.setLayout(btnBuscarLayout);
        btnBuscarLayout.setHorizontalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        btnBuscarLayout.setVerticalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 227, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 171, 101));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel2.setText("Guardar");

        javax.swing.GroupLayout btnGuardarLayout = new javax.swing.GroupLayout(btnGuardar);
        btnGuardar.setLayout(btnGuardarLayout);
        btnGuardarLayout.setHorizontalGroup(
            btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGuardarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        btnGuardarLayout.setVerticalGroup(
            btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 227, -1, -1));

        btnEntradas.setBackground(new java.awt.Color(255, 171, 101));
        btnEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntradasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntradasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntradasMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel5.setText("Salidas");

        javax.swing.GroupLayout btnEntradasLayout = new javax.swing.GroupLayout(btnEntradas);
        btnEntradas.setLayout(btnEntradasLayout);
        btnEntradasLayout.setHorizontalGroup(
            btnEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntradasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        btnEntradasLayout.setVerticalGroup(
            btnEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        getContentPane().add(btnEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 250, -1, -1));

        btnSalidas.setBackground(new java.awt.Color(255, 171, 101));
        btnSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalidasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalidasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalidasMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel10.setText("Entradas");

        javax.swing.GroupLayout btnSalidasLayout = new javax.swing.GroupLayout(btnSalidas);
        btnSalidas.setLayout(btnSalidasLayout);
        btnSalidasLayout.setHorizontalGroup(
            btnSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnSalidasLayout.setVerticalGroup(
            btnSalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        getContentPane().add(btnSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 227, 64, -1));

        txtCantidad.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 187, 64, -1));

        btnHistorial.setBackground(new java.awt.Color(255, 171, 101));
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHistorialMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel6.setText("Historial");

        javax.swing.GroupLayout btnHistorialLayout = new javax.swing.GroupLayout(btnHistorial);
        btnHistorial.setLayout(btnHistorialLayout);
        btnHistorialLayout.setHorizontalGroup(
            btnHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHistorialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnHistorialLayout.setVerticalGroup(
            btnHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        getContentPane().add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        Cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cancelar.setText("X");
        Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelarMouseExited(evt);
            }
        });
        getContentPane().add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDesc.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUnidad.requestFocus();
        }
    }//GEN-LAST:event_txtDescKeyPressed

    private void txtUnidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtStock.requestFocus();
        }
    }//GEN-LAST:event_txtUnidadKeyPressed

    private void txtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPrecio.requestFocus();
        }
    }//GEN-LAST:event_txtStockKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Conexion cc = new Conexion();
            Connection cn = cc.Conexion();
            double cantidad;
            double precio;
            String sql = "";
            int id = Integer.parseInt(txtId.getText());
            String descripcion = txtDesc.getText();
            String unidad = txtUnidad.getText();
            cantidad = Double.parseDouble(txtStock.getText());
            precio = Double.parseDouble(txtPrecio.getText());

            sql = "insert into Productos (id_producto,Descripcion,Unidad,Cantidad,Precio,Fecha) values (?,?,?,?,?,GETDATE())";

            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setDouble(1, id);
                pst.setString(2, descripcion);
                pst.setString(3, unidad);
                pst.setDouble(4, cantidad);
                pst.setDouble(5, precio);

                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado con exito!");
                }

                cargarTabla();
            } catch (SQLException ex) {
                Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Color cl = new Color(0, 117, 155);
        PanelProducto.setBackground(cl);
        //Icon icon = new ImageIcon(getClass().getResource("/img/gif.gif"));
        IconProductos.setIcon(null);
        PanelProducto.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        try {
            int fila = tablaProductos.getSelectedRow();
            int id = Integer.parseInt(tablaProductos.getValueAt(fila, 0).toString());

            Conexion cc = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection cn = cc.Conexion();

            ps = cn.prepareStatement("SELECT Descripcion,Unidad,Cantidad,Precio FROM Productos WHERE Id_producto=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                txtId.setText(String.valueOf(id));
                txtDesc.setText(rs.getString("Descripcion"));
                txtUnidad.setText(rs.getString("Unidad"));
                txtStock.setText(rs.getString("Cantidad"));
                txtPrecio.setText(rs.getString("Precio"));
            }
        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(null, ex.toString());

        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        int cantidad;
        double precio;
        String sql = "";
        int id = Integer.parseInt(txtId.getText());
        String descripcion = txtDesc.getText().toUpperCase();
        String unidad = txtUnidad.getText().toUpperCase();
        cantidad = Integer.parseInt(txtStock.getText());
        precio = Double.parseDouble(txtPrecio.getText());

        sql = "insert into Productos (id_producto,Descripcion,Unidad,Cantidad,Precio,Fecha) values (?,?,?,?,?,GETDATE())";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, descripcion);
            pst.setString(3, unidad);
            pst.setInt(4, cantidad);
            pst.setDouble(5, precio);

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado con exito!");
            }

            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        String sql = "";
        int id = Integer.parseInt(txtId.getText());

        sql = "DELETE Productos WHERE id_producto=?";

        try {
            Conexion cc = new Conexion();
            Connection cn = cc.Conexion();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, id);

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado con exito!");
            }

            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        PreparedStatement ps;
        ResultSet rs;

        int id = Integer.parseInt(txtId.getText());

        try {
            ps = cn.prepareStatement("SELECT Descripcion,Unidad,Cantidad,Precio FROM Productos WHERE id_producto=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                txtDesc.setText(rs.getString("Descripcion"));
                txtUnidad.setText(rs.getString("Unidad"));
                txtStock.setText(rs.getString("Cantidad"));
                txtPrecio.setText(rs.getString("Precio"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked
    void BorraeInactiva() {
        txtId.setEnabled(false);
        txtDesc.setEnabled(false);
        txtUnidad.setEnabled(false);
        txtStock.setEnabled(false);
        txtPrecio.setEnabled(false);
        btnGuardar.setVisible(false);
        btnBuscar.setVisible(false);
        btnEliminar.setVisible(false);
        btnSalidas.setVisible(false);
        btnEntradas.setVisible(false);
        txtCantidad.setVisible(true);
        txtCantidad.requestFocus();
    }

    void Activa() {
        txtId.setEnabled(true);
        txtDesc.setEnabled(true);
        txtUnidad.setEnabled(true);
        txtStock.setEnabled(true);
        txtPrecio.setEnabled(true);
        btnGuardar.setVisible(true);
        btnBuscar.setVisible(true);
        btnEliminar.setVisible(true);
        btnSalidas.setVisible(true);
        btnEntradas.setVisible(true);
        txtCantidad.setVisible(false);
        txtCantidad.requestFocus();
    }
    /**
     * Se crea para agregar o sacar productos del Stock guardarlos en una tabla de historial
     * @param evt
     * Si se oprime la tecla Enter en la caja de color verde se van a agregar los productos como entradas recordando que no se pueden agregar cantidades menores e igual a 0
     * Si se oprime la tecla Enter en la caja de color rojo se van a sacar los productos como salidas recordando que no se pueden sacar cantidades mayores al stock o menores e igual a 0
     */
    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (txtStock.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debes Seleccionar un Producto");
            } else {
                int can = Integer.parseInt(txtCantidad.getText());
                int stock = Integer.parseInt(txtStock.getText());
                if (txtCantidad.getBackground() == Color.green && can >= 1) {
                    try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE Productos SET Cantidad ="
                                + "Cantidad+'" + txtCantidad.getText() + "'"
                                + "WHERE Id_Producto = '" + txtId.getText() + "'");
                        int option = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas agregar"
                                + " " + txtCantidad.getText() + " pizas?", " Confirmar Entrada", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_NO_OPTION) {
                            int a = pst.executeUpdate();
                            if (a > 0) {

                                guardarHistorialEntrada();
                                Activa();
                                Cancelar.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Selecciona un producto");
                            }
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
                if (can < 1) {
                    JOptionPane.showMessageDialog(null, "Debes de ingresar valores mayores a 0");
                }
                if (txtCantidad.getBackground() == Color.red && can <= stock && can >= 1) {
                    try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE Productos SET Cantidad ="
                                + "Cantidad-'" + txtCantidad.getText() + "'"
                                + "WHERE Id_Producto = '" + txtId.getText() + "'");
                        int option = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas quitar"
                                + " " + txtCantidad.getText() + " pizas?", " Confirmar Salida", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_NO_OPTION) {
                            int a = pst.executeUpdate();
                            if (a > 0) {

                                guardarHistorialSalidas();
                                Activa();
                                Cancelar.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Selecciona un producto");
                            }
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
                if (txtCantidad.getBackground() == Color.red && can > stock) {
                    JOptionPane.showMessageDialog(null, "No puedes quitar mas cantidad que la que tienes en el stock");
                }
            }
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void btnSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidasMouseClicked
        BorraeInactiva();
        txtCantidad.setBackground(Color.green);
        Cancelar.setVisible(true);
    }//GEN-LAST:event_btnSalidasMouseClicked

    private void btnEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradasMouseClicked
        BorraeInactiva();
        Cancelar.setVisible(true);
        txtCantidad.setBackground(Color.red);
    }//GEN-LAST:event_btnEntradasMouseClicked

    private void btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseClicked
        Historial hu = new Historial();
        hu.setVisible(true);
    }//GEN-LAST:event_btnHistorialMouseClicked

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
        Activa();
        Cancelar.setVisible(false);
    }//GEN-LAST:event_CancelarMouseClicked

    private void CancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseEntered
        Cancelar.setForeground(Color.RED);
    }//GEN-LAST:event_CancelarMouseEntered

    private void CancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseExited
        Cancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_CancelarMouseExited

    private void txtIdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdMouseEntered
        txtId.setBackground(Color.white);
        txtId.setSize(68, 20);
    }//GEN-LAST:event_txtIdMouseEntered

    private void txtIdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdMouseExited
        txtId.setBackground(new Color(255, 171, 101));
        txtId.setSize(58, 20);
    }//GEN-LAST:event_txtIdMouseExited

    private void txtDescMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescMouseEntered
        txtDesc.setBackground(new Color(255, 171, 101));
        txtDesc.setSize(190, 20);
    }//GEN-LAST:event_txtDescMouseEntered

    private void txtDescMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescMouseExited
        txtDesc.setBackground(Color.white);
        txtDesc.setSize(180, 20);
    }//GEN-LAST:event_txtDescMouseExited

    private void txtUnidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUnidadMouseEntered
        txtUnidad.setBackground(new Color(255, 171, 101));
        txtUnidad.setSize(80, 20);
    }//GEN-LAST:event_txtUnidadMouseEntered

    private void txtUnidadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUnidadMouseExited
        txtUnidad.setBackground(Color.white);
        txtUnidad.setSize(70, 20);
    }//GEN-LAST:event_txtUnidadMouseExited

    private void txtStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockMouseEntered
        txtStock.setBackground(new Color(255, 171, 101));
        txtStock.setSize(64, 20);
    }//GEN-LAST:event_txtStockMouseEntered

    private void txtStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockMouseExited
        txtStock.setBackground(Color.white);
        txtStock.setSize(54, 20);
    }//GEN-LAST:event_txtStockMouseExited

    private void txtPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMouseEntered
        txtPrecio.setBackground(new Color(255, 171, 101));
        txtPrecio.setSize(64, 20);
    }//GEN-LAST:event_txtPrecioMouseEntered

    private void txtPrecioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMouseExited
        txtPrecio.setBackground(Color.white);
        txtPrecio.setSize(54, 20);
    }//GEN-LAST:event_txtPrecioMouseExited

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(255, 102, 0));

    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(255, 171, 101));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        btnBuscar.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        btnBuscar.setBackground(new Color(255, 171, 101));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnSalidasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidasMouseEntered
        btnSalidas.setBackground(new Color(0, 183, 46));
    }//GEN-LAST:event_btnSalidasMouseEntered

    private void btnEntradasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradasMouseEntered
        btnEntradas.setBackground(new Color(255, 58, 58));
    }//GEN-LAST:event_btnEntradasMouseEntered

    private void btnSalidasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidasMouseExited
        btnSalidas.setBackground(new Color(255, 171, 101));
    }//GEN-LAST:event_btnSalidasMouseExited

    private void btnEntradasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradasMouseExited
        btnEntradas.setBackground(new Color(255, 171, 101));
    }//GEN-LAST:event_btnEntradasMouseExited

    private void btnHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseEntered
        btnHistorial.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_btnHistorialMouseEntered

    private void btnHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseExited
        btnHistorial.setBackground(new Color(255, 171, 101));
    }//GEN-LAST:event_btnHistorialMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new Color(255, 171, 101));
    }//GEN-LAST:event_btnEliminarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancelar;
    private javax.swing.JPanel btnBuscar;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnEntradas;
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JPanel btnHistorial;
    private javax.swing.JPanel btnSalidas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaProductos;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtDesc;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtStock;
    public static javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
