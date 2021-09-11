
package DAO;

import VO.Estudiante;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAR
 */
public class EstudiantesDAO {
    public static Connection conn;
    public static String insertar(Estudiante e){
        String rta="";
        int rt;
        try {
            Conexion co= new Conexion();
            conn=co.conectar();
            Statement stmt = conn.createStatement();
            String query="INSERT INTO usuarios (identificacion,nombre,tipo,correo,contrasena) VALUES ('"+e.getIdentificacion()+"','"+e.getNombre()+"','"+e.getTipo()+"','"+e.getCorreo()+"','"+e.getContrasena()+"')";
            rt = stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Usuario almacenado correctamente ", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
            
            String queryB="select id from usuarios where identificacion='"+e.getIdentificacion()+"'";
            Statement st = conn.createStatement();
            ResultSet rs2 = st.executeQuery(queryB);
            if(rs2.next()){
                String query3="INSERT INTO estudiantes (usu_id) VALUES ('"+rs2.getInt(1)+"')";
                rt = stmt.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Estudiante almacenado correctamente ", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
            
            }
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex, "Base de datos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error "+ex);
        }
        return rta;
    }
    
    public static int buscar(int id){
        int id_e=0;
        Conexion co= new Conexion();
        conn=co.conectar();
        String sql="select e.id from estudiantes as e,usuarios as u where e.usu_id = u.id and u.id='"+id+"'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
               id_e=rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        return id_e;
    }
}
