package com.example.homework3.Controller.book;

import com.example.homework3.Dao.BookDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddController", value = "/book/addBook")
public class AddController extends HttpServlet {
    BookDao bookDao = new BookDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookDao.addBook(request);
        request.setAttribute("num", request.getParameterValues("isbn").length);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/book/addedBook.jsp");
        requestDispatcher.forward(request, response);
    }
}
