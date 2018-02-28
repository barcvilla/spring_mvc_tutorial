/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesign1.controller;

import appdesign1.action.SaveProductAction;
import appdesign1.form.ProductForm;
import appdesign1.model.Product;
import java.io.IOException;
import java.math.BigDecimal;
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
        name="ControllerServlet",
        urlPatterns={"/input-product", "/save-product"}
)
public class ControllerServlet extends HttpServlet
{
    private static final long serialVersionUID = 1579L;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);
    }
    
    // Este metodo es el cerebro del servlet que procesa todas las solicitudes de ingreso. 
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Obtenemos el request URI y el nombre de la accion.
        String uri = request.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName,
         * for example: /appdesign1/input-product.
         * However, in the event of a default context, the
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /input-product
         */

        int lastIndex = uri.lastIndexOf("/");
        //Value Actions = input-product or save-product
        String action = uri.substring(lastIndex + 1);
        
        // execute an action
        String dispatchUrl = null;
        System.out.println(action);
        
        //determinar  que accion realizar 
        if ("input-product".equals(action)) 
        {
            // no action class, just forward
            //dispatchUrl = "/jsp/ProductForm.jsp";
            dispatchUrl = "/ProductForm.jsp";
        } else if ("save-product".equals(action)) 
        {
            // create productForm y un Product
            ProductForm productForm = new ProductForm();
            // populate action properties
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(
                    request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            // create model
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
            	product.setPrice(new BigDecimal(productForm.getPrice()));
            } catch (NumberFormatException e) {
            }
            // Instanciamos la clase SaveProductAction. execute save action method
            SaveProductAction saveProductAction =
            		new SaveProductAction();
            saveProductAction.save(product);

            // Product es almacenado en un scope variable para el acceso por la vista.
            request.setAttribute("product", product);
            //dispatchUrl = "/jsp/ProductDetails.jsp";
            dispatchUrl = "/ProductDetails.jsp";
        }
        
        /*
         * Forwarding una vista. Si una accion es igual a input-product, el control es enviado a la pagina
         * ProductForm.jsp. Si la accion es save-product, el control envia a la pagina ProductDetails.jsp
        */
        if (dispatchUrl != null) 
        {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }        
    }
    
}
