package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BussinessLogic.Nacionalidad;
import BussinessLogic.Oferente;
import Model.Model;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
@WebServlet(name = "ControllerOferente", urlPatterns = {"/ControllerOferente", "/OfferentLogin", "/OferenteRegistro", "/OferenteForm"})
public class ControllerOferente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        switch (request.getServletPath()) {
            case "/OfferentLogin":
                this.doOferenteLogin(request, response);
                break;
            case "/OferenteRegistro":
                this.doOferenteRegistro(request, response);
                break;
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
        List<Nacionalidad> nac = Model.getInstance().readAllNacionalidad();
        String json = new Gson().toJson(nac);

        response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write(json);       // Write response body.
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

    private void doOferenteLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            Oferente oferente = gson.fromJson(reader, Oferente.class);

            PrintWriter out = response.getWriter();
            boolean x = Model.getInstance().login(oferente);
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(oferente));
            if (x) {
                response.setStatus(200);
            } // ok with content
            else {
                response.setStatus(401);
            }
        } catch (Exception e) {
            response.setStatus(401); //Bad request
        }
    }

    private void doOferenteRegistro(HttpServletRequest request, HttpServletResponse response) {
        try {
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            Oferente oferente = gson.fromJson(reader, Oferente.class);
            oferente.setOferenteEstadoDeCuenta("No Aceptado");

            PrintWriter out = response.getWriter();
            boolean x = Model.getInstance().create(oferente);
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(oferente));
            if (x) {
                response.setStatus(200);
            } // ok with content
            else {
                response.setStatus(401);
            }
        } catch (Exception e) {
            response.setStatus(401); //Bad request
        }
    }

}
