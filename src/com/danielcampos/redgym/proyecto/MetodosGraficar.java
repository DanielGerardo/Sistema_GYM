/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author pc
 */
public interface MetodosGraficar {

    public static java.sql.Date getFecha(JDateChooser fecha) {
        Date jDI = fecha.getDate();
        long long_fechaI = jDI.getTime();
        java.sql.Date fechaInicio = new java.sql.Date(long_fechaI);
        return fechaInicio;
    }

    public static void graficaBarras(Date fechaInicio, Date fechafin) {

        String[] sumaVentas = new String[4];
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        PreparedStatement ps;
        ResultSet rs;
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();

        try {
            ps = cn.prepareStatement("SELECT CAST(FechaVenta AS DATE) as fecha , SUM( Monto) as monto "
                    + "FROM Ventas WHERE FechaVenta BETWEEN '" + fechaInicio + "' and '" + fechafin + "' "
                    + "GROUP BY CAST(FechaVenta AS DATE)");
            rs = ps.executeQuery();

            while (rs.next()) {

                sumaVentas[0] = rs.getString("fecha");
                sumaVentas[1] = rs.getString("monto");
                double montoVenta = Double.parseDouble(sumaVentas[1]);
                dataset.addValue(montoVenta, "Productos", sumaVentas[0]);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            ps = cn.prepareStatement("SELECT CAST(FechaCompra AS DATE) as fechaPlan , SUM( Monto) as montoPlan "
                    + "FROM ClientePlan WHERE FechaCompra BETWEEN '" + fechaInicio + "' and '" + fechafin + "' "
                    + "GROUP BY CAST(FechaCompra AS DATE)");
            rs = ps.executeQuery();

            while (rs.next()) {

                sumaVentas[2] = rs.getString("fechaPlan");
                sumaVentas[3] = rs.getString("montoPlan");
                double montoPlan = Double.parseDouble(sumaVentas[3]);
                dataset.addValue(montoPlan, "Planes", sumaVentas[2]);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Ventas",
                "Fecha de Ventas",
                "Monto Vendido",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
        barChart.setBorderVisible(false);
        ChartPanel panel = new ChartPanel(barChart);
        panel.setPreferredSize(new java.awt.Dimension(560, 367));

        JFrame ventana = new JFrame("Grafica Ventas");
        ventana.setVisible(true);
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        ventana.add(panel);

    }

    public static void graficaBarrasVencimiento(Date fechaInicio, Date fechafin) {

        String[] Vencimientos = new String[3];
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        PreparedStatement ps;
        ResultSet rs;
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();

        try {
            ps = cn.prepareStatement("SELECT CAST( Sexo AS varchar) as sexo,CAST( fechaPlan AS DATE) as fecha,COUNT( Id_Cliente ) as total "
                    + "FROM Clientes where fechaPlan BETWEEN '" + fechaInicio + "' and '" + fechafin + "' "
                    + "GROUP BY CAST( Sexo AS varchar ),CAST( fechaPlan AS DATE )");
            rs = ps.executeQuery();

            while (rs.next()) {

                Vencimientos[0] = rs.getString("fecha");
                Vencimientos[1] = rs.getString("sexo");
                Vencimientos[2] = rs.getString("total");
                double total = Double.parseDouble(Vencimientos[2]);
                dataset.addValue(total, Vencimientos[1], Vencimientos[0]);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Vencimientos",
                "Fecha de Ventas",
                "Cantidad Vencimientos",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
        barChart.setBorderVisible(false);
        ChartPanel panel = new ChartPanel(barChart);
        panel.setPreferredSize(new java.awt.Dimension(560, 367));

        JFrame ventana = new JFrame("Grafica Vencimientos");
        ventana.setVisible(true);
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        ventana.add(panel);

    }

    public static void productosMasVendidos(Date fechaInicio, Date fechaFin) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;

        String[] registros = new String[5];
        try {
            ps = cn.prepareStatement("SELECT CAST(Id_Producto as int) as productos , SUM(Cantidad) as cantidad,SUM(PrecioVenta) as monto "
                    + "FROM VentasDetalle WHERE FechaVenta BETWEEN '" + fechaInicio + "' and '" + fechaFin + "' "
                    + "GROUP BY CAST(Id_Producto as int)");
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("productos");
                registros[1] = rs.getString("cantidad");
                int montoPlan = Integer.parseInt(registros[1]);
                dataset.setValue(registros[0], montoPlan);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        JFreeChart barChart = ChartFactory.createPieChart(
                "Productos más Vendidos",
                dataset,
                true, true, false);
        barChart.setBorderVisible(false);
        ChartPanel panel = new ChartPanel(barChart);
        panel.setPreferredSize(new java.awt.Dimension(560, 367));

        JFrame ventana = new JFrame("Grafica Productos");
        ventana.setVisible(true);
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventana.add(panel);
    }

    public static void graficaBarrasEntrasYSalidas(Date fechaInicio, Date fechafin) {

        String[] Vencimientos = new String[2];
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        PreparedStatement ps;
        ResultSet rs;
        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();

        try {
            ps = cn.prepareStatement("SELECT CAST( fechahoy AS DATE) as fecha,COUNT( id_entradas ) as total "
                    + "FROM Entradas where fechahoy BETWEEN '" + fechaInicio + "' and '" + fechafin + "' "
                    + "GROUP BY CAST( fechahoy AS DATE )");
            rs = ps.executeQuery();

            while (rs.next()) {

                Vencimientos[0] = rs.getString("fecha");
                Vencimientos[1] = rs.getString("total");
                double total = Double.parseDouble(Vencimientos[1]);
                dataset.addValue(total, "", Vencimientos[0]);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Entradas y Salidas",
                "Fechas",
                "Cantidad  de E y S",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
        barChart.setBorderVisible(false);
        ChartPanel panel = new ChartPanel(barChart);
        panel.setPreferredSize(new java.awt.Dimension(560, 367));

        JFrame ventana = new JFrame("Grafica Entradas y Salidas");
        ventana.setVisible(true);
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        ventana.add(panel);

    }

}
