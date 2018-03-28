/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import service.PDFService;

/**
 * PDFAction requiere un objeto PDFService para hacer su trabajo.PDFAction depende de PDFService, sin inyeccion de
 * dependencia necesitariamos instanciar la clase PDFService dentro de la clase PDFAction y esto hace que la clase
 * PDFAction sea menos testeable. 
 * 
 * Con la inyeccion de dependencia, cada componente tiene sus dependencias inyectadas y esto hace mas facil la fase
 * de testeo. Mas facil, para que una clase se utilice en un entorno de inyeccion de dependencia. Una forma
 * de hacerlo es creat un metodo setxxx para cada dependencia. Por ejemplo, La clase PDFAction tiene un metodo
 * setPDFAction() que puede ser llamado para pasar un PDFService. Inyeccion tambien puede ocurrir a traves del
 * constructor o un campo de clase.
 * @author barcvilla
 */
public class PDFAction {
    private PDFService pdfService;
    
    public void setPDFService(PDFService pdfService)
    {
        this.pdfService = pdfService;
    }
    
    public void createPDF(String path, String input)
    {
        pdfService.createPDF(path, input);
    }
}
