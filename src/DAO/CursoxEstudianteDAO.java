
package DAO;

import VO.CursoxEstudiante;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JEAR
 */
public class CursoxEstudianteDAO {
    public static Connection conn;
    public DefaultTableModel cursosxestudiantesListar(int id){
        String[] titulo={"ID","NOMBRE","HORARIO","UBICACION"};
        DefaultTableModel model = new DefaultTableModel(null,titulo);
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from estudiantesxcursos AS exc,estudiantes AS est,cursos AS cur \n" +
                                    "WHERE exc.est_id=est.id AND exc.cur_id=cur.id AND est.id='"+id+"'");
            String[] datos = new String[4];
            while (rs.next()) {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString("nombre");
                datos[2]=rs.getString("horario");
                datos[3]=rs.getString("ubicacion");
                model.addRow(datos);
            }
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("Error en la base de datos "+ex);
        }
        return model;   
    }
    
    public  int cursosxestudiantesContar(int id){
        int c=0;
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select COUNT(exc.id) from estudiantesxcursos AS exc,estudiantes AS est,cursos AS cur \n" +
                                    "WHERE exc.est_id=est.id AND exc.cur_id=cur.id AND est.id='"+id+"'");
            if(rs.next()){
                c=rs.getInt(1);
            }
            
            
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("Error en la base de datos "+ex);
        }
        return c;   
    }
    public static boolean cursosxestudiantesBuscar(int id_est,int id_curso){
       boolean c=false;
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(exc.id) from estudiantesxcursos AS exc,estudiantes AS est,cursos AS cur\n" +
                                   "WHERE exc.est_id=est.id AND exc.cur_id=cur.id AND est.id='"+id_est+"' AND cur.id='"+id_curso+"'");
            if(rs.next()){
                if(rs.getInt(1)!=0){
                    c=true;
                }
            }
            
            
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("Error en la base de datos "+ex);
        }
        return c;   
    }
    public static String insertar(int est, int cur){
        String rta="";
        int rt;
        try {
            Conexion co= new Conexion();
            conn=co.conectar();
            Statement stmt = conn.createStatement();
            String query="INSERT INTO estudiantesxcursos (est_id,cur_id) VALUES ('"+est+"','"+cur+"')";
            rt = stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Curso registrado correctamente ", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e, "Base de datos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error "+e);
        }
        return rta;
    }
}
