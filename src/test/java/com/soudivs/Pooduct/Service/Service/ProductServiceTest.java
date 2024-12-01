package com.soudivs.Pooduct.Service.Service;

import com.soudivs.Pooduct.Service.DTO.ProductRequest;
import com.soudivs.Pooduct.Service.DTO.ProductResponse;
import com.soudivs.Pooduct.Service.Model.Product;
import com.soudivs.Pooduct.Service.Repository.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductServiceTest
{


    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepo repo;


    @Mock
    private ModelMapper mapper;


    @BeforeEach
    public void setup()
    {


        MockitoAnnotations.initMocks(this);

        Mockito.when(mapper.map(ArgumentMatchers.any(Product.class),ArgumentMatchers.eq(ProductResponse.class))).thenAnswer(i->{
            Product product =  i.getArgument(0);
            return ProductResponse.builder().description(product.getDescription()).name(product.getName()).price(product.getPrice()) .build();

        });

    }

    @Test
    public void getAllProductsTest()
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(Product.builder().id("ncja").description("anikdnw").price(BigDecimal.valueOf(182)).name("bnciauw").build());
        Mockito.when(repo.findAll()).thenReturn(products);
        List<ProductResponse> productResponse =  productService.getAllProducts();
        assertNotNull(productResponse);
    }


    @Test
    public void createProductTest()
    {
        Mockito.when(repo.save(ArgumentMatchers.any(Product.class))).thenReturn(Product.builder().name("AWS").price(BigDecimal.valueOf(789128)).description("This is aws service").id("anclnaiocwan").build());
        ProductResponse product = productService.createProduct(ProductRequest.builder().name("AWS").price(BigDecimal.valueOf(789128)).description("This is aws service").build());
        System.out.println(product.getName());
        assertEquals("AWS",product.getName());
    }

    @Test
    public void loadProductByProductId(){
        Mockito.when(repo.findById(ArgumentMatchers.anyString())).thenReturn(Optional.ofNullable(Product.builder().id("nsaxjn").price(BigDecimal.valueOf(123)).description("nasxnw").build()));



        ProductResponse product = productService.getProducts("asdwa");
        System.out.println(product.getName());

        assertNotNull(product);

    }

}
