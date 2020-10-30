package br.com.inventoryControl.form;

import br.com.inventoryControl.entities.Company;
import br.com.inventoryControl.entities.Product;
import br.com.inventoryControl.repository.ProductRepository;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ProductForm {

    @NotNull
    String name;

    @NotNull
    java.math.BigDecimal price;

    @NotNull
    int productCompanyId;

    @NotNull
    Company companyId;

    public Product creationConverter() {
        return new Product(name, price, productCompanyId, companyId);
    }

    public Product updateConverter(Integer id, ProductRepository productRepository) {
        Product product = productRepository.getOne(id);
        product.setName(this.name);
        product.setPrice(this.price);
        product.setProductCompanyId(this.productCompanyId);
        product.setCompanyId(companyId);
        return product;
    }
}
