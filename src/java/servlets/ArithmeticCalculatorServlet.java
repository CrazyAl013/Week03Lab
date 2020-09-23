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
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("result", "Result: ---");
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("first", request.getParameter("first"));
        request.setAttribute("second", request.getParameter("second"));

        String operation = request.getParameter("operation");
        int firstNumber;
        int secondNumber;
        int result = 0;

        try {
            firstNumber = Integer.parseInt(request.getParameter("first"));
            secondNumber = Integer.parseInt(request.getParameter("second"));
        } catch (NumberFormatException e) {
            request.setAttribute("result", "Result: Invalid.");
            getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);
            return;
        }

        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "%":
                try {
                    result = firstNumber % secondNumber;
                    break;
                } catch (ArithmeticException e) {
                    request.setAttribute("result", "Result: Invalid.");
                    getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);
                    return;
                }
            default:

        }

        request.setAttribute("result", "Result: " + result);
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);
    }
}
