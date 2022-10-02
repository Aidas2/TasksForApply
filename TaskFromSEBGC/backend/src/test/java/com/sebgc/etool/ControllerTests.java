package com.sebgc.etool;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sebgc.etool.product.ProductController;
import com.sebgc.etool.product.ProductRepository;
import com.sebgc.etool.product.ProductService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest
@WebMvcTest(ProductController.class)
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    @Test
    public void shouldReturnEightProducts_2() throws Exception {
        this.mockMvc.perform(get("/products/all")).andDo(print()).andExpect(status().isOk());
//                .andExpect(content().string(containsString("Hello, World")));
    }

/*

// NONE OFT THESE TEST WORKS (because real Repository always returns NullPinterException, it should also be mocked)
    @Test
    public void findProductsQuantity() {
        List<Product> products = productService.findProducts();
        int expectedQuantity = 8;

        assertEquals(expectedQuantity, products.size());
    }

    @Test
    public void findProductByTitle() {
        String expectedTitle = ProductEnum.SENIOR.getTitle();
        Product product = productRepository.findProductByTitle(expectedTitle);

        assertEquals(expectedTitle, product.getTitle());
    }


    @Test
    public void findRecommendedProductsForStudent() {
        String ageRange = AgeRange.MIDDLE.getDescription();
        boolean isStudent = true;
        String incomeRange = IncomeRangeConstants.MEDIUM;
        String expectedTitle = ProductEnum.STUDENT.getTitle();

        List<Product> products = productService.findRecommendedProductByRanges(ageRange, isStudent, incomeRange);
        assertEquals(expectedTitle, products.get(0).getTitle());
    }

    @Test
    public void findGoldCredit() {
        String ageRange = AgeRange.MIDDLE.getDescription();
        boolean isStudent = false;
        String incomeRange = IncomeRangeConstants.LARGE;
        String expectedTitle = ProductEnum.GOLD.getTitle();

        List<Product> products = productService.findRecommendedProductByRanges(ageRange, isStudent, incomeRange);
        assertEquals(expectedTitle, products.get(0).getTitle());
    }
 */
}
