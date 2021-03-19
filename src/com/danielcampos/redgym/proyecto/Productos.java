package com.danielcampos.redgym.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Productos {

    int id;
    String des;
    String unidad;
    int can;
    double precio;
    String fecha;

    public Productos() {
    }

    public Productos(int id, String des, String unidad, int can, double precio, String fecha) {
        this.id = id;
        this.des = des;
        this.unidad = unidad;
        this.can = can;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return this.des;
    }

    public Vector<Productos> mostrarProducto() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con = new Conexion();
        Connection acceso;

        Vector<Productos> datos = new Vector<Productos>();
        Productos dat = null;

       
        try {
            acceso = con.Conexion();
            String sql = "SELECT * FROM Productos";
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            dat = new Productos();
            dat.setId(0);
            dat.setDes("Selecciona Producto");
            dat.setUnidad("");
            dat.setCan(3);
            dat.setPrecio(4);
            datos.add(dat);
            
            while (rs.next()) {
                dat = new Productos();
                dat.setId(rs.getInt("Id_Producto"));
                dat.setDes(rs.getString("Descripcion"));
                dat.setUnidad(rs.getString("Unidad"));
                dat.setCan(rs.getInt("Cantidad"));
                dat.setPrecio(rs.getDouble("Precio"));
                datos.add(dat);

            }
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
            JOptionPane.showMessageDialog(null, "Error de conexion" + ex);

        }
        return datos;
    }

}
