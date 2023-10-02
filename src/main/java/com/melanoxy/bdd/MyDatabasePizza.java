package com.melanoxy.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.melanoxy.beans.Pizza;

public class MyDatabasePizza {

	 private Connection connexion;
	    
	    public List<Pizza> recupererRecettes() {
	        List<Pizza> recettes = new ArrayList<Pizza>();
	        Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT name, price FROM pizza;");

	            // Récupération des données
	            while (resultat.next()) {
	                String name = resultat.getString("name");
	                String price = resultat.getString("price");
	                
	                Pizza pizza = new Pizza();
	                pizza.setName(name);
	                pizza.setPrice(price);
	                
	                recettes.add(pizza);
	            }
	        } catch (SQLException e) {
	        } finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
	        }
	        
	        return recettes;
	    }
	    
	    private void loadDatabase() {
	        // Chargement du driver
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }

	        try {
	            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ocpizzadb", "root", "Includes07");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void ajouterPizza(Pizza pizza) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO pizza(name, price) VALUES(?, ?);");
	            preparedStatement.setString(1, pizza.getName());
	            preparedStatement.setString(2, pizza.getPrice());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
