
package DAO;

import VO.Accesos;
import VO.Usuario;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JEAR
 */
public class UsuariosDAO {
     public static Connection conn;
    public DefaultTableModel usuariosListar(){
        String[] titulo={"ID","IDENTIFICACION","NOMBRE","TIPO","CORREO","CONTRASEÑA"};
        DefaultTableModel model = new DefaultTableModel(null,titulo);
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            PreparedStatement ps;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from usuarios");
            String[] datos = new String[6];
            while (rs.next()) {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                
                
                model.addRow(datos);
            }
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Error en la base de datos "+e);
        }
        return model;   
    }
    
    public static Usuario buscarUsuarios (Accesos a){
        int rta=-1;
        Usuario usu= new Usuario();
        usu.setId(-1);
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from usuarios where correo = '"+a.getCorreo()+"' ");
            if(rs.next()){
                usu.setId(rs.getInt("id"));
                usu.setNombre(rs.getString("nombre"));
                usu.setCorreo(rs.getString("correo"));
                usu.setContrasena(rs.getString("contrasena"));
                usu.setTipo(rs.getString("tipo"));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error en la base de datos "+e);
        }
        return usu;   
    }
   
    
}
