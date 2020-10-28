package br.com.inventoryControl.entities;

import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table
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


    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }
}
