package com.melanoxy.servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.melanoxy.beans.Auteur;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

    //When user want to see a page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get name user from url
		String name = request.getParameter("name");
        request.setAttribute("name", name);
        
        String[] noms = {"Mathieu", "Mathilde", "A vous !"};
        request.setAttribute("noms", noms);
        
		request.setAttribute("heure", "soir");
		
		Auteur auteur = new Auteur();
        auteur.setPrenom("Mathieu");
        auteur.setNom("GUILLAUD");
        auteur.setActif(true);
        
        request.setAttribute("auteur", auteur);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
		
		/*response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\" />");
        out.println("<title>Test</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Bonjour !</p>");
        out.println("</body>");
        out.println("</html>");*/
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	//When user want to post something
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
