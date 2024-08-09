/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RDanone
 */
public class Conexion {

    public static Connection conection = null;

    public Connection getConexion(){
       
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_java", "root", "7422");
            return conection;
        }catch (ClassNotFoundException | SQLException ex) {
            return null;
    //       Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}