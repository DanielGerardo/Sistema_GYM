/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.Clientespk;

import com.danielcampos.redgym.proyecto.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.danielcampos.redgym.proyecto.PlanesClientes;
import static com.danielcampos.redgym.proyecto.PlanesClientes.txtCompra;
import static com.danielcampos.redgym.proyecto.PlanesClientes.txtDias;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import static java.time.temporal.ChronoUnit.DAYS;
import static com.danielcampos.redgym.proyecto.PlanesClientes.txtFechaAnterior;

/**
 *
 * @author Daniel Gerardo Campos García Class para Data Access Object (DAO)
 * proporcionará los métodos Variables: Excritura de camello abreviando su tipo
 * de componente seguido de su nombre de variable Metodos: Exritura de camello
 * (El nombre debe se ser sacado de la funcion que tiene el metodo)
 *
 */
public class ClientesDAO {

    String r = "";
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    Connection con;
    int rr = 0;

    /**
     * La Fecha debe de tener el formato yyyy-MM-dd
     *
     * @param inicio Se agrega la fecha inicial a calcular
     * @param fin Se agrega la fecha final para calcular los dias que pasan
     * entre la fecha inicio y la fecha final
     * @return
     */
    public String calcularDias(String inicio, String fin) {

        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFinal = LocalDate.parse(fin);

        long periodo = DAYS.between(fechaInicio, fechaFinal);

        if (periodo < 0) {
            periodo = 0;
            txtDias.setText(String.valueOf(periodo));
        } else {
            txtDias.setText(String.valueOf(periodo));
        }
        return r;

    }

    public int guardarPlan(ClientePlan v) {
        ClientePlan ClientePlan = new ClientePlan();
        String sql = "INSERT INTO ClientePlan(id_Entrenador,Id_Cliente,Id_Plan,FechaCompra,FechaVencimiento,monto) Values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, v.getUser());
            ps.setString(2, v.getIdC());
            ps.setInt(3, v.getIdP());
            ps.setString(4, v.getFechaCompra());
            ps.setString(5, v.getFechaVencimiento());
            ps.setDouble(6, v.getPrecio());
            rr = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            JOptionPane.showMessageDialog(null, "Error de conexion" + e);
        }
        return rr;

    }

}
