/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.servlets;

import br.unip.cc.trabalho.Model.Empresa;
import br.unip.cc.trabalho.Model.GerenciadorEmpresa;
import br.unip.cc.trabalho.Model.TipoEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Sant'Anna
 */
@WebServlet(name = "Buscar", urlPatterns = {"/buscar"})
public class BuscarServlet extends HttpServlet {

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
        String tipoString = request.getParameter("tipo");
        TipoEmpresa tipo;
        try {
            tipo = TipoEmpresa.valueOf(tipoString);
        } catch (NullPointerException | IllegalArgumentException e) {
            tipo = null;
        }
        GerenciadorEmpresa gerenciador = GerenciadorEmpresa.getInstance();
        List<Empresa> empresa = null;
        try {
            if (tipo != null) {
                empresa = gerenciador.getEmpresaPorTipo(tipo);
            }else{
                empresa = gerenciador.getTodasEmpresa();
            }
            request.setAttribute("lista", empresa);
        } catch (Exception e) {
            throw new ServerException("Problema para recuperar", e);
        }
        RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
        rd.forward(request, response);
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
