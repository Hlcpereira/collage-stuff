/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Company;

/**
 *
 * @author henrique
 */
public class CompanyDAO {
    public static final String URL = "jdbc:sqlite:/home/henrique/Documentos/if/companies.db";

    public ArrayList<Company> getCompanies(int limitPagination, int pageNumber) throws Exception {
        Connection con;
        Statement st;
        ResultSet result;
        String returnStat = new String();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        }
        ArrayList<Company> companyList = new ArrayList();
        int offset = ((pageNumber-1)*limitPagination);
        try {
            con = DriverManager.getConnection(URL);
            st = con.createStatement();
            result = st.executeQuery("select * from compania limit " + (offset) + "," + limitPagination);
            while (result.next()) {
                Company company = new Company();
                company.id = result.getString(1);
                company.nome = result.getString(2);
                company.dominio = result.getString(3);
                company.ano = result.getString(4);
                company.industria = result.getString(5);
                company.tamanho = result.getString(6);
                company.localizacao = result.getString(7);
                company.pais = result.getString(8);
                company.linkedin = result.getString(9);
                company.empregados_atual = result.getInt(10);
                company.empregados_total = result.getInt(11);
                
                companyList.add(company);
            }
            return companyList;
        } catch (SQLException ex) {
            returnStat += "Erro no SQL: " + ex.getMessage();
            return companyList;
        }
    }

}
