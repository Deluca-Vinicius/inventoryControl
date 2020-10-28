package br.com.inventoryControl.entities;

import ch.qos.logback.core.joran.spi.NoAutoStart;
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
    private String name;
    @NotNull
    private java.math.BigDecimal price;

    public Product(String name, java.math.BigDecimal price) {
        this.price = price;
        this.name = name;
    }

}
