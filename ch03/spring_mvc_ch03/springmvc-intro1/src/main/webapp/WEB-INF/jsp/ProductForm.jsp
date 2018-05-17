<%-- 
    Document   : ProductForm
    Created on : 16/05/2018, 21:58:30
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Form</title>
        <style type="text/css">@import url(css/main.css)</style>
    </head>
    <body>
        <div id="global">
            <form action="save-product" method="post">
                <fieldset>
                    <legend>Add a Product</legend>
                    <p>
                        <label for="name">Product Name:</label>
                        <input type="text" id="name" name="name" tabindex="1">
                    </p>
                    <p>
                        <label for="description">Description: </label>
                        <input type="text" id="description" name="name" tabindex="2">
                    </p>
                    <p>
                        <label for="price">Price: </label>
                        <input type="text" id="price" name="price" tabindex="3">
                    </p>
                    <p id="buttons">
                        <input id="reset" type="reset" tabindex="4">
                        <input id="submit" type="submit" tabindex="5" value="Add Product">
                    </p>
                </fieldset>
            </form>
        </div>
    </body>
</html>
