package com.sebgc.etool.product;

import com.sebgc.etool.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ProductController")
@RequestMapping(path = "products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public  ResponseEntity<List<Product>> findProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProducts());
    }

    // Solution_1 (manipulating ranges as strings):
    @GetMapping("/by-params")
    public  ResponseEntity<List<Product>> findRecommendedProductByRanges(@RequestParam final String ageRange,
                                                                    @RequestParam final boolean isStudent,
                                                                    @RequestParam final String incomeRange) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findRecommendedProductByRanges(
                ageRange, isStudent, incomeRange));
    }

    // Solution_2 (manipulating numbers as integers):
    // ABANDONED (despite it looks like more real world solution...)
    /*
    @PostMapping("/by-params-2")
    public  ResponseEntity<List<Product>> findRecommendedProductsByNumbers(@RequestParam final String ageRange,
                                                                           @RequestParam final boolean isStudent,
                                                                           @RequestParam final String incomeRange) {
                int minAge = computeMinMaxAge(ageRange, "min");
                int maxAge = computeMinMaxAge(ageRange, "max");
                int minIncome = computeMinMaxIncome(incomeRange, "min");
                int maxIncome = computeMinMaxIncome(incomeRange, "max");
        return ResponseEntity.status(HttpStatus.OK).body(productService.findRecommendedProducts(
                minAge, maxAge, minIncome, maxIncome, isStudent));
    }

    public int computeMinMaxAge(String ageRange, String flag) {
        int age = 0;
        // TODO

        return age;
    }

    public int computeMinMaxIncome(String ageRange, String flag) {
        int income = 0;
        // TODO

        return income;
    }

     */

}
