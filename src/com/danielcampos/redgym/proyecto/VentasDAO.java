/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

import java.sql.Connection;
/**
 *
 * @author Daniel Gerardo Campos García 
 * Class Ventas Data Access Object (DAO) proporcionará los métodos 
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable 
 * Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 *
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VentasDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn=new Conexion();
    Connection con;
    int r=0;
    
    /**
     * Busca el valor mas alto de la columna NumeroVentas de la tabla Ventas DB 
     * @return 
     */
    public String serieVenta(){
        String serie="";
        String sql="SELECT MAX(NumeroVenta) FROM Ventas";
        try{
             con=cn.Conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next())
            serie=rs.getString(1);
     } catch (Exception e) {
         
     }
     return serie;
    }
        
    /**
     * Busca el valor mas alto de la columna Id_Venta de la tabla Ventas DB 
     * @return 
     */
    public String IdVentas(){
     String idv="";
     String sql="SELECT MAX(Id_Venta) FROM Ventas";
     try {
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next())
            idv=rs.getString(1);
     } catch (Exception e) {
         
     }
     return idv;
    }
    public int GuardarVentas(Venta v){
        Venta Venta=new Venta();
        String sql="INSERT INTO Ventas(Id_Entrenador,NumeroVenta,FechaVenta,Monto,Estado) Values (?,?,GETDATE(),?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareCall(sql);
            ps.setInt(1, v.getIdEntrenador());
            ps.setString(2, v.getSerie());
            ps.setDouble(3, v.getMonto());
            ps.setString(4, v.getEstado());
            r=ps.executeUpdate();
        } catch (Exception e){
        }
        return r;
    }
    public int GuardarDetalleVentas(DetalleVentas dv){
        
        String sql="INSERT INTO VentasDetalle(Id_Venta,Id_Producto,Unidad,Cantidad,PrecioVenta) Values (?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVenta());
            ps.setInt(2, dv.getIdPro());
            ps.setString(3, dv.getUnidad());
            ps.setInt(4, dv.getCantidad());
            ps.setDouble(5, dv.getPreventa());
            ps.executeUpdate();
        } catch (Exception e){
        }
        return r;
    }
}
