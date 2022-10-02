package com.sebgc.etool.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false, length=16)
    private Integer id;

    @Column(name="title")
    private String title;

//    @Column(name="age_range")
//    private String angeRange;
//
//    @Column(name="min_age")
//    private Integer minAge;
//
//    @Column(name="max_age")
//    private Integer maxAge;
//
//    @Column(name="is_student")
//    private boolean isStudent;
//
//    @Column(name="income_range")
//    private String incomeRange;
//
//    @Column(name="min_income")
//    private Integer minIncome;
//
//    @Column(name="max_income")
//    private Integer maxIncome;

    @Column(name="description")
    private String description;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String title, String angeRange, Integer minAge, Integer maxAge, boolean isStudent,
                   String incomeRange, Integer minIncome, Integer maxIncome, String description) {
        this.id = id;
        this.title = title;
//        this.angeRange = angeRange;
//        this.minAge = minAge;
//        this.maxAge = maxAge;
//        this.isStudent = isStudent;
//        this.incomeRange = incomeRange;
//        this.minIncome = minIncome;
//        this.maxIncome = maxIncome;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getAngeRange() {
//        return angeRange;
//    }
//
//    public void setAngeRange(String angeRange) {
//        this.angeRange = angeRange;
//    }
//
//    public Integer getMinAge() {
//        return minAge;
//    }
//
//    public void setMinAge(Integer minAge) {
//        this.minAge = minAge;
//    }
//
//    public Integer getMaxAge() {
//        return maxAge;
//    }
//
//    public void setMaxAge(Integer maxAge) {
//        this.maxAge = maxAge;
//    }
//
//    public boolean isStudent() {
//        return isStudent;
//    }
//
//    public void setStudent(boolean student) {
//        isStudent = student;
//    }
//
//    public String getIncomeRange() {
//        return incomeRange;
//    }
//
//    public void setIncomeRange(String incomeRange) {
//        this.incomeRange = incomeRange;
//    }
//
//    public Integer getMinIncome() {
//        return minIncome;
//    }
//
//    public void setMinIncome(Integer minIncome) {
//        this.minIncome = minIncome;
//    }
//
//    public Integer getMaxIncome() {
//        return maxIncome;
//    }
//
//    public void setMaxIncome(Integer maxIncome) {
//        this.maxIncome = maxIncome;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
