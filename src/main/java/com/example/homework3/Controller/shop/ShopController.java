package com.example.homework3.Controller.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ShopController", value = "/shop")
public class ShopController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            askForPassword(response);
        } else {
            String userInfo = authorization.substring(6).trim();
            Base64.Decoder decoder = Base64.getDecoder();
            String nameAndPassword =
                    new String(decoder.decode(userInfo));
            // Decoded part looks like "username:password".
            int index = nameAndPassword.indexOf(":");
            String user = nameAndPassword.substring(0, index);
            String password = nameAndPassword.substring(index+1);
            if (user.equals("admin")  && password.equals("admin")) {
                HttpSession session = request.getSession(true);
                session.setAttribute("cart", new ArrayList<String>());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/shop/homepage.jsp");
                requestDispatcher.forward(request, response);
            } else {
                askForPassword(response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String[] itemsToDelete = request.getParameterValues("items");
        List<String> cart = (List<String>) session.getAttribute("cart");
        for (String item : itemsToDelete) {
            cart.remove(item);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/shop/homepage.jsp");
        requestDispatcher.forward(request, response);
    }
    private void askForPassword(HttpServletResponse response) {
        response.setStatus(response.SC_UNAUTHORIZED); // I.e., 401
        response.setHeader("WWW-Authenticate",
                "BASIC realm=\"Insider-Trading\"");
    }
}
