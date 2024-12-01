package com.soudivs.Pooduct.Service;


import com.jayway.jsonpath.JsonPath;
import com.soudivs.Pooduct.Service.Controller.ProductController;
import com.soudivs.Pooduct.Service.DTO.ProductResponse;
import com.soudivs.Pooduct.Service.Model.Product;
import com.soudivs.Pooduct.Service.Repository.ProductRepo;
import com.soudivs.Pooduct.Service.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.stubbing.OngoingStubbing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.net.ssl.SSLEngineResult;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest
@WebMvcTest(ProductController.class)
@SpringBootTest
public class ControllerTests {






//    @Test
//    public void Test()
//    {
//        String text = "Java";
//        assertEquals("Java",text);
//
//    }



}
