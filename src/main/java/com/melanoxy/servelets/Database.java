package com.melanoxy.servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.melanoxy.bdd.MyDatabasePizza;
import com.melanoxy.beans.Pizza;

@WebServlet("/Database")
public class Database extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Database() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyDatabasePizza dbPizza = new MyDatabasePizza();
        request.setAttribute("pizza", dbPizza.recupererRecettes());
        this.getServletContext().getRequestDispatcher("/WEB-INF/db.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Pizza pizzaToRegister = new Pizza();
        pizzaToRegister.setName(request.getParameter("pizzaName"));
        pizzaToRegister.setPrice(request.getParameter("pizzaPrice"));
        
        MyDatabasePizza dbPizza = new MyDatabasePizza();
        dbPizza.ajouterPizza(pizzaToRegister);
        
        request.setAttribute("pizza", dbPizza.recupererRecettes());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/db.jsp").forward(request, response);
    }
    
    

}
