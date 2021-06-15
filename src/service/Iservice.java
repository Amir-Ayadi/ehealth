/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Ayadi
 */
public interface Iservice<T> {
	//interface des interfaces . 
    void insert(T t);
    List<T> readAll();
    T readById(int id);
    void delete(int id);
    void update(T t);
    
}
