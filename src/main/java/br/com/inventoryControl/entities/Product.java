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
    int productCompanyId; //product code in company receipt, making easier later updates

    @NotNull
    String name;

    @NotNull
    java.math.BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private Company companyId;// identification of where it was purchased

    public Product(String name, java.math.BigDecimal price, int productCompanyId, Company companyId) {

        this.price = price;
        this.name = name;
        this.productCompanyId = productCompanyId;
        this.companyId = companyId;
    }

}
