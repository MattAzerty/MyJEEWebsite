package com.melanoxy.servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.melanoxy.forms.ConnectionForm;

@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginCookie")) {
                    request.setAttribute("loginCookie", cookie.getValue());
                }
            }
        }
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//to save a variable for a session
		String login = request.getParameter("login");
		HttpSession session = request.getSession();//on initie le moteur de session de JEE
		session.setAttribute("loginSession", login);
		//to save info on cookie
		Cookie cookie = new Cookie("loginCookie", login);
        cookie.setMaxAge(60 * 60 * 24 * 30);//lifetime of the cookie
        response.addCookie(cookie);
		
        
		ConnectionForm form = new ConnectionForm();
		
		form.checkId(request);
		request.setAttribute("form", form);
		
		
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
	}

}
