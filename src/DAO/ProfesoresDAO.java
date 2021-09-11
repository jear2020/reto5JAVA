
package DAO;

import VO.Profesor;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JEAR
 */
public class ProfesoresDAO {
    public static Connection conn;
    
    public static ArrayList<Profesor> listar(){
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        Conexion co= new Conexion();
        conn=co.conectar();
        String sql="select * from profesores,usuarios where profesores.usu_id = usuarios.id ";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Profesor p = new Profesor();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                profesores.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        return profesores;
    }
    
    public static String insertar(Profesor p){
        String rta="";
        int rt;
        try {
            Conexion co= new Conexion();
            conn=co.conectar();
            Statement stmt = conn.createStatement();
            String query="INSERT INTO usuarios (identificacion,nombre,tipo,correo,contrasena) VALUES ('"+p.getIdentificacion()+"','"+p.getNombre()+"','"+p.getTipo()+"','"+p.getCorreo()+"','"+p.getContrasena()+"')";
            rt = stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Usuario almacenado correctamente ", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
            
            String queryB="select id from usuarios where identificacion='"+p.getIdentificacion()+"'";
            Statement st = conn.createStatement();
            ResultSet rs2 = st.executeQuery(queryB);
            if(rs2.next()){
                String query3="INSERT INTO profesores (titulo,anios_experiencia,usu_id) VALUES ('"+p.getTitulo()+"','"+p.getAnios_experiencia()+"','"+rs2.getInt(1)+"')";
                rt = stmt.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Profesor almacenado correctamente ", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
            
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e, "Base de datos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error "+e);
        }
        return rta;
    }
    
    public static int buscar(int id){
        int id_p=0;
        Conexion co= new Conexion();
        conn=co.conectar();
        String sql="select p.id from profesores as p,usuarios as u where p.usu_id = u.id and u.id='"+id+"'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
               id_p=rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        return id_p;
    }
    
    public DefaultTableModel cursosxprofesoresListar(int id){
        String[] titulo={"ID","NOMBRE","HORARIO","UBICACION"};
        DefaultTableModel model = new DefaultTableModel(null,titulo);
        try {
            Conexion co =  new Conexion();
            conn = co.conectar();
            ResultSet rs;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from cursos AS c,profesores AS p \n" +
                                    "WHERE c.pro_id=p.id AND p.id='"+id+"'");
            String[] datos = new String[4];
            while (rs.next()) {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString("nombre");
                datos[2]=rs.getString("horario");
                datos[3]=rs.getString("ubicacion");
                //System.out.println("hola "+ rs.getString(1));
                model.addRow(datos);
            }
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("Error en la base de datos "+ex);
        }
        return model;   
    }
}
