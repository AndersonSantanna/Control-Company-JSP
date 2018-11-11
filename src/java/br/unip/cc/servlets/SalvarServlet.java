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
@WebServlet(name = "SalvarServlet", urlPatterns = {"/salvar"})
public class SalvarServlet extends HttpServlet {

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
            String id = request.getParameter("id");
            String cnpj = request.getParameter("cnpj");
            String razao = request.getParameter("razao");
            String tipo = request.getParameter("tipo");
            Empresa empresa = null;
            String mensagem = "";
            String estiloMensagem = "";
            
            try {
                if (id== "#") {
                    empresa = new Empresa(0,cnpj, razao, TipoEmpresa.valueOf(tipo));
                }else{
                    empresa = new Empresa(Integer.parseInt(id),cnpj, razao, TipoEmpresa.valueOf(tipo));
                }
                
                GerenciadorEmpresa ge = GerenciadorEmpresa.getInstance();
                ge.salvar(empresa);
                mensagem = "Salvo com sucesso";
                estiloMensagem = "alert alert-success";
            } catch (Exception e) {
                mensagem = " Não foi possível salvar";
                estiloMensagem = "alert alert-danger";
            }
            request.setAttribute("estilo", estiloMensagem);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("empresa", empresa);
            RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
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
