/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesign1.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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
    
}
