
package controladores;

import VO.Profesor;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAR
 */
public class ProfesoresController {
     public static boolean validar(Profesor p){
        boolean rta = true;
        if(p.getIdentificacion().length()==0){
            JOptionPane.showMessageDialog(null, "Digite una identificación", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        if(p.getNombre().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un nombre", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        
        if(p.getCorreo().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un Correo", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        if(p.getContrasena().length()==0){
            JOptionPane.showMessageDialog(null, "Digite una Contraseña", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        if(p.getTitulo().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un Titulo", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        if(p.getAnios_experiencia().length()==0){
            JOptionPane.showMessageDialog(null, "Digite los Años de Experiencia", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        return rta;
    }
}
