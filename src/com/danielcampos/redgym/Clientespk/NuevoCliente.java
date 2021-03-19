/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.Clientespk;

import com.danielcampos.redgym.proyecto.Conexion;
import com.danielcampos.redgym.proyecto.NuevoProducto;
import com.danielcampos.redgym.proyecto.TextPrompt;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Gerardo Campos García
 * Class para agregar nuevos clientes 
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 * Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 * 
 */
public class NuevoCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form NuevoCliente
         * Cada caja de texto debe de llevar la clase TextPrompt
         * TextPrompt; Se usa para colocar text de fondo en cada caja de text.
         * 
         */
    public NuevoCliente() {
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/img/título.png"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
        setBorder(null);
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        txtIdE.setVisible(false);
        
        TextPrompt formato1 = new TextPrompt("Nombre Cliente", txtNom);
        TextPrompt formato2 = new TextPrompt("Apellidos", txtApe);
        TextPrompt formato3 = new TextPrompt("Direccion", txtDire);
        TextPrompt formato4 = new TextPrompt("Telefono", txtTel);
        TextPrompt formato5 = new TextPrompt("Tel Adicional", txtTelA);
        TextPrompt formato6 = new TextPrompt("Edad", txtEdad);
        TextPrompt formato7 = new TextPrompt("Ingrese Usuario", txtUser);
        TextPrompt formato8 = new TextPrompt("¿Alguna Enfermedad?¿Cual?", txtEnfe);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
    }
