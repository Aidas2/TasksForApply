package com.sebgc.etool.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sebgc.etool.product.IncomeRangeConstants.*;

@Service("SurveyService")
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    // Solution_1 (manipulating ranges as strings):
    public List<Product> findRecommendedProductByRanges(String ageRange, boolean isStudent, String incomeRange) {
        // restore plus sign
        if (ageRange.contains(" ")) {
            ageRange = ageRange.replace(" ", "+");
        };
        if (incomeRange.contains(" ")) {
            incomeRange = incomeRange.replace(" ", "+");
        };

        return this.compute(ageRange, isStudent, incomeRange);
    }

    public List<Product> compute(String ageRange, Boolean isStudent, String incomeRange) {
        // this looks like semi-hardcoded ...
        List<Product> recommendedProducts = new ArrayList<>();
        if (ageRange.equals(AgeRange.YOUNG.description)) {
            recommendedProducts.add(productRepository.findProductByTitle(ProductEnum.JUNIOR.title));
            return recommendedProducts;
        }
        if (ageRange.equals(AgeRange.SENIOR.description)) {
            recommendedProducts.add(productRepository.findProductByTitle(ProductEnum.SENIOR.title));
            return recommendedProducts;
        }
        if (ageRange.equals(AgeRange.MIDDLE.description) && isStudent == true) {
            recommendedProducts.add(productRepository.findProductByTitle(ProductEnum.STUDENT.title));
            return recommendedProducts;
        };
        if (ageRange.equals(AgeRange.MIDDLE.description)) {
            switch (incomeRange) {
                case ZERO:
                    recommendedProducts.add(productRepository.findProductByTitle(ProductEnum.CURRENT.title));
                    return recommendedProducts;
                case SMALL:
                    recommendedProducts.add(productRepository.findProductByTitle(ProductEnum.DEBIT.title));
                    return recommendedProducts;
                case MEDIUM:
                    recommendedProducts.add(productRepository.findProductByTitle(ProductEnum.CREDIT.title));
                    return recommendedProducts;
                case LARGE:
                    recommendedProducts.add(productRepository.findProductByTitle(ProductEnum.CURRENT_PLUS.title));
                    recommendedProducts.add(productRepository.findProductByTitle(ProductEnum.GOLD.title));
                    return recommendedProducts;
                default:
                    return recommendedProducts;
            }
        };
        return recommendedProducts;
    }

    // Solution_2 (manipulating numbers as integers):
    /*
    public List<Product> findRecommendedProducts(Integer minAge, Integer maxAge, Integer minIncome, Integer maxIncome, boolean isStudent) {
        List<Product> products = productRepository.findRecommendedProducts(minAge, maxAge, minIncome, maxIncome, isStudent);
        return products;
    }

     */
}
