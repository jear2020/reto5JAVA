
package controladores;

import VO.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAR
 */
public class LoginController {
    public static boolean validar(Usuario u){
        boolean rta = true;
        if(u.getCorreo().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un Usuario(Correo)", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        
        if(u.getContrasena().length()==0){
            JOptionPane.showMessageDialog(null, "Digite una Contraseña", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        return rta;
    }
}
