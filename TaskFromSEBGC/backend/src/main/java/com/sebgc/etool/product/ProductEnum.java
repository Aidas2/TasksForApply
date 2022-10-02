package com.sebgc.etool.product;

public enum ProductEnum {

    CURRENT("Current Account", "Income > 0 & Age > 17"),
    CURRENT_PLUS( "Current Account Plus", "Income > 40000 & Age > 17"),
    JUNIOR("Junior Saver Account", "Age < 18"),
    STUDENT("Student Account", "Student = Yes & Age > 17"),
    SENIOR("Senior Account", "Age >= 65"),
    DEBIT("Debit Card", "Income < 12001 & Age > 17"),
    CREDIT("Credit Card", "Income > 12000 & Age > 17"),
    GOLD("Gold Credit", "Card Income > 40000 & Age > 17");

    String title;
    String description;

    ProductEnum(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
