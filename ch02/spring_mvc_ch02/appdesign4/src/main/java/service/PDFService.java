/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import util.PDFUtil;

/**
 *
 * @author barcvilla
 */
public class PDFService {
    /*Creamos un documento PDF*/
    public void createPDF(String path, String input)
    {
        PDFUtil.createDocument(path, input);
    }
}
