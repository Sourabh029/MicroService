package com.soudivs.Pooduct.Service.Service;

import com.soudivs.Pooduct.Service.DTO.ProductRequest;
import com.soudivs.Pooduct.Service.DTO.ProductResponse;
import com.soudivs.Pooduct.Service.Exception.ResourceNotFoundException;
import com.soudivs.Pooduct.Service.Model.Product;
import com.soudivs.Pooduct.Service.Repository.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(UUID.randomUUID().toString())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        Product save = productRepo.save(product);
        log.info("Product {} is saved", product.getId());
        return modelMapper.map(save, ProductResponse.class);
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();

        return products.stream().map(x->modelMapper.map(x, ProductResponse.class)).toList();
    }


    public ProductResponse getProducts(String id) {
        Product product = productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("resource not found with ID = "+id,"Produt Service"));

        return modelMapper.map(product, ProductResponse.class);

    }
}
