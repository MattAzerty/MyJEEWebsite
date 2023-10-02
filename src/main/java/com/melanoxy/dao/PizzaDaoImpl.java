package com.melanoxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.melanoxy.beans.BeanException;
import com.melanoxy.beans.Pizza;

public class PizzaDaoImpl implements PizzaDao {
    private DaoFactory daoFactory;

    PizzaDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void add(Pizza pizza) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
        	
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO pizza(name, price) VALUES(?, ?);");
            preparedStatement.setString(1, pizza.getName());
            preparedStatement.setString(2, pizza.getPrice());

            preparedStatement.executeUpdate();
            connexion.commit();
            
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
        throw new DaoException("Impossible to comunicate with database");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible to comunicate with database");
            }
        }

    }

    @Override
    public List<Pizza> lister() throws DaoException {
        List<Pizza> recettes = new ArrayList<Pizza>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
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
            throw new DaoException("Impossible to comunicate with database");
        } catch (BeanException e) {
            throw new DaoException("Impossible to comunicate with database");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible to comunicate with database");
            }
        }
        return recettes;
    }

}
