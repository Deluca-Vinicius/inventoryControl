package br.com.inventoryControl.controller;

import br.com.inventoryControl.entities.Product;
import br.com.inventoryControl.form.ProductForm;
import br.com.inventoryControl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> insertProduct (@RequestBody ProductForm form){
        Product product = form.converter();
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

}
