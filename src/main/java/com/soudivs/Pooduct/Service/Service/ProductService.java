package com.soudivs.Pooduct.Service.Service;

import com.soudivs.Pooduct.Service.DTO.ProductRequest;
import com.soudivs.Pooduct.Service.DTO.ProductResponse;
import com.soudivs.Pooduct.Service.Model.Product;
import com.soudivs.Pooduct.Service.Repository.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepo.save(product);
        log.info("Product {} is saved", product.getId());
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();

        return products.stream().map(x->modelMapper.map(x, ProductResponse.class)).toList();
    }




}