void listarClientesActivos(){
    Color myColor = new Color(120,255,255);
        Table.setBackground(myColor);
        Table.getTableHeader().setBackground(myColor);
        Table.getTableHeader().setForeground(Color.black);
        Table.getTableHeader().setOpaque(false);
        Table.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 16)); 
     DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colu;
        try {
             ps = cn.prepareStatement("SELECT Nombre,Apellidos,Direccion,Telefono,FechaDeIngreso,UserName,Activo FROM Clientes WHERE Activo=1");
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
            Table.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
}
 void listarClientesInactivos(){
    Color myColor = new Color(120,255,255);
        Table.setBackground(myColor);
        Table.getTableHeader().setBackground(myColor);
        Table.getTableHeader().setForeground(Color.black);
        Table.getTableHeader().setOpaque(false);
        Table.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 16)); 
     DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colu;
        try {
             ps = cn.prepareStatement("SELECT Nombre,Apellidos,Direccion,Telefono,FechaDeIngreso,UserName,Activo FROM Clientes WHERE Activo=0");
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
            Table.setModel(model);
          
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        txtNom = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtDire = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtTelA = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        cmbSexo = new javax.swing.JComboBox<>();
        cmbActivo = new javax.swing.JComboBox<>();
        foto = new JPanelWebCam.JPanelWebCam();
        txtIdE = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        PModificar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PGuardar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PBuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PEliminar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtEnfe = new javax.swing.JTextField();

        setVisible(false);

        Table.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Direccion", "Telefono", "Fecha", "UserName", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        Table.setOpaque(false);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        txtNom.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtNom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtNom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNomMouseExited(evt);
            }
        });
        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomKeyPressed(evt);
            }
        });

        txtApe.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtApe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtApe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtApeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtApeMouseExited(evt);
            }
        });
        txtApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApeKeyPressed(evt);
            }
        });

        txtDire.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtDire.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtDire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDireMouseExited(evt);
            }
        });
        txtDire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireActionPerformed(evt);
            }
        });
        txtDire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireKeyPressed(evt);
            }
        });

        txtTel.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtTel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtTel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTelMouseExited(evt);
            }
        });
        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelKeyPressed(evt);
            }
        });

        txtTelA.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtTelA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtTelA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTelAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTelAMouseExited(evt);
            }
        });
        txtTelA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelAKeyPressed(evt);
            }
        });

        txtEdad.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtEdad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtEdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtEdadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEdadMouseExited(evt);
            }
        });
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdadKeyPressed(evt);
            }
        });

        txtUser.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUserMouseExited(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        cmbSexo.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo", "M", "F" }));
        cmbSexo.setBorder(null);
        cmbSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbSexoKeyPressed(evt);
            }
        });

        cmbActivo.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        cmbActivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "1", "0" }));
        cmbActivo.setBorder(null);
        cmbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbActivoActionPerformed(evt);
            }
        });

        foto.setBackground(new java.awt.Color(255, 255, 255));
        foto.setToolTipText("");
        foto.setFONDO(false);
        foto.setColor1(new java.awt.Color(255, 255, 255));
        foto.setColor2(new java.awt.Color(255, 255, 255));
        foto.setOpaque(false);
        foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fotoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout fotoLayout = new javax.swing.GroupLayout(foto);
        foto.setLayout(fotoLayout);
        fotoLayout.setHorizontalGroup(
            fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
        fotoLayout.setVerticalGroup(
            fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        btnCerrar.setBackground(new java.awt.Color(51, 255, 255));
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

        Cerrar.setBackground(new java.awt.Color(51, 246, 254));
        Cerrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cerrar.setText("X");

        javax.swing.GroupLayout btnCerrarLayout = new javax.swing.GroupLayout(btnCerrar);
        btnCerrar.setLayout(btnCerrarLayout);
        btnCerrarLayout.setHorizontalGroup(
            btnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );
        btnCerrarLayout.setVerticalGroup(
            btnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCerrarLayout.createSequentialGroup()
                .addComponent(Cerrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PModificar.setBackground(new java.awt.Color(255, 255, 255));
        PModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PModificarMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel3.setText("Modificar");

        javax.swing.GroupLayout PModificarLayout = new javax.swing.GroupLayout(PModificar);
        PModificar.setLayout(PModificarLayout);
        PModificarLayout.setHorizontalGroup(
            PModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PModificarLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        PModificarLayout.setVerticalGroup(
            PModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        PGuardar.setBackground(new java.awt.Color(255, 255, 255));
        PGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PGuardarMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel1.setText("Guardar");

        javax.swing.GroupLayout PGuardarLayout = new javax.swing.GroupLayout(PGuardar);
        PGuardar.setLayout(PGuardarLayout);
        PGuardarLayout.setHorizontalGroup(
            PGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PGuardarLayout.setVerticalGroup(
            PGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PBuscar.setBackground(new java.awt.Color(255, 255, 255));
        PBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PBuscarMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel2.setText("Buscar");

        javax.swing.GroupLayout PBuscarLayout = new javax.swing.GroupLayout(PBuscar);
        PBuscar.setLayout(PBuscarLayout);
        PBuscarLayout.setHorizontalGroup(
            PBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );
        PBuscarLayout.setVerticalGroup(
            PBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        PEliminar.setBackground(new java.awt.Color(255, 255, 255));
        PEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PEliminarMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel4.setText("Eliminar");

        javax.swing.GroupLayout PEliminarLayout = new javax.swing.GroupLayout(PEliminar);
        PEliminar.setLayout(PEliminarLayout);
        PEliminarLayout.setHorizontalGroup(
            PEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PEliminarLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PEliminarLayout.setVerticalGroup(
            PEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtEnfe.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtEnfe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        txtEnfe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtEnfeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEnfeMouseExited(evt);
            }
        });
        txtEnfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnfeActionPerformed(evt);
            }
        });
        txtEnfe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEnfeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtIdE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(PGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEnfe, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDire, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelA, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 200, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIdE, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cmbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(txtDire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEnfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(PBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomMouseEntered
        Color myColor = new Color(133,220,243);
        txtNom.setBackground(myColor);
        txtNom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_txtNomMouseEntered

    private void txtNomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomMouseExited
        txtNom.setBackground(null);
        txtNom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_txtNomMouseExited

    private void txtNomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtApe.requestFocus();
        }
    }//GEN-LAST:event_txtNomKeyPressed

    private void txtApeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApeMouseEntered
        txtApe.setSize(220, 22);
        Color myColor = new Color(133,220,243);
        txtApe.setBackground(myColor);
        txtApe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_txtApeMouseEntered

    private void txtApeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApeMouseExited
        txtApe.setSize(217, 20);
        txtApe.setBackground(null);
        txtApe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_txtApeMouseExited

    private void txtApeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtDire.requestFocus();
    }//GEN-LAST:event_txtApeKeyPressed
    }
    private void txtDireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireMouseEntered
        txtDire.setSize(310, 22);
        Color myColor = new Color(133,220,243);
        txtDire.setBackground(myColor);
        txtDire.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_txtDireMouseEntered

    private void txtDireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireMouseExited
        txtDire.setSize(300, 20);
        txtDire.setBackground(null);
        txtDire.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_txtDireMouseExited

    private void txtDireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireActionPerformed

    private void txtDireKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtTel.requestFocus();
    }//GEN-LAST:event_txtDireKeyPressed
    }
    private void txtTelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelMouseEntered
        txtTel.setSize(120, 22);
        Color myColor = new Color(133,220,243);
        txtTel.setBackground(myColor);
        txtTel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_txtTelMouseEntered

    private void txtTelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelMouseExited
        txtTel.setSize(110, 20);
        txtTel.setBackground(null);
        txtTel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_txtTelMouseExited

    private void txtTelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtTelA.requestFocus();
    }//GEN-LAST:event_txtTelKeyPressed
    }
    private void txtTelAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelAMouseEntered
        txtTelA.setSize(120, 22);
        Color myColor = new Color(133,220,243);
        txtTelA.setBackground(myColor);
        txtTelA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_txtTelAMouseEntered

    private void txtTelAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelAMouseExited
        txtTelA.setSize(110, 20);
        txtTelA.setBackground(null);
        txtTelA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_txtTelAMouseExited

    private void txtTelAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelAKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cmbSexo.requestFocus();
        }
    }//GEN-LAST:event_txtTelAKeyPressed

    private void txtEdadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadMouseEntered
        txtEdad.setSize(61, 22);
        Color myColor = new Color(133,220,243);
        txtEdad.setBackground(myColor);
        txtEdad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_txtEdadMouseEntered

    private void txtEdadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadMouseExited
        txtEdad.setSize(51, 20);
        txtEdad.setBackground(null);
        txtEdad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_txtEdadMouseExited

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtEdadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtEnfe.requestFocus();
        }
    }//GEN-LAST:event_txtEdadKeyPressed

    private void txtUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseEntered
        txtUser.setSize(150, 22);
        Color myColor = new Color(133,220,243);
        txtUser.setBackground(myColor);
        txtUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_txtUserMouseEntered

    private void txtUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseExited
        txtUser.setSize(140, 20);
        txtUser.setBackground(null);
        txtUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_txtUserMouseExited

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            foto.requestFocus();
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void cmbSexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbSexoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtEdad.requestFocus();
        }
    }//GEN-LAST:event_cmbSexoKeyPressed

    private void cmbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbActivoActionPerformed
        String activo = cmbActivo.getSelectedItem().toString();
    switch(activo) {
           
           case "1": Table.setVisible(true); listarClientesActivos(); break;
           case "0":  Table.setVisible(true); listarClientesInactivos(); break;
           case "Activo": Table.setVisible(false); break;
           
       }
    }//GEN-LAST:event_cmbActivoActionPerformed

    private void fotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoMouseEntered
        foto.setOpaque(true);
        foto.setSize(215, 205);
    }//GEN-LAST:event_fotoMouseEntered

    private void fotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoMouseExited
        foto.setOpaque(false);
        foto.setSize(210, 200);
    }//GEN-LAST:event_fotoMouseExited

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
      dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        btnCerrar.setBackground(Color.red);
        Cerrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        btnCerrar.setBackground(new Color(51,255,255));
        Cerrar.setForeground(null);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void PModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PModificarMouseClicked
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        String sql = "";
        int id = Integer.parseInt(txtIdE.getText());
        String nom = txtNom.getText();
        String ape = txtApe.getText();
        String dire = txtDire.getText();
        String Tel = txtTel.getText();
        String TelA = txtTelA.getText();
        String sexo = cmbSexo.getSelectedItem().toString();
        String edad = txtEdad.getText();
        byte[] imagen = foto.getBytes();
        String user = txtUser.getText();
        String enfe= txtEnfe.getText();

        sql = "UPDATE Clientes SET Nombre=?, Apellidos=?, Direccion=?, Telefono=?, Tel_Adicional=?, Sexo=?, Edad=?, FechaDeIngreso=GETDATE(), Fotografia=?, UserName=?, activo=1, Enfermedad=? WHERE Id_Cliente=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, ape);
            pst.setString(3, dire);
            pst.setString(4, Tel);
            pst.setString(5, TelA);
            pst.setString(6, sexo);
            pst.setString(7, edad);
            pst.setBytes(8, imagen);
            pst.setString(9, user);
            pst.setString(10, enfe);
            pst.setInt(11, id);

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Modificado con exito!");
            }
            listarClientesActivos();
            Limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PModificarMouseClicked
