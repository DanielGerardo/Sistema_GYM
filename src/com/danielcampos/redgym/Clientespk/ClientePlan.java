/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.Clientespk;

/**
 *
 * @author Daniel Gerardo Campos García 
 * Class constructor para el plan
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 */
public class ClientePlan {
    int id;
    int user;
    String idC;
    int idP;
    String fechaCompra;
    String fechaVencimiento;
    int uti;
    double precio;

    public ClientePlan() {
    }

    public ClientePlan(int id, int user, String idC, int idP, String fechaC, String fechaV, int uti, double precio) {
        this.id = id;
        this.user = user;
        this.idC = idC;
        this.idP = idP;
        this.fechaCompra = fechaC;
        this.fechaVencimiento = fechaV;
        this.uti = uti;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getUti() {
        return uti;
    }

    public void setUti(int uti) {
        this.uti = uti;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
