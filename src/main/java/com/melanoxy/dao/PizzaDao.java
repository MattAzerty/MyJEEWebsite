package com.melanoxy.dao;

import java.util.List;

import com.melanoxy.beans.Pizza;

public interface PizzaDao {//Interface where method are determined in advance
    void add( Pizza pizza ) throws DaoException;
    List<Pizza> lister() throws DaoException;
}