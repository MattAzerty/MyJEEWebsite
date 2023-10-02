package com.melanoxy.servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.melanoxy.bdd.MyDatabasePizza;
import com.melanoxy.beans.Pizza;
import com.melanoxy.dao.DaoException;
import com.melanoxy.dao.DaoFactory;
import com.melanoxy.dao.PizzaDao;

@WebServlet("/Database")
public class Database extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaDao pizzaDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public Database() {
        super();
        // TODO Auto-generated constructor stub
    }*/
	
	 public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.pizzaDao = daoFactory.getPizzaDao();
	    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*MyDatabasePizza dbPizza = new MyDatabasePizza();
        request.setAttribute("pizza", dbPizza.recupererRecettes());*/
    	 try {
    	request.setAttribute("pizza", pizzaDao.lister());
    	 } catch (DaoException e) {
             request.setAttribute("error", e.getMessage());
         }
        this.getServletContext().getRequestDispatcher("/WEB-INF/db.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	try {
    	Pizza pizzaToRegister = new Pizza();
        pizzaToRegister.setName(request.getParameter("pizzaName"));
        pizzaToRegister.setPrice(request.getParameter("pizzaPrice"));
        
        /*MyDatabasePizza dbPizza = new MyDatabasePizza();
        dbPizza.ajouterPizza(pizzaToRegister);*/
        pizzaDao.add(pizzaToRegister);
        request.setAttribute("pizza", pizzaDao.lister());
    	}catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/db.jsp").forward(request, response);
    }
    
    

}
