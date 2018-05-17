/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Product;
import form.ProductForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author PC
 */
public class SaveProductController implements Controller
{
    private static final Log logger = LogFactory.getLog(SaveProductController.class);
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    {
        logger.info("SaveProductController called");
        ProductForm productForm = new ProductForm();
        
        /*poblamos las propiedades*/
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));
        
        /*creamos el model*/
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try
        {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        }
        catch(NumberFormatException e)
        {}
        
        /*insert codigo para almacenar un product*/
        
        /**
         * ModelAndView param:(view path, model name, model object)
         */
        return new ModelAndView("/WEB-INF/jsp/ProductDetails.jsp", "product", product);
    }
}
