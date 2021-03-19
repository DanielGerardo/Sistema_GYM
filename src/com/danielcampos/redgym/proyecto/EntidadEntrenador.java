/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielcampos.redgym.proyecto;


import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;








/**
 *
 * @author Daniel Gerardo Campos García 
 * Class constructor para el EntidadEntrenador
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 */

public class EntidadEntrenador  {
    int idE;
    String nom;
    String apellido;
    String dire;
    int tel;
    int telA;
    String sexo;
    int edad;
    String fecha;
    Image foto;
    String User;
    String Pass;
    int activo;
   
    public EntidadEntrenador() {

} 
    public EntidadEntrenador(int idE,String nom,String apellido,String dire, int tel,int telA,String sexo, int edad,String fecha, Image foto, String User, String Pass, int activo){
        this.idE = idE;
        this.nom = nom;
        this.apellido = apellido;
        this.dire = dire;
        this.tel = tel;
        this.telA = telA;
        this.sexo = sexo;
        this.edad = edad;
        this.fecha = fecha;
        this.foto = foto;
        this.User = User;
        this.Pass = Pass;
        this.activo = activo;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdEn(int idE) {
        this.idE = idE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getTelA() {
        return telA;
    }

    public void setTelA(int telA) {
        this.telA = telA;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        this.User = user;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        this.Pass = pass;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
   public String toString(){
       return this.nom ;
   }
    
    public Vector<EntidadEntrenador> mostrarEntrenador() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con = new Conexion();
        Connection acceso;

        Vector<EntidadEntrenador> datos = new Vector<EntidadEntrenador>();
        EntidadEntrenador dat = null;

       
        try {
            acceso = con.Conexion();
            String sql = "SELECT * FROM Entrenador WHERE activo=1";
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            dat = new EntidadEntrenador();
            dat.setIdEn(0);
            dat.setNom("Selecciona Entrenador");
            datos.add(dat);
            
            while (rs.next()) {
                dat = new EntidadEntrenador();
                dat.setIdEn(rs.getInt("Id_Entrenador"));
                dat.setNom(rs.getString("Nombre"));
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

