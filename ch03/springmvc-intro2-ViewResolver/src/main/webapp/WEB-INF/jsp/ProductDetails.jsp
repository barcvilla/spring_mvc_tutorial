<%-- 
    Document   : ProductDetails
    Created on : 30/05/2018, 16:24:58
    Author     : PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Product</title>
        <style type="text/css">@import url(css/main.css)</style>
    </head>
    <body>
        <div id="global">
            <h4>El producto ha sido almacenado</h4>
            <p>
                <h5>Details:</h5>
                Product Name: ${product.name}<br/>
                Description: ${product.description} <br/>
                Price: ${product.price} <br/>
            </p>
        </div>
    </body>
</html>
