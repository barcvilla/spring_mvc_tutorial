<%-- 
    Document   : ProductForm
    Created on : 28/02/2018, 11:31:43
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
        <form method="post" action="save-product">
            <h1>Add Product
                <span>Please use this form to enter product details</span>
            </h1>
            <label>
                <span>Product Name :</span>
                <input id="name" type="text" name="name" placeholder="the complete product name" />
            </label>
            <label>
                <span>Description :</span>
                <input id="description" type="text" name="description" placeholder="Product description"/>
            </label>
            <label>
                <span>Price :</span>
                <input id="price" name="price" type="number" step="any" placeholder="Product price in #.## format"/>
            </label> 
            <label>
                <span>&nbsp;</span>
                <input type="submit" />
            </label>
        </form>
    </body>
</html>
