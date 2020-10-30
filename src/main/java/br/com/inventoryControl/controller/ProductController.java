package br.com.inventoryControl.controller;

import br.com.inventoryControl.Dto.ProductDto;
import br.com.inventoryControl.entities.Product;
import br.com.inventoryControl.form.ProductForm;
import br.com.inventoryControl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> insertProduct (@RequestBody ProductForm form){
        Product product = form.creationConverter();
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ProductDto> searchProducts(){
        List<Product> products = productRepository.findAll();
        return ProductDto.converter(products);
    }

    @GetMapping("/{id}")
    public List<ProductDto> searchProductById(@PathVariable Integer id){

        Optional<Product> product = productRepository.findById(id);
        return ProductDto.converterById(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody ProductForm form){

        Product product = form.updateConverter(id, productRepository);
        searchProductById(id);
        return ResponseEntity.ok(new ProductDto(product));

    }


}
