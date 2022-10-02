package com.sebgc.etool.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Solution_1 (manipulating ranges as strings):
    Product findProductByTitle(String title);

    // Solution_2 (manipulating numbers as integers):
    /*
    @Query("SELECT p FROM products p WHERE p.minAge = :minAge AND p.maxAge = :maxAge AND " +
            "p.minIncome = :minIncome AND p.maxIncome = :maxIncome AND " +
            "p.isStudent = :isStudent")
    List<Product> findRecommendedProducts(
            @Param("minAge") Integer minAge,
            @Param("maxAge") Integer maxAge,
            @Param("minIncome") Integer minIncome,
            @Param("maxIncome") Integer maxIncome,
            @Param("isStudent") boolean isStudent);

     */
}
