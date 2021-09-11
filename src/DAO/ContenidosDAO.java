
package DAO;

import VO.Contenidos;
import conexion.Conexion;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author JEAR
 */
public class ContenidosDAO {
    
    public static Connection conn;
    public DefaultTableModel contenidosListar(int id){
        
        String[] titulo={"TITULO","DESCRIPCIÓN"};
        DefaultTableModel model = new DefaultTableModel(null,titulo);
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * \n" +
                                    "from contenidos AS con, cursos AS cur \n" +
                                    "WHERE con.cur_id=cur.id  AND cur.id='"+id+"'");
            String[] datos = new String[3];
            while (rs.next()) {
                datos[0]=rs.getString("titulo");
                datos[1]=rs.getString("texto");
                
                model.addRow(datos);
            }
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("Error en la base de datos "+ex);
        }
        
        
        return model;   
    }
    
   
    
    public static String insertar(Contenidos c){
        String rta="";
        int rt;
        try {
            Conexion co= new Conexion();
            conn=co.conectar();
            Statement stmt = conn.createStatement();
            String query="INSERT INTO contenidos (titulo,texto,cur_id) VALUES ('"+c.getTitulo()+"','"+c.getTexto()+"','"+c.getCur_id()+"')";
            rt = stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Contenido almacenado correctamente ", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e, "Base de datos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error "+e);
        }
        return rta;
    }
}
