
package com.danielcampos.redgym.Clientespk;

import com.danielcampos.redgym.proyecto.Conexion;
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
 * Class para agregar EntidadClientes Contructor
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 * Metodos: Exritura de camello (El nombre debe se ser sacado de la funcion que tiene el metodo)
 * 
 */
public class EntidadClientes {
    
    int id;
    String nom;
    String ape;
    String dire;
    int tel;
    int telA;
    String sexo;
    int edad;
    String fecha;
    Image foto;
    String user;
    int activo;
    String fplan;
    
    public EntidadClientes() {
    }

    public EntidadClientes(int id, String nom, String ape, String dire, int tel, int telA, String sexo, int edad, String fecha, Image foto, String user, int activo, String fplan) {
        this.id = id;
        this.nom = nom;
        this.ape = ape;
        this.dire = dire;
        this.tel = tel;
        this.telA = telA;
        this.sexo = sexo;
        this.edad = edad;
        this.fecha = fecha;
        this.foto = foto;
        this.user = user;
        this.activo = activo;
        this.fplan = fplan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
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
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFplan() {
        return fplan;
    }

    public void setFplan(String fplan) {
        this.fplan = fplan;
    }

    

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
 
   
   public String toString(){
    return this.user;
   }
   
   
   public Vector<EntidadClientes> mostrarCliente() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con = new Conexion();
        Connection acceso;

        Vector<EntidadClientes> datos = new Vector<EntidadClientes>();
        EntidadClientes dat = null;

       
        try {
            acceso = con.Conexion();
            String sql = "SELECT * FROM Clientes WHERE activo=1";
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            dat = new EntidadClientes();
            dat.setId(0);
            dat.setNom("");
            dat.setUser("Selecciona Cliente");
            dat.setFplan("");
            datos.add(dat);
            
            while (rs.next()) {
                dat = new EntidadClientes();
                dat.setId(rs.getInt("Id_Cliente"));
                dat.setNom(rs.getString("Nombre"));
                dat.setUser(rs.getString("UserName"));
                dat.setFplan(rs.getString("fechaPlan"));
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
