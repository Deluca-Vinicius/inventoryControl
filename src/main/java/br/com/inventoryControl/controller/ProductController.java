package br.com.inventoryControl.controller;

import br.com.inventoryControl.Dto.ProductDto;
import br.com.inventoryControl.entities.Product;
import br.com.inventoryControl.form.ProductForm;
import br.com.inventoryControl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody ProductForm form) {
        Product product = form.creationConverter();
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ProductDto> searchProducts() {
        List<Product> products = productRepository.findAll();
        return ProductDto.converter(products);
    }

    //Verificar possibilidade de fundir os gets em um único com uma validação
    @GetMapping("/company/{companyId}")
    public List<ProductDto> searchProductsByCompany(@PathVariable Integer companyId) {
        List<Product> products = productRepository.findByCompanyId(companyId);
        return ProductDto.converter(products);
    }

    @GetMapping("/productCompanyId/{productCompanyId}")
    public List<ProductDto> searchProductsByProductCompanyId(@PathVariable Integer productCompanyId) {
        List<Product> product = productRepository.findByProductCompanyId(productCompanyId);
        return ProductDto.converter(product);
    }
    @GetMapping("/{id}")
    public List<ProductDto> searchProductById(@PathVariable Integer id){
        Optional<Product> product = productRepository.findById(id);
        return ProductDto.converterById(product);
    }

    @PutMapping("/update/{productCompanyId}")
    @Transactional
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer productCompanyId, @RequestBody ProductForm form) {


        Product product = form.updateConverter(productCompanyId, productRepository, form);
        searchProductsByProductCompanyId(productCompanyId);
        return ResponseEntity.ok(new ProductDto(product));

    }


}
