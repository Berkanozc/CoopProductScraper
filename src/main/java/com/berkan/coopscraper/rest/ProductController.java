package com.berkan.coopscraper.rest;

import com.berkan.coopscraper.exceptions.ProductNotFoundException;
import com.berkan.coopscraper.models.Product;
import com.berkan.coopscraper.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{productCode}")
    public ResponseEntity<Object> getProductByCode(@PathVariable String productCode) {

        if (productCode == null) {
            // When no product code is given no products can be fetched from the website
            return ResponseEntity.badRequest().body("No product code given");
        }

        // Try to scrape product
        Product foundProduct = productRepository.findByProductCode(productCode);

        if (foundProduct == null) {
            // When no product is found throw a ProductNotFoundException
            throw new ProductNotFoundException("No product found with code:" + productCode);
        }

        // When product is found return product with a ok status
        return ResponseEntity.ok(foundProduct);
    }

}
