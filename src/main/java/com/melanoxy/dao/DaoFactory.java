package com.melanoxy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//initiate the DAO, connect to the DB
public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
        		"jdbc:mysql://localhost:3306/ocpizzadb", "root", "Includes07");
        return instance;
    }

    public Connection getConnection() throws SQLException {
    	Connection connexion = DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);//we handle ourself the transaction
        return connexion; 
    }

    // Récupération du Dao
    public PizzaDao getPizzaDao() {
        return new PizzaDaoImpl(this);
    }
}