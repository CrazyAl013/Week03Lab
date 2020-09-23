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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operation = request.getParameter("operation");  
        int firstNumber;
        int secondNumber;
        int result = 0;
        
        try {
        firstNumber = Integer.parseInt(request.getParameter("first"));
        secondNumber = Integer.parseInt(request.getParameter("second"));
        } catch(NumberFormatException e) {
            request.setAttribute("result", "Invalid.");
            getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);
            return;
        }
   
        switch(operation) {
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
                result = firstNumber % secondNumber;
                break;
            default:
                
        }
        
        request.setAttribute("result", result);
        request.setAttribute("first", firstNumber);
        request.setAttribute("second", secondNumber);
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);
    }
}
