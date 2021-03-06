package br.com.inventoryControl.form;

import br.com.inventoryControl.entities.Product;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ProductForm {

    @NotNull
    String name;
    @NotNull
    java.math.BigDecimal price;

    public Product converter() {
        return new Product(name, price);
    }
}
