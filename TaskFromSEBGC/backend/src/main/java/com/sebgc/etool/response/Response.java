package com.sebgc.etool.response;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="responses")
public class Response {
    // not required class, unless for saving responses to db (for history/statistic)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false, length=16)
    private Integer id;

    @Column(name="age_range")
    private String ageRange;

    @Column(name="is_student")
    private boolean isStudent;

    @Column(name="income_range")
    private String incomeRange;

    public Response() {
    }

    public Response(Integer id, String ageRange, boolean isStudent, String incomeRange) {
        this.id = id;
        this.ageRange = ageRange;
        this.isStudent = isStudent;
        this.incomeRange = incomeRange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public String getIncomeRange() {
        return incomeRange;
    }

    public void setIncomeRange(String incomeRange) {
        this.incomeRange = incomeRange;
    }
}
