/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cprg352
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int age;
     
        try {
            age = Integer.parseInt(request.getParameter("age"));
        } catch(NumberFormatException e) {
            request.setAttribute("result", "You must give your current age.");
            getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward(request, response);
            return;
        }

        request.setAttribute("result", "Your age next birthday will be " + ++age);
        getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward(request, response);
    }
}
