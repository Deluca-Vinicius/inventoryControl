package br.com.inventoryControl.Dto;

import br.com.inventoryControl.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int id;
    private String name;
    private java.math.BigDecimal price;

    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public static List<ProductDto> converter (List<Product> productList){

        return productList.stream().map(ProductDto::new).collect(Collectors.toList());
    }
    public static List<ProductDto> converterById (Optional<Product> product){

        return product.stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
