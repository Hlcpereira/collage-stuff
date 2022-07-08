/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hlcpereira.ifc.av2.control;

import com.hlcpereira.ifc.av2.dao.EletronicoDao;
import com.hlcpereira.ifc.av2.dao.ManutencaoDao;
import com.hlcpereira.ifc.av2.dao.OpSysDao;
import com.hlcpereira.ifc.av2.dao.TecnicoDao;
import com.hlcpereira.ifc.av2.model.Eletronico;
import com.hlcpereira.ifc.av2.model.Manutencao;
import com.hlcpereira.ifc.av2.model.OpSys;
import com.hlcpereira.ifc.av2.model.Tecnico;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author henrique
 */
@WebServlet(name = "ManutencaoController", urlPatterns = {"/ManutencaoController"})
public class ManutencaoController extends HttpServlet {

    ManutencaoDao mdao = new ManutencaoDao();
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
            ArrayList<Manutencao> registros = mdao.retornarManutencoes();
            System.out.println(registros);
            request.setAttribute("registros", registros);
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
        } else if (op.equals("cadastrar")) {
            getServletContext().getRequestDispatcher("/form_create_pessoa.jsp").forward(request, response);
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
        
        EletronicoDao edao = new EletronicoDao();
        OpSysDao osdao = new OpSysDao();
        TecnicoDao tdao = new TecnicoDao();

        Eletronico eletronico = edao.buscarEletronico(Long.parseLong(request.getParameter("eletronico")));
        OpSys opSys = osdao.buscarOpSys(Long.parseLong(request.getParameter("op_sys")));
        Tecnico tecnico = tdao.buscarTecnico(Long.parseLong(request.getParameter("tecnico")));

        if (op.equals("post")) {
            Manutencao manutencao = new Manutencao();
            manutencao.setEletronico(eletronico);
            manutencao.setOpSys(opSys);
            manutencao.setTecnico(tecnico);
            if (mdao.incluirManutencao(manutencao)) {
                request.setAttribute("msg", "Manutencao cadastrada com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu um erro ao atualizar a manutencao :-(");
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