void Limpiar(){
        txtIdE.setText("");
        txtNom.setText("");
        txtApe.setText("");
        txtDire.setText("");
        txtTel.setText("");
        txtTelA.setText("");
        cmbSexo.setSelectedItem("Sexo");
        txtEdad.setText("");
        foto.setImagen("");
        txtUser.setText("");
        txtEnfe.setText("");

}
    private void PModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PModificarMouseEntered
        Color myColor = new Color(133,220,243);
        PModificar.setBackground(myColor);
    }//GEN-LAST:event_PModificarMouseEntered

    private void PModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PModificarMouseExited
        PModificar.setBackground(null);
    }//GEN-LAST:event_PModificarMouseExited

    private void PGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PGuardarMouseClicked
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        String sql = "";
        String nom = txtNom.getText();
        String ape = txtApe.getText();
        String dire = txtDire.getText();
        String Tel = txtTel.getText();
        String TelA = txtTelA.getText();
        String sexo = cmbSexo.getSelectedItem().toString();
        int edad = Integer.parseInt(txtEdad.getText());
        byte[] imagen = foto.getBytes();
        String user = txtUser.getText();
        String enfe= txtEnfe.getText();

        sql = "INSERT INTO Clientes (Nombre,Apellidos,Direccion,Telefono,Tel_Adicional,Sexo,Edad,FechaDeIngreso,Fotografia,UserName,activo,Enfermedad) VALUES (?,?,?,?,?,?,?,GETDATE(),?,?,1,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, ape);
            pst.setString(3, dire);
            pst.setString(4, Tel);
            pst.setString(5, TelA);
            pst.setString(6, sexo);
            pst.setInt(7, edad);
            pst.setBytes(8, imagen);
            pst.setString(9, user);
            pst.setString(10, enfe);
            

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado con exito!");
            }
            listarClientesActivos();
            Limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PGuardarMouseClicked

    private void PGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PGuardarMouseEntered

        Color myColor = new Color(133,220,243);
        PGuardar.setBackground(myColor);
    }//GEN-LAST:event_PGuardarMouseEntered

    private void PGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PGuardarMouseExited
        PGuardar.setBackground(null);
    }//GEN-LAST:event_PGuardarMouseExited

    private void PBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PBuscarMouseClicked
        try {
            Color myColor = new Color(153,255,255);
            Table.setBackground(myColor);
            Table.getTableHeader().setBackground(myColor);
            Table.getTableHeader().setForeground(Color.black);
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setRowCount(0);

            ResultSetMetaData rsmd;
            int colu;
            int User = Integer.parseInt(txtUser.getText());
            Conexion cc = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection cn = cc.Conexion();

            ps = cn.prepareStatement("SELECT Nombre,Apellidos,Direccion,Telefono,FechaDeIngreso,UserName,activo FROM Clientes WHERE UserName=?");
            ps.setInt(1, User);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            colu = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[colu];
                for(int indice=0; indice<colu; indice++){
                    fila[indice] = rs.getString(indice + 1);
                }
                model.addRow(fila);

                Table.setModel(model);

            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());

        }
    }//GEN-LAST:event_PBuscarMouseClicked

    private void PBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PBuscarMouseEntered
        Color myColor = new Color(133,220,243);
        PBuscar.setBackground(myColor);
    }//GEN-LAST:event_PBuscarMouseEntered

    private void PBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PBuscarMouseExited
        PBuscar.setBackground(null);
    }//GEN-LAST:event_PBuscarMouseExited

    private void PEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEliminarMouseClicked
        String sql = "";
        String Activo = txtUser.getText();

        sql = "UPDATE Clientes SET activo=0 WHERE UserName=?";

        try {
            Conexion cc = new Conexion();
            Connection cn = cc.Conexion();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, Activo);

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado con exito!");
            }

            listarClientesActivos();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }//GEN-LAST:event_PEliminarMouseClicked

    private void PEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEliminarMouseEntered
        Color myColor = new Color(133,220,243);
        PEliminar.setBackground(myColor);
    }//GEN-LAST:event_PEliminarMouseEntered

    private void PEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEliminarMouseExited
        PEliminar.setBackground(null);
    }//GEN-LAST:event_PEliminarMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
         try {
            int fila = Table.getSelectedRow();
            int User = Integer.parseInt(Table.getValueAt(fila, 5).toString());
            
            Conexion cc = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection cn = cc.Conexion();

            ps = cn.prepareStatement("SELECT Id_Cliente,Nombre,Apellidos,Direccion,Telefono,Tel_Adicional,Sexo,Edad,Fotografia,UserName,Enfermedad FROM Clientes WHERE UserName=?");
            ps.setInt(1, User);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                txtIdE.setText(rs.getString("Id_Cliente"));
                txtNom.setText(rs.getString("Nombre"));
                txtApe.setText(rs.getString("Apellidos"));
                txtDire.setText(rs.getString("Direccion"));
                txtTel.setText(rs.getString("Telefono"));
                txtTelA.setText(rs.getString("Tel_Adicional"));
                cmbSexo.setSelectedItem(rs.getString("Sexo"));
                txtEdad.setText(rs.getString("Edad"));
                byte[] imagen = rs.getBytes("Fotografia");
                foto.setImagen(imagen);
                txtUser.setText(String.valueOf(User));
                txtEnfe.setText(rs.getString("Enfermedad"));
                
               
            }
        } catch (SQLException ex) {
    JOptionPane.showConfirmDialog(null, ex.toString());
        
        }
    }//GEN-LAST:event_TableMouseClicked

    private void txtEnfeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEnfeMouseEntered
        txtEnfe.setSize(310, 22);
        Color myColor = new Color(133,220,243);
        txtEnfe.setBackground(myColor);
        txtEnfe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
    
    }//GEN-LAST:event_txtEnfeMouseEntered

    private void txtEnfeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEnfeMouseExited
        txtEnfe.setSize(300, 20);
        txtEnfe.setBackground(null);
        txtEnfe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
    
    }//GEN-LAST:event_txtEnfeMouseExited

    private void txtEnfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnfeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnfeActionPerformed

    private void txtEnfeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnfeKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtUser.requestFocus();
        }
    }//GEN-LAST:event_txtEnfeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel PBuscar;
    private javax.swing.JPanel PEliminar;
    private javax.swing.JPanel PGuardar;
    private javax.swing.JPanel PModificar;
    private javax.swing.JTable Table;
    private javax.swing.JPanel btnCerrar;
    private javax.swing.JComboBox<String> cmbActivo;
    private javax.swing.JComboBox<String> cmbSexo;
    private JPanelWebCam.JPanelWebCam foto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtDire;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEnfe;
    private javax.swing.JTextField txtIdE;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTelA;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
