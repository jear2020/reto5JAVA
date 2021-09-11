
package controladores;

import DAO.AccesosDAO;
import DAO.UsuariosDAO;
import VO.Accesos;
import VO.Usuario;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAR
 */
public class AccesosController {
    
    public static Usuario validar(Accesos ac,String con){
        Usuario usu=new Usuario();
        LocalTime hora=LocalTime.now();
        DateTimeFormatter h = DateTimeFormatter.ofPattern("hh:mm:ss");
        usu=UsuariosDAO.buscarUsuarios(ac); 
        if(usu.getId()!=-1){
            
           if(usu.getCorreo().equals(ac.getCorreo()) && usu.getContrasena().equals(con)){
               
               ac.setUsu_id(usu.getId());
               ac.setCorreo(usu.getCorreo());
               ac.setTipo(usu.getTipo());
               ac.setEstado("Correcto");
               ac.setHora(hora.format(h));
               AccesosDAO.insertar(ac);
               
           }else{
               ac.setUsu_id(usu.getId());
               ac.setCorreo(usu.getCorreo());
               ac.setTipo(usu.getTipo());
               ac.setEstado("Error");
               ac.setHora(hora.format(h));
               AccesosDAO.insertar(ac);
               
           }
        }
        return usu;
    }
}
