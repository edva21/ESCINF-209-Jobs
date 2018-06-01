/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;


import java.io.IOException;
import java.net.URISyntaxException;
import BussinessLogic.Oferente;

/**
 *
 * @author gaspa
 */
public class main {
    public static void main(String[] args) throws URISyntaxException, IOException, Exception {
        Oferente o = new Oferente("q", "q", "q", "q", "q", "q", null, "q", "q","q", "Afgana");
        boolean b;
        OferenteDAO.getInstance().oferenteIngresar(o);
        System.out.println("DataAccess.main.main()"+o.getOferenteEmail());
    
    }
    
    
}
