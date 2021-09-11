
package controladores;

import VO.Cursos;
import javax.swing.JOptionPane;


public class CursosController {
    public static boolean validar(Cursos c){
        boolean rta = true;
        if(c.getNombre().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un nombre", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        
        if(c.getHorario().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un horario", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        if(c.getUbicacion().length()==0){
            JOptionPane.showMessageDialog(null, "Digite una Ubicación", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
       
        return rta;
    }
}
