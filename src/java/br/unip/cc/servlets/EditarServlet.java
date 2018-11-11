/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.cc.servlets;

import br.unip.cc.trabalho.DAO.DaoException;
import br.unip.cc.trabalho.Model.Empresa;
import br.unip.cc.trabalho.Model.GerenciadorEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditarServlet", urlPatterns = {"/editar"})
public class EditarServlet extends HttpServlet {

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
        String idStr = request.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            id = 0;
        }
        GerenciadorEmpresa gerenciador
                = GerenciadorEmpresa.getInstance();
        Empresa empresa;
        try {
            if (id == 0) {
                empresa = gerenciador.getNovaEmpresa();
            } else {
                empresa = gerenciador.getPorId(id);
            }
            request.setAttribute("empresa", empresa);
        } catch (DaoException ex) {
            String mensagem = "Não foi possível recuperar a empresa "
                    + "desejada (id=" + id + ")";
            request.setAttribute("mensagem", mensagem);
            throw new ServletException(mensagem, ex);
        }
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
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