 
package com.danielcampos.redgym.proyecto;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Daniel Gerardo Campos García 
 * Class Conexion hacia la BD SQLServer 2019 en modo local
 * Variables: Excritura de camello abreviando su tipo de componente seguido de su nombre de variable
 */
public class Conexion {
   Connection acceso = null;
    public Connection Conexion(){
       
       
       try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        acceso = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=GYM;user=da;password=1234;");
        
       }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error de conexion");
            JOptionPane.showMessageDialog(null, "Error de conexion" + ex);
     
     
        }
        return acceso;
    }    

    
    
}

