package com.example.homework3.Controller.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopBookController", value = "/shop/books")
public class ShopBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/shop/book.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<String> cart = (List<String>) session.getAttribute("cart");
        String[] items = request.getParameterValues("items");
        for (String item : items) {
            cart.add(item);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/shop/homepage.jsp");
        requestDispatcher.forward(request, response);
    }
}
