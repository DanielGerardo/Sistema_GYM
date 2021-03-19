/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

/**
 *
 * @author Daniel Gerardo Campos García 
 * Class constructor para el DetalleVentas
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 */
public class DetalleVentas {
    int id;
    int idPro;
    int idVenta;
    String unidad;
    int cantidad;
    double preventa;

    public DetalleVentas() {
    }

    public DetalleVentas(int id, int idPro, int idVenta, String unidad, int cantidad, double preventa) {
        this.id = id;
        this.idPro = idPro;
        this.idVenta = idVenta;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.preventa = preventa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreventa() {
        return preventa;
    }

    public void setPreventa(double preventa) {
        this.preventa = preventa;
    }
    
}
