package br.com.inventoryControl.form;

import br.com.inventoryControl.entities.Product;
import br.com.inventoryControl.repository.ProductRepository;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;

@Data
public class ProductForm {

    @NotNull
    String name;

    @NotNull
    java.math.BigDecimal price;

    @NotNull
    Integer productCompanyId;

    @NotNull
    Integer companyId;

    @NotNull
    Integer quantity;

    public Product creationConverter() {
        return new Product(name, price, productCompanyId, companyId, quantity);
    }

    public Product updateConverter(Integer id, ProductRepository productRepository, @RequestBody ProductForm form) {

        Product product = productRepository.getOne(id);
        if (form.name != null)
            product.setName(this.name);
        if (form.price != null)
            product.setPrice(this.price);
        if (form.productCompanyId != null)
            product.setProductCompanyId(this.productCompanyId);
        if (form.companyId != null)
            product.setCompanyId(companyId);
        if (form.quantity != null)
            product.setQuantity(quantity);
        return product;
    }
}
