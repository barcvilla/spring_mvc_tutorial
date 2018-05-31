/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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

public class InputProductController implements Controller
{
    private static final Log logger = LogFactory.getLog(InputProductController.class);
    
    /*Retornamos un ModelAndView que contiene un view sin model.La request sera direccionada a /WEB-INF/jsp/ProductForm.jsp*/
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp");
    }
}
