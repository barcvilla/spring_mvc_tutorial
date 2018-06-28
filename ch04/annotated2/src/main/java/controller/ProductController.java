/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProductService;

/**
 *
 * @author PC
 */
@Controller
public class ProductController 
{
    private static final Log logger = LogFactory.getLog(ProductController.class);
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "/input-product")
    public String inputProduct()
    {
        logger.info("inputProduct called");
        return "ProductForm";
    }
}
