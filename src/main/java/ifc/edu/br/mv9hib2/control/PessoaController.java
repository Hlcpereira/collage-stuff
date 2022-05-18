/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ifc.edu.br.mv9hib2.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ifc.edu.br.mv9hib2.dao.NacionalidadeDao;
import ifc.edu.br.mv9hib2.dao.PessoaDao;
import ifc.edu.br.mv9hib2.model.Nacionalidade;
import ifc.edu.br.mv9hib2.model.Pessoa;

/**
 *
 * @author henrique
 */
@WebServlet(name = "PessoaController", urlPatterns = {"/PessoaController"})
public class PessoaController extends HttpServlet {

    PessoaDao pdao = new PessoaDao();
    NacionalidadeDao ndao = new NacionalidadeDao();
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
        ArrayList<Pessoa> registros = pdao.retornarPessoas();
        request.setAttribute("registros", registros);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
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
        request.setCharacterEncoding("utf8");

        String op = request.getParameter("op");
        
        Long Id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        Float peso = Float.parseFloat(request.getParameter("peso"));
        Nacionalidade nacionalidade = ndao.buscarNacionalidade(Long.parseLong(request.getParameter("nacionalidade")));
        
        if (op.equals("put")) { // atualização de dados da pessoa
            Pessoa atualizar = pdao.buscarPessoa(Id);
            atualizar.setNome(nome);
            atualizar.setEmail(email);
            atualizar.setPeso(peso);
            atualizar.setNacionalidade(nacionalidade);
            if (pdao.atualizarPessoa(atualizar)) {
                request.setAttribute("msg", "Pessoa atualizada com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu um erro ao atualizar a pessoa :-(");
            }
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        }
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
