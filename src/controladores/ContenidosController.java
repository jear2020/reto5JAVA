
package controladores;

import VO.Contenidos;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAR
 */
public class ContenidosController {
    public static boolean validar(Contenidos c){
        boolean rta = true;
        if(c.getTitulo().length()==0){
            JOptionPane.showMessageDialog(null, "Digite un Titulo", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        
        if(c.getTexto().length()==0){
            JOptionPane.showMessageDialog(null, "Digite una Descripción", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            rta=false;
        }
        return rta;
    }
}
