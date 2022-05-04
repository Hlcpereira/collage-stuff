/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import dao.CompanyDAO;
import modelo.Company;

/**
 *
 * @author henrique
 */
@WebServlet(urlPatterns = {"/companhias"})
public class CompaniesController extends HttpServlet {

    CompanyDAO cdao = new CompanyDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<Company> company = new ArrayList();
        String pageSize = req.getParameter("pageSize");
        String pageNumber = req.getParameter("pageIndex");
        try {
            company = cdao.getCompanies(Integer.parseInt(pageSize), Integer.parseInt(pageNumber));
            req.setAttribute("lista", company);
            getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
