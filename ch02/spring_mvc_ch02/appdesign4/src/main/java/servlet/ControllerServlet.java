/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.PDFAction;
import java.io.IOException;
import javax.servlet.ReadListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DependencyInjector;

/**
 *
 * @author barcvilla
 */
@WebServlet
(
        name = "ControllerServlet",
        urlPatterns = {"/Form", "/Pdf"}
)
public class ControllerServlet extends HttpServlet
{
    public static final long serialVersionUID = 6679L;
    private DependencyInjector dependencyInjector;
    
    @Override
    public void init() {
        dependencyInjector = new DependencyInjector();
        dependencyInjector.start();
    }

    @Override
    public void destroy() {
        dependencyInjector.shutDown();
    }
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        ReadListener r = null;
        String uri = request.getRequestURI();
        
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        if("Form".equals(action))
        {
            String dispatchUrl = "Form.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
        else if("Pdf".equals(action))
        {
            HttpSession session = request.getSession(true);
            String sessionId = session.getId();
            PDFAction pdfAction = (PDFAction)dependencyInjector.getObject(PDFAction.class);
            String text = request.getParameter("text");
            String path = request.getServletContext().getRealPath("/result") + sessionId + ".pdf";
            pdfAction.createPDF(path, text);
            
            // redirect al nuevo pdf
            StringBuilder redirect = new StringBuilder();
            redirect.append(request.getScheme() + "://");
            redirect.append(request.getLocalName());
            int port = request.getLocalPort();
            if(port != 80)
            {
                redirect.append(":" + port);
            }
            
            String contextPath = request.getContextPath();
            if(!"/".equals(contextPath))
            {
                redirect.append(contextPath);
            }
            redirect.append("/result/" + sessionId + ".pdf");
            response.sendRedirect(redirect.toString());
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        process(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        process(request, response);
    }
}
