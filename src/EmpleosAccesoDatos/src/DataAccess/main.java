/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;


import java.io.IOException;
import java.net.URISyntaxException;
import BussinessLogic.Empresa;

/**
 *
 * @author gaspa
 */
public class main {
    public static void main(String[] args) throws URISyntaxException, IOException, Exception {
        Empresa x = new Empresa();
        x = EmpresaDAO.getInstance().empresaGet("rr");
        if (x!= null){System.out.println("DataAccess.main.main()"+x.getEmpresaEmail());}
    
    }
    
    
}
