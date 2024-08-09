/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import conexion.Conexion;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RDanone
 */
public class Funciones {
    
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    
    public static boolean isRegister(Sentencias s){
        String sql = Sentencias.REGISTRAR;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getNome());
            ps.setString(2, s.getUsuario());
            ps.setString(3, s.getSenha());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isUpdate (Sentencias s){
        String sql = Sentencias.ACTUALIZAR;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getNome());
            ps.setString(2, s.getUsuario());
            ps.setString(3, s.getSenha());
            ps.setString(4, s.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isDelete (Sentencias s){
        String sql = Sentencias.ELIMINAR;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isTruncate (){
        String sql = Sentencias.ELIMINAR_TODO;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setListar(String buscar){
        DefaultTableModel modelo = (DefaultTableModel)Janela.tabla.getModel();
        
        while(modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
        
        String sql = "";
        
        if(buscar.equals("")){
            sql = Sentencias.LISTAR;
        }else{
            sql = "SELECT * FROM usuarios WHERE ("
                    + "id LIKE'%"+buscar+"%' OR "
                    + "nome LIKE'%"+buscar+"%' OR "
                    + "usuario LIKE'%"+buscar+"%' OR "
                    + "senha LIKE'"+buscar+"%'"
                    + ")";
        }
        
        String datos[] = new String[4]; 
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("nome");
                datos[2] = rs.getString("usuario");
                datos[3] = rs.getString("senha");
                modelo.addRow(datos);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public static String extraerIDMax(){
        String sql = "SELECT MAX(id)AS valor FROM usuarios";
        int id = 0;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt("valor");
            }
            
            if(id==0){
                id = 1;
            }else{
                id = id + 1;
            }
            
            return String.valueOf(id);
        } catch (SQLException ex) {
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
