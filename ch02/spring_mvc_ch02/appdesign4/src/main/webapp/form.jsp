<%-- 
    Document   : Form
    Created on : 27/03/2018, 23:41:07
    Author     : barcvilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Form</title>
        <style type="text/css">@import url(css/main.css);</style>
    </head>
    <body>
        <form method="post" action="pdf">
            <h1>Create PDF
                <span>Please use this form to enter the text</span>
            </h1>
            <label>
                <span>Text :</span>
                <input type="text" name="text" placeholder="Text for PDF"/>
            </label>
            <label>
                <span>&nbsp;</span> 
                <input type="submit"/> 
            </label> 
        </form>
        
    </body>
</html>
