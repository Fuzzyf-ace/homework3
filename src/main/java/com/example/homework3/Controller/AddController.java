package com.example.homework3.Controller;

import com.example.homework3.Dao.MovieDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addController", value = "/movie/add")
public class AddController extends HttpServlet {

    MovieDao movieDao = new MovieDao();

//    final String URL = "jdbc:mysql://newton.neu.edu:3303/advertdb";
//    final String USERNAME = "student";
//    final String PASSWORD = "p@ssw0rd";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("../JSP/add.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        movieDao.addMovie(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("../JSP/added.jsp");
        requestDispatcher.forward(request, response);
    }
}
