/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesign2.form;

/**
 * Esta clase hace un mapeo de unn formulario HTML. Es la representancion del form HTML en el servidor.
 * La mayoria de las veces una clase de formulario no tiene que implementar Serializable como objeto de formulario
 * rara vez se almacena en una HttpSession.
 * @author barcvilla
 */
public class ProductForm 
{
    private String name;
    private String description;
    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
}
