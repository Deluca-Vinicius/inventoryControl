package br.com.inventoryControl.controller;


import br.com.inventoryControl.entities.Company;
import br.com.inventoryControl.form.CompanyForm;
import br.com.inventoryControl.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping
    public List<Company> searchCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    @PostMapping
    public ResponseEntity<Company> insertCompany(@RequestBody CompanyForm form) {
        Company company = form.creationConverter();
        companyRepository.save(company);
        return ResponseEntity.ok().build();

    }
}
