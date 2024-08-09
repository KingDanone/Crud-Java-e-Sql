/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author RDanone
 */
public class Sentencias {
    public static String LISTAR = "SELECT * FROM usuarios";
    public static String REGISTRAR = "INSERT INTO usuarios("
           + "nome,"
           + "usuario,"
           + "senha) "
           + "VALUES(?,?,?)";

   public static String ACTUALIZAR = "UPDATE usuarios SET "
           + "nome = ?,"
           + "usuario = ?,"
           + "senha = ?"
           + "WHERE id = ?";
   public static String ELIMINAR = "DELETE FROM usuarios WHERE id = ?";

   public static String ELIMINAR_TODO = "TRUNCATE TABLE usuarios";
   
   private String id;
   private String nome;
   private String usuario;
   private String senha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    String getnome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getusuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getsenha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
   
}