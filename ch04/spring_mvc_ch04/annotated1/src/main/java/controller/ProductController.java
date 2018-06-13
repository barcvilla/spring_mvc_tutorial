/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Product;
import form.ProductForm;
import java.math.BigDecimal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
public class ProductController 
{
    private static final Log logger = LogFactory.getLog(ProductController.class);
    
    @RequestMapping(value="/input-product")
    public String inputProduct()
    {
        logger.info("input-product called");
        return "ProductForm";
    }
    
    @RequestMapping(value="/save-product")
    public String saveProduct(ProductForm productForm, Model model)
    {
        logger.info("savedProduct called");
        /*no se necesita crear una instancia de ProductForm*/
        //creamos un Product
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try
        {
            product.setPrice(new BigDecimal(productForm.getPrice()));
        }
        catch(NumberFormatException e){}
        
        /*add Product*/
        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
