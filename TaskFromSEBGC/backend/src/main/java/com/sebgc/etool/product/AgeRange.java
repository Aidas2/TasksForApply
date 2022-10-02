package com.sebgc.etool.product;

public enum AgeRange {
    YOUNG("0-17"),
    MIDDLE("18-64"),
    SENIOR("65+");

    String description;

    AgeRange(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}

