package com.example.homework3.Controller.movie;

import com.example.homework3.Dao.MovieDao;
import com.example.homework3.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchController", value = "/movie/browse")
public class SearchController extends HttpServlet {

    MovieDao movieDao = new MovieDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("../JSP/browse.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        String searchBy = request.getParameter("search_by");

        request.setAttribute("keyword", keyword);
        request.setAttribute("searchBy", searchBy);

        ResultSet resultSet = movieDao.searchMovie(request);

        List<Movie> movieList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setTitle(resultSet.getString("title"));
                movie.setActor(resultSet.getString("actor"));
                movie.setActress(resultSet.getString("actress"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setYear(resultSet.getInt("year"));
                movieList.add(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("searchResult", movieList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("../JSP/searchResult.jsp");
        requestDispatcher.forward(request, response);

    }
}
