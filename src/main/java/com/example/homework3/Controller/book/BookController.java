package com.example.homework3.Controller.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookController", value = "/book")
public class BookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/book/book.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numofBooks = Integer.parseInt(request.getParameter("num_books"));
        request.setAttribute("num", numofBooks);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/book/addBook.jsp");
        requestDispatcher.forward(request, response);
    }
}
