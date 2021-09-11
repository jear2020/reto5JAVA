
package DAO;

import VO.Accesos;
import conexion.Conexion;
import static conexion.Conexion.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JEAR
 */
public class AccesosDAO {
    public static String insertar(Accesos ac){
        String rta="";
        int rt;
        try {
            Conexion co= new Conexion();
            conn=co.conectar();
            Statement stmt = conn.createStatement();
            String query="INSERT INTO accesos (correo,tipo,estado,hora,usu_id) VALUES ('"+ac.getCorreo()+"','"+ac.getTipo()+"','"+ac.getEstado()+"','"+ac.getHora()+"','"+ac.getUsu_id()+"')";
            rt = stmt.executeUpdate(query);
            //JOptionPane.showMessageDialog(null, "Acceso almacenado correctamente ", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error "+e, "Base de datos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error "+e);
        }
        return rta;
    }
    
    public static Connection conn;
    public DefaultTableModel accesosListar(){
        String[] titulo={"ID","CORREO","TIPO","ESTADO","HORA"};
        DefaultTableModel model = new DefaultTableModel(null,titulo);
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            PreparedStatement ps;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from accesos");
            String[] datos = new String[5];
            while (rs.next()) {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                
                
                model.addRow(datos);
            }
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Error en la base de datos "+e);
        }
        return model;   
    }
}
