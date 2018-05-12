package BussinessLogic;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class Habilidad {    
    private String habilidadNombre;    
    //private ArrayList<OferenteHasHabilidad> oferenteHasHabilidadCollection;    
    //private ArrayList<PuestoHabilidad> puestoHabilidadCollection;   
   //private ArrayList<Habilidad> habilidadCollection;    
    private Habilidad habilidadHabilidadNombre;

    public Habilidad() {
    }

    public Habilidad(String habilidadNombre, Habilidad habilidadHabilidadNombre) {
        this.habilidadNombre = habilidadNombre;
        this.habilidadHabilidadNombre = habilidadHabilidadNombre;
    }
    
    /**
     * @return the habilidadNombre
     */
    public String getHabilidadNombre() {
        return habilidadNombre;
    }

    /**
     * @param habilidadNombre the habilidadNombre to set
     */
    public void setHabilidadNombre(String habilidadNombre) {
        this.habilidadNombre = habilidadNombre;
    }

    /**
     * @return the habilidadHabilidadNombre
     */
    public Habilidad getHabilidadHabilidadNombre() {
        return habilidadHabilidadNombre;
    }

    /**
     * @param habilidadHabilidadNombre the habilidadHabilidadNombre to set
     */
    public void setHabilidadHabilidadNombre(Habilidad habilidadHabilidadNombre) {
        this.habilidadHabilidadNombre = habilidadHabilidadNombre;
    }
  
    
}
