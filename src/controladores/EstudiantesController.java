
package controladores;

import VO.Estudiante;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAR
 */
public class EstudiantesController {
     public static boolean validar(Estudiante e){
        boolean rta = true;
        if(e.getIdentificacion().length()==0){
            JOptionPane.showMessageDialog(null, "Digite una identificación", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        if(e.getNombre().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un nombre", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        
        if(e.getCorreo().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un Correo", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        if(e.getContrasena().length()==0){
            JOptionPane.showMessageDialog(null, "Digite una Contraseña", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        
        return rta;
    }
}
