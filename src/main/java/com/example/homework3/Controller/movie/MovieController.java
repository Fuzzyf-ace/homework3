package com.example.homework3.Controller.movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MovieController", value = "/movie")
public class MovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/movie/movie.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selection = request.getParameter("selection");
        RequestDispatcher requestDispatcher = null;
        if (selection.equals("browse")) {
            requestDispatcher = request.getRequestDispatcher("JSP/movie/browse.jsp");
        } else if (selection.equals("add")) {
            requestDispatcher = request.getRequestDispatcher("JSP/movie/add.jsp");
        }
        requestDispatcher.forward(request, response);
    }
}
