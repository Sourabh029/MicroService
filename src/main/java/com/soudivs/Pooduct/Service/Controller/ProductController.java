package com.soudivs.Pooduct.Service.Controller;

import com.soudivs.Pooduct.Service.DTO.ProductRequest;
import com.soudivs.Pooduct.Service.DTO.ProductResponse;
import com.soudivs.Pooduct.Service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse product = productService.createProduct(productRequest);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProducts(@PathVariable String id) {
        return new ResponseEntity<>(productService.getProducts(id),HttpStatus.OK);
    }



}
