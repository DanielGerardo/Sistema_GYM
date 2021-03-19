/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

import static com.danielcampos.redgym.proyecto.Menu.IconControl;
import static com.danielcampos.redgym.proyecto.Menu.Menu1;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Dimension;
import com.itextpdf.text.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.danielcampos.redgym.proyecto.Menu.PanelGuardar;
import static com.danielcampos.redgym.proyecto.Menu.IconGuardar;
import static com.danielcampos.redgym.proyecto.Menu.PanelControl;

/**
 *
 * @author Daniel Gerardo Campos García
 * Class JInternalFrame Imprimir se crea para visualizar las ventas de las fechas ingresadas y se crea un PDF de las ventas
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 * Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 * 
 * 
 */
public class Imprimir extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    double suma;
    double totalPagarVentas;
    double precio;
    double monto;
    double totalPagarPlanes;

    public Imprimir() {
        initComponents();
        setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    void cargarTablaClientesPlanes(String valor) {
        Date fe = calen.getDate();
        long fec = fe.getTime();
        java.sql.Date fee = new java.sql.Date(fec);
        Color myColor = new Color(255, 255, 255);
        tablaClientesPlan.setBackground(myColor);
        tablaClientesPlan.getTableHeader().setBackground(new Color(0, 102, 204));
        tablaClientesPlan.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 14));
        tablaClientesPlan.getTableHeader().setForeground(new Color(255, 255, 255));
        tablaClientesPlan.getTableHeader().setOpaque(false);
        tablaClientesPlan.getTableHeader().setEnabled(false);
        String[] titulos = {"id_Entrenador", "Id_Cliente", "Id_Plan", "FechaCompra", "Monto"};
        String[] registros = new String[5];
        model = new DefaultTableModel(null, titulos);

        PreparedStatement ps;
        ResultSet rs;
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();

        try {
            ps = cn.prepareStatement("SELECT * FROM ClientePlan WHERE FechaCompra=?");
            ps.setDate(1, fee);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("Id_Entrenador");
                registros[1] = rs.getString("Id_Cliente");
                registros[2] = rs.getString("Id_Plan");
                registros[3] = rs.getString("FechaCompra");
                registros[4] = rs.getString("Monto");

                model.addRow(registros);
            }
            tablaClientesPlan.setModel(model);
            calcularTotalVendido();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    void cargarTablaVentas(String valor) {
        Date fe = calen.getDate();
        long fec = fe.getTime();
        java.sql.Date fee = new java.sql.Date(fec);
        Color myColor = new Color(255, 255, 255);
        tablaVentas.setBackground(myColor);
        tablaVentas.getTableHeader().setBackground(new Color(0, 102, 204));
        tablaVentas.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 14));
        tablaVentas.getTableHeader().setForeground(new Color(255, 255, 255));
        tablaVentas.getTableHeader().setOpaque(false);
        tablaVentas.getTableHeader().setEnabled(false);
        String[] titulos = {"Id_Entrenador", "NumeroVenta", "FechaVenta", "Monto"};
        String[] registros = new String[4];
        model = new DefaultTableModel(null, titulos);

        PreparedStatement ps;
        ResultSet rs;
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();

        try {
            ps = cn.prepareStatement("SELECT * FROM Ventas WHERE FechaVenta=?");
            ps.setDate(1, fee);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("Id_Entrenador");
                registros[1] = rs.getString("NumeroVenta");
                registros[2] = rs.getString("FechaVenta");
                registros[3] = rs.getString("Monto");

                model.addRow(registros);
            }
            tablaVentas.setModel(model);
            calcularTotalVendido();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void crearPDFVentas() throws IOException, DocumentException {
        Date fe = calen.getDate();
        long fec = fe.getTime();
        java.sql.Date fee = new java.sql.Date(fec);
        try {

            File carpetaHaGuardar = new File("C:\\backupsistem\\Ventas");
            if (!carpetaHaGuardar.exists()) {
                carpetaHaGuardar.mkdirs();
            }
            OutputStream file = new FileOutputStream(new File(carpetaHaGuardar.getAbsoluteFile() + "\\" + fee + ".pdf"));
            Document document = new Document();

            Image Imagen = Image.getInstance(this.getClass().getResource("/img/logopx.png"));
            PdfWriter.getInstance(document, file);

            document.open();
            PdfPTable tabla = new PdfPTable(4);
            Paragraph t = new Paragraph("\n\n", FontFactory.getFont("Times New Roman", 20, Font.ITALIC, BaseColor.RED));
            Paragraph p = new Paragraph("Ventas realizadas\n\n", FontFactory.getFont("Times New Roman", 16, Font.ITALIC, BaseColor.BLUE));
            Paragraph f = new Paragraph("FECHA: " + fee, FontFactory.getFont("Times New Roman", 20, Font.ITALIC, BaseColor.BLACK));
            Imagen.setAbsolutePosition(10f, 700f);
            document.add(Imagen);
            f.setAlignment(Element.ALIGN_RIGHT);

            document.add(f);
            t.setAlignment(Element.ALIGN_LEFT);
            document.add(t);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            document.add(new Paragraph(""));

            float[] mediaCeldas = {3.00f, 3.50f, 5.00f, 4.00f};

            tabla.setWidths(mediaCeldas);
            tabla.addCell(new Paragraph("ID Entrenador", FontFactory.getFont("Times New Roman", 12)));
            tabla.addCell(new Paragraph("NumeroVenta", FontFactory.getFont("Times New Roman", 12)));
            tabla.addCell(new Paragraph("FechaVenta", FontFactory.getFont("Times New Roman", 12)));
            tabla.addCell(new Paragraph("Monto", FontFactory.getFont("Times New Roman", 12)));

            for (int i = 0; i < tablaVentas.getRowCount(); i++) {

                tabla.addCell(new Paragraph(tablaVentas.getValueAt(i, 0).toString(), FontFactory.getFont("Times New Roman", 10)));
                tabla.addCell(new Paragraph(tablaVentas.getValueAt(i, 1).toString(), FontFactory.getFont("Times New Roman", 10)));
                tabla.addCell(new Paragraph(tablaVentas.getValueAt(i, 2).toString(), FontFactory.getFont("Times New Roman", 10)));
                tabla.addCell(new Paragraph(tablaVentas.getValueAt(i, 3).toString(), FontFactory.getFont("Times New Roman", 10)));

            }

            document.add(tabla);

            PdfPTable tabla1 = new PdfPTable(5);
            Paragraph p1 = new Paragraph("Contratación de Planes\n\n", FontFactory.getFont("Times New Roman", 16, Font.ITALIC, BaseColor.BLUE));

            p1.setAlignment(Element.ALIGN_CENTER);
            document.add(p1);

            document.add(new Paragraph(""));

            float[] mediaCeldas1 = {5.00f, 3.50f, 5.00f, 4.00f, 4.00f};

            tabla1.setWidths(mediaCeldas1);

            tabla1.addCell(new Paragraph("ID Entrenador", FontFactory.getFont("Times New Roman", 12)));
            tabla1.addCell(new Paragraph("User", FontFactory.getFont("Times New Roman", 12)));
            tabla1.addCell(new Paragraph("ID Plan", FontFactory.getFont("Times New Roman", 12)));
            tabla1.addCell(new Paragraph("FechaVenta", FontFactory.getFont("Times New Roman", 12)));
            tabla1.addCell(new Paragraph("Monto", FontFactory.getFont("Times New Roman", 12)));

            for (int i = 0; i < tablaClientesPlan.getRowCount(); i++) {
                //preci=Double.parseDouble(tablaVentas.getValueAt(i, 4).toString());

                tabla1.addCell(new Paragraph(tablaClientesPlan.getValueAt(i, 0).toString(), FontFactory.getFont("Times New Roman", 10)));
                tabla1.addCell(new Paragraph(tablaClientesPlan.getValueAt(i, 1).toString(), FontFactory.getFont("Times New Roman", 10)));
                tabla1.addCell(new Paragraph(tablaClientesPlan.getValueAt(i, 2).toString(), FontFactory.getFont("Times New Roman", 10)));
                tabla1.addCell(new Paragraph(tablaClientesPlan.getValueAt(i, 3).toString(), FontFactory.getFont("Times New Roman", 10)));
                tabla1.addCell(new Paragraph(tablaClientesPlan.getValueAt(i, 4).toString(), FontFactory.getFont("Times New Roman", 10)));

            }
            document.add(tabla1);
            Paragraph p2 = new Paragraph(" \n", FontFactory.getFont("Times New Roman", 16, Font.ITALIC, BaseColor.BLUE));

            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p2);
            PdfPTable tabla2 = new PdfPTable(2);

            document.add(new Paragraph(""));

            float[] mediaCeldas2 = {17.50f, 4.00f};

            tabla2.setWidths(mediaCeldas2);
            tabla2.addCell(new Paragraph("           Total de Ventas:", FontFactory.getFont("Times New Roman", 12)));
            tabla2.addCell(new Paragraph(txtTotal.getText(), FontFactory.getFont("Times New Roman", 12)));
            document.add(tabla2);
            document.close();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File file = new File("C:\\backupsistem\\Ventas\\" + fee + ".pdf");
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void calcularTotalVendido() {
        suma = 0;
        totalPagarVentas = 0;
        totalPagarPlanes = 0;
        for (int i = 0; i < tablaVentas.getRowCount(); i++) {
            precio = Double.parseDouble(tablaVentas.getValueAt(i, 3).toString());

            totalPagarVentas = totalPagarVentas + (precio);
        }
        for (int i = 0; i < tablaClientesPlan.getRowCount(); i++) {
            monto = Double.parseDouble(tablaClientesPlan.getValueAt(i, 4).toString());

            totalPagarPlanes = totalPagarPlanes + (monto);
        }
        suma = totalPagarVentas + totalPagarPlanes;
        txtTotal.setText("$" + suma);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JPanel();
        Bustxt = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JPanel();
        Imptxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        calen = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientesPlan = new javax.swing.JTable();
        cerrar = new javax.swing.JLabel();
        btnVen = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
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

        Bustxt.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
        Bustxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bustxt.setText("Buscar");

        javax.swing.GroupLayout btnBuscarLayout = new javax.swing.GroupLayout(btnBuscar);
        btnBuscar.setLayout(btnBuscarLayout);
        btnBuscarLayout.setHorizontalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBuscarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Bustxt)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        btnBuscarLayout.setVerticalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bustxt, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        btnImprimir.setBackground(new java.awt.Color(255, 255, 255));
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImprimirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnImprimirMouseExited(evt);
            }
        });

        Imptxt.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
        Imptxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Imptxt.setText("Imprimir");

        javax.swing.GroupLayout btnImprimirLayout = new javax.swing.GroupLayout(btnImprimir);
        btnImprimir.setLayout(btnImprimirLayout);
        btnImprimirLayout.setHorizontalGroup(
            btnImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnImprimirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imptxt)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        btnImprimirLayout.setVerticalGroup(
            btnImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Imptxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        tablaVentas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tablaVentas.setForeground(new java.awt.Color(0, 153, 255));
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaVentas.setEnabled(false);
        tablaVentas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaVentas.setOpaque(false);
        jScrollPane1.setViewportView(tablaVentas);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setDisabledTextColor(new java.awt.Color(0, 153, 255));
        txtTotal.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
        jLabel3.setText("Total de ventas:");

        calen.setForeground(new java.awt.Color(0, 102, 204));
        calen.setToolTipText("");
        calen.setDateFormatString("yyyy-MM-dd");
        calen.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N

        tablaClientesPlan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tablaClientesPlan.setForeground(new java.awt.Color(0, 153, 255));
        tablaClientesPlan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaClientesPlan.setEnabled(false);
        tablaClientesPlan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaClientesPlan.setOpaque(false);
        jScrollPane2.setViewportView(tablaClientesPlan);

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

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Imprimir Ventas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(calen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        cargarTablaClientesPlanes("");
        cargarTablaVentas("");
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        Bustxt.setForeground(new Color(255, 255, 255));
        btnBuscar.setBackground(new Color(0, 153, 255));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        Bustxt.setForeground(new Color(0, 0, 0));
        btnBuscar.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseClicked
        try {
            crearPDFVentas();
        } catch (IOException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirMouseClicked

    private void btnImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseEntered
        Imptxt.setForeground(new Color(255, 255, 255));
        btnImprimir.setBackground(new Color(0, 153, 255));
    }//GEN-LAST:event_btnImprimirMouseEntered

    private void btnImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseExited
        Imptxt.setForeground(new Color(0, 0, 0));
        btnImprimir.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnImprimirMouseExited

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        dispose();
        Color cl = new Color(0, 117, 155);
        PanelControl.setBackground(cl);

        IconControl.setIcon(null);
        PanelControl.setEnabled(true);
    }//GEN-LAST:event_cerrarMouseClicked

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered

        cerrar.setForeground(Color.red);
    }//GEN-LAST:event_cerrarMouseEntered

    private void cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseExited
        cerrar.setForeground(Color.black);
    }//GEN-LAST:event_cerrarMouseExited

    private void btnVenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenMouseClicked
        dispose();
        EntradasYSalidas cn = new EntradasYSalidas();
        centrarVentana(cn);
    }//GEN-LAST:event_btnVenMouseClicked

    private void btnVenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenMouseEntered
        btnVen.setBackground(new Color(0, 102, 204));
    }//GEN-LAST:event_btnVenMouseEntered

    private void btnVenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenMouseExited
        btnVen.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnVenMouseExited
    void centrarVentana(JInternalFrame frame) {

        Menu1.add(frame);
        Dimension dimension = Menu1.getSize();
        Dimension Dframe = frame.getSize();
        frame.setLocation((dimension.width - Dframe.width) / 2, (dimension.height - Dframe.height));
        frame.show();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bustxt;
    private javax.swing.JLabel Imptxt;
    private javax.swing.JPanel btnBuscar;
    private javax.swing.JPanel btnImprimir;
    private javax.swing.JPanel btnVen;
    private com.toedter.calendar.JDateChooser calen;
    public static javax.swing.JLabel cerrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tablaClientesPlan;
    public static javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
