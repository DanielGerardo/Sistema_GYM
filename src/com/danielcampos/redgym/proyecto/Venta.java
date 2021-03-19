/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;

/**
 *
 * @author Daniel Gerardo Campos García 
 * Class constructor para el Venta
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 */
public class Venta {
    int id;
    int idEntrenador;
    String serie;
    String fecha;
    double monto;
    String estado;

    public Venta() {
    }

    public Venta(int id, int idEntrenador, String serie, String fecha, double monto, String estado) {
        this.id = id;
        this.idEntrenador = idEntrenador;
        this.serie = serie;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
