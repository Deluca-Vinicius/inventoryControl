package br.com.inventoryControl.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(unique = true)
    Integer productCompanyId;

    @NotNull
    String name;

    @NotNull
    java.math.BigDecimal price;

    @NotNull
    Integer companyId;

    @NotNull
    Integer quantity;

    public Product(String name, java.math.BigDecimal price, Integer productCompanyId, Integer companyId, Integer quantity) {

        this.price = price;
        this.name = name;
        this.productCompanyId = productCompanyId;
        this.companyId = companyId;
        this.quantity = quantity;
    }

}
