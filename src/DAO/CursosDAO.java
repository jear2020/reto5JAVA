
package DAO;


import VO.Cursos;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JEAR
 */
public class CursosDAO {
    public static Connection conn;
    public DefaultTableModel cursosListar(){
        String[] titulo={"ID","NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null,titulo);
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            Statement stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from cursos");
            String[] datos = new String[2];
            while (rs.next()) {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                
                model.addRow(datos);
            }
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("Error en la base de datos "+ex);
        }
        return model;   
    }
    
    public static String insertar(Cursos c){
        String rta="";
        int rt;
        try {
            Conexion co= new Conexion();
            conn=co.conectar();
            Statement stmt = conn.createStatement();
            String query="INSERT INTO cursos (nombre,horario,ubicacion,fecha_inicio,fecha_fin,pro_id) VALUES ('"+c.getNombre()+"','"+c.getHorario()+"','"+c.getUbicacion()+"','"+c.getFecha_inicio()+"','"+c.getFecha_fin()+"','"+c.getPro_id()+"')";
            rt = stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Curso almacenado correctamente ", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e, "Base de datos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error "+e);
        }
        return rta;
    }
    
    
    public static ArrayList<Cursos> listar(){
        ArrayList<Cursos> cursos = new ArrayList<Cursos>();
        Conexion co= new Conexion();
        conn=co.conectar();
        String sql="select * from cursos";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cursos c = new Cursos();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                cursos.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        return cursos;
    }
    
   
    
    public static ArrayList<Cursos> verContenido(int id){
        ArrayList<Cursos> cursos = new ArrayList<Cursos>();
        Conexion co= new Conexion();
        conn=co.conectar();
        String sql="SELECT * \n" +
                    "from contenidos AS con, cursos AS cur \n" +
                    "WHERE con.cur_id=cur.id  AND cur.id= '"+id+"' ";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cursos c = new Cursos();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                cursos.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        return cursos;
    }
    
    public static ArrayList<Cursos> listarcxe(int id){
        ArrayList<Cursos> cursos = new ArrayList<Cursos>();
        Conexion co= new Conexion();
        conn=co.conectar();
        String sql="select * from estudiantesxcursos AS exc,estudiantes AS est,cursos AS cur\n" +
                    "WHERE exc.est_id=est.id AND exc.cur_id=cur.id AND est.id='"+id+"'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cursos c = new Cursos();
                c.setId(rs.getInt("cur_id"));
                c.setNombre(rs.getString("nombre"));
                cursos.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        return cursos;
    }
    
    
    public static ArrayList<Cursos> listarcxp(int id){
        ArrayList<Cursos> cursos = new ArrayList<Cursos>();
        Conexion co= new Conexion();
        conn=co.conectar();
        String sql="select * from cursos AS cur,profesores AS pro \n" +
                    "WHERE cur.pro_id=pro.id AND pro.id='"+id+"'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cursos c = new Cursos();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString("nombre"));
                cursos.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        return cursos;
    }
    
    public static String buscar(int id){
        String nombre="";
        Conexion co= new Conexion();
        conn=co.conectar();
        String sql="select nombre from cursos where cursos.id='"+id+"'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
               nombre=rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        return nombre;
    }
}
