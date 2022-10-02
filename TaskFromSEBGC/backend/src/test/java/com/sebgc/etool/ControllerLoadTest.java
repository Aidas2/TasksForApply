package com.sebgc.etool;

import com.sebgc.etool.product.ProductController;
import com.sebgc.etool.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllerLoadTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductService productService;


    @Test
    public void contextLoads() throws Exception {
        assertThat(productController).isNotNull();
    }

    @Test
    public void contextLoadsService() throws Exception {
        assertThat(productService).isNotNull();
    }
}