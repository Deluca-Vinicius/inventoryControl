package br.com.inventoryControl.repository;

import br.com.inventoryControl.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCompanyId(Integer companyId);

    List<Product> findByProductCompanyId(Integer productCompanyId);
}
