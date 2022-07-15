/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hlcpereira.ifc.av2.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.hlcpereira.ifc.av2.dao.ManutencaoDao;
import com.hlcpereira.ifc.av2.dao.TecnicoDao;
import com.hlcpereira.ifc.av2.model.Tecnico;

/**
 *
 * @author henrique
 */
@WebServlet(urlPatterns = {"/TecnicoController"})
public class TecnicoController extends HttpServlet {

    TecnicoDao tdao = new TecnicoDao();
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

        String op = request.getParameter("op");
        if (op.equals("listar")){
            ArrayList<Tecnico> registros = tdao.retornarTecnicos();
            System.out.println(registros);
            request.setAttribute("registros", registros);
            getServletContext().getRequestDispatcher("/listar_tecnicos.jsp").forward(request, response);
        } else if (op.equals("cadastrar")) {
            getServletContext().getRequestDispatcher("/form_create_tecnico.jsp").forward(request, response);
        }
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

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        if (op.equals("put")) {
            Long Id = Long.parseLong(request.getParameter("id"));
            Tecnico atualizar = tdao.buscarTecnico(Id);
            atualizar.setNome(nome);
            atualizar.setCpf(cpf);
            atualizar.setEmail(email);
            atualizar.setTelefone(telefone);
            if (tdao.atualizarTecnico(atualizar)) {
                request.setAttribute("msg", "Tecnico atualizado com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu um erro ao atualizar a pessoa.");
            }
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        } else if (op.equals("post")) {
            Tecnico tecnico = new Tecnico();
            tecnico.setNome(nome);
            tecnico.setEmail(email);
            tecnico.setTelefone(telefone);
            if (tdao.incluirTecnico(tecnico)) {
                request.setAttribute("msg", "Pessoa cadastrada com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu um erro ao atualizar a pessoa :-(");
            }
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
