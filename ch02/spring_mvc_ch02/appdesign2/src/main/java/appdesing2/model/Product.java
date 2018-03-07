/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesing2.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Clase plantilla para formar el objeto. Una instancia que contiene la informacion de un producto.
 * Esta clase implementa Serializable permite almacenar de modo seguro en un objeto HttpSession. Como la clase
 * Product implementa Serializable esta clase debe incluir el campo serialVersionUID
 * @author barcvilla
 */
public class Product implements Serializable
{
    private static final long serialVersionUID = 748392348L;
    private String name;
    private String description;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
