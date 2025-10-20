package com.example.productapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;


@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // get product by id
    @GetMapping("/{id}")
    public Optional<Product> getProductById (@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // create product
    @PostMapping
    public Product createProduct(@PathVariable Product product){
        return productRepository.save(product);
    }

    // update product
    @PutMapping("/{id}")
    public Product updateProduct (@PathVariable Long id , @RequestBody Product product){
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            return productRepository.save(productToUpdate);
        }
        return null;
    }

}


