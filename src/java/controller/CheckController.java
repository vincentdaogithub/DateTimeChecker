/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DateTime.DateTimeError;
import DateTime.DateTimeFunction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thuan
 */
public class CheckController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DateTimeError DTE = new DateTimeError();
            int check = 1;

            int Day = 0;
            try {
                Day = Integer.parseInt(request.getParameter("txtDay"));
                if (Day < 1 || Day > 31) {
                    DTE.setDayRangeError("Input data for Day is out of range!");
                    check = 0;
                }
            } catch (NumberFormatException e) {
                DTE.setDayFormatError("Input data for Day is incorrect format!");
                check = 0;
            }

            int Month = 0;
            try {
                Month = Integer.parseInt(request.getParameter("txtMonth"));
                if (Month < 1 || Month > 12) {
                    DTE.setMonthRangeError("Input data for Month is out of range!");
                    check = 0;
                }
            } catch (NumberFormatException e) {
                DTE.setMonthFormatError("Input data for Month is incorrect format!");
                check = 0;
            }

            int Year = 0;
            try {
                Year = Integer.parseInt(request.getParameter("txtYear"));
                if (Year < 1000 || Year > 3000) {
                    DTE.setYearRangeError("Input data for Year is out of range!");
                    check = 0;
                }
            } catch (NumberFormatException e) {
                DTE.setYearFormatError("Input data for Year is incorrect format!");
                check = 0;
            }
            if (check == 1) {
                boolean check2 = DateTimeFunction.IsValidDate(Year, Month, Day);
                if (check2) {
                    DTE.setValidDate(Day+"/"+Month+"/"+Year+" is correct date time!");
                }
                else {
                    DTE.setValidDate(Day+"/"+Month+"/"+Year+" is NOT correct date time!");
                }
            }
            request.setAttribute("DTE", DTE);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
