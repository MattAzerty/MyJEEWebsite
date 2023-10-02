package com.melanoxy.beans;

public class Pizza {
	
    private String name;
    private String price;
    
    public String getName() {
        return name;
    }
    public void setName(String name) throws BeanException {
    	if (name.length() > 20) {
            throw new BeanException("name is to big! (20 characters maximum)");
        }
        else {
        this.name = name;
        }
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}