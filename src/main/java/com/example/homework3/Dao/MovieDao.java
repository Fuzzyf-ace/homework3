package com.example.homework3.Dao;


import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class MovieDao {
    final String USERNAME = "admin";
    final String PASSWORD = "NUSRpJQAO7A6z19jGstM";

    final String RDS_ENDPOINT = "csye6220.couxfnqwwltv.us-east-2.rds.amazonaws.com";

    final String URL = "jdbc:mysql://" + RDS_ENDPOINT + ":3306/csye6220?createDatabaseIfNotExist=true&serverTimezone=UTC";

    public void addMovie(HttpServletRequest request) {
        Connection connection = null;
        String title = request.getParameter("movie_title");
        String actress = request.getParameter("lead_actress");
        String actor = request.getParameter("lead_actor");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            System.out.println("connection success");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO movies (title, actor, actress, genre, year) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, title);
            statement.setString(2, actor);
            statement.setString(3, actress);
            statement.setString(4, genre);
            statement.setInt(5, year);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet searchMovie(HttpServletRequest request) {
        Connection connection = null;
        String keyword = request.getParameter("keyword");
        String searchBy = request.getParameter("search_by");
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movies WHERE " + searchBy +" = ? ");
            statement.setString(1, keyword);
            resultSet = statement.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
