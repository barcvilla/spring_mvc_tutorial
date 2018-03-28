/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import action.PDFAction;
import service.PDFService;

/**
 *
 * @author barcvilla
 */
public class DependencyInjector {
    public void start()
    {
    }
    
    public void shutDown()
    {
    }
    
    /**
     * Retorna una instancia de tipo, tipo es un tipo de clase y no String
     * 
     */
    public Object getObject(Class type)
    {
        if(type == PDFService.class)
        {
            return new PDFService();
        }
        else if(type == PDFAction.class)
        {
            PDFService pdfService = (PDFService)getObject(PDFService.class);
            PDFAction action = new PDFAction();
            action.setPDFService(pdfService);
            return action;
        }
        return null;
    }
}
