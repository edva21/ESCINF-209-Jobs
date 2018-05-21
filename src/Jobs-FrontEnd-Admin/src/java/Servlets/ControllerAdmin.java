/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import FEBussinesLogic.MensajeEstado;
import BussinessLogic.Administrador;
import BussinessLogic.Nacionalidad;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edva5
 */
@MultipartConfig @WebServlet(name = "Administradores", urlPatterns = {"/Administradores","/add","/cambiarEstadoOferente"})
public class ControllerAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){        
      switch(request.getServletPath()){                   
           case "/add":
         {
              try {
               doAdd(request,response);
              } catch (Exception ex) {
                  response.setStatus(401); 
               Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
              break;
           case "/cambiarEstadoOferente":
               doUpdateEstadoOferente(request, response);
               break;
          default:
              break;
      }           
    }
    private void doAdd(HttpServletRequest request, HttpServletResponse response){                
        
        try {
        Reader personaReader = new BufferedReader(new InputStreamReader(request.getPart("objeto").getInputStream()));
        Gson gson = new Gson();
        Administrador object = gson.fromJson(personaReader, Administrador.class);
        PrintWriter out;
        out = response.getWriter();
         Model.Model.getInstance().create(object);        
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(object));        
        response.setStatus(200); // ok with content
        } catch (IOException ex) {
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    private void doUpdateEstadoOferente(HttpServletRequest request, HttpServletResponse response){                
        try {
        Reader reader = new BufferedReader(new InputStreamReader(request.getPart("objeto").getInputStream()));
        Gson gson = new Gson();
        MensajeEstado object = gson.fromJson(reader, MensajeEstado.class);
        PrintWriter out;
        out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(object));    
            if (Model.Model.getInstance().updateEstado(object.getOferenteid(), object.getEstado()))
                response.setStatus(200); // ok with content
            else
                response.setStatus(401); 
        } catch (IOException ex) {            
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}