/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Product;

/**
 *
 * @author PC
 */
public interface ProductService 
{
    Product add(Product product);
    Product get(long id);
}
