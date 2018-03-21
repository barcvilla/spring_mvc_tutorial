/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesign3.controller;

import appdesign3.action.SaveProductAction;
import appdesign3.form.ProductForm;
import appdesign3.model.Product;
import appdesign3.validator.ProductValidator;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author barcvilla
 */
@WebServlet
(
    name = "ControllerServlet", urlPatterns = {"/input-product", "/save-product" }
)
public class ControllerServlet extends HttpServlet
{
    private static final long serialVersionUID = 98279L;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        process(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        process(request, response);
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String uri = request.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName, 
         * for example: /appdesign3/input-product. 
         * However, in the case of a default context, the 
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /input-product
         */
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1); 
        String dispatchUrl = null;
        if("input-product".equals(action))
        {
            // no hay clase action, no hay nada para ser hecho.
            dispatchUrl = "ProductForm.jsp";
        }
        else if("save-product".equals(action))
        {
            // instanciamos la clase action
            ProductForm productForm = new ProductForm();
            // poblamos las propiedades action
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));
            
            // Validamos ProductForm
            ProductValidator productValidator = new ProductValidator();
            List<String> errors = productValidator.validate(productForm);
            if(errors.isEmpty())
            {
                // Creamos el producto desde el ProductForm
                Product product = new Product();
                product.setName(productForm.getName());
                product.setDescription(productForm.getDescription());
                product.setPrice(new BigDecimal(productForm.getPrice()));
                
                // no hay error en la validacion, ejecutamos la accion
                SaveProductAction saveProductAction = new SaveProductAction();
                saveProductAction.save(product);
                
                /* almacenamos la accion en una variable scope para la vista. Si la validacion es sin errores
                   direccionamos a la pagina ProductDetails.jsp*/
                request.setAttribute("product", product);
                dispatchUrl = "ProductDetails.jsp";
            }
            else
            {
                /*Si hay errores en la validacion, permanecemos en ProductForm*/
                request.setAttribute("errors", errors);
                request.setAttribute("form", productForm);
                dispatchUrl = "ProductForm.jsp";
            }
        }
        
        // forward to a view
        if(dispatchUrl != null)
        {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
