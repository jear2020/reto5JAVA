
package VO;

/**
 *
 * @author JEAR
 */
public class Profesor extends Usuario{
    int id;
    String titulo;
    String anios_experiencia;
    int usu_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnios_experiencia() {
        return anios_experiencia;
    }

    public void setAnios_experiencia(String anios_experiencia) {
        this.anios_experiencia = anios_experiencia;
    }

   

    public int getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    
    
}
