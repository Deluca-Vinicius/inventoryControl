package br.com.inventoryControl.repository;

import br.com.inventoryControl.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
