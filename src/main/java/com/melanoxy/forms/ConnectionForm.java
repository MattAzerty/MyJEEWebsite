package com.melanoxy.forms;

import jakarta.servlet.http.HttpServletRequest;

public class ConnectionForm {
	
	private String result;
	
	public void checkId(HttpServletRequest request) {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(password.equals(login+"123")) {
			result = "You are connected!";
		}else {
			result = "Error on ID...";
		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
