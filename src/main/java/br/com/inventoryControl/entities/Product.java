package br.com.inventoryControl.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int price;

    public Product() {

    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
