package br.com.inventoryControl.repository;

import br.com.inventoryControl.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
