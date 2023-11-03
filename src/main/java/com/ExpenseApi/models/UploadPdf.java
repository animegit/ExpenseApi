package com.ExpenseApi.models;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
@Table(name="Expenses")
public class UploadPdf {
    @Override
    public String toString() {
        return "UploadPdf{" +
                "id=" + id +
                ", pdf='" + pdf + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pdf;

    //validation to check if amount is numeric or not
    @DecimalMin(value = "0.00", message = "Amount must be a positive numeric value")
    private double amount;
    //Can be also a List for many type of expenses together
    private String type;
    //validation to check that expense description should be max 255 char and min is 1 char
    @Size(min = 1, max = 255, message = "Description must be between 1 and 255 characters")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public UploadPdf() {
    }

    public UploadPdf(Long id, String pdf, double amount, String type, String description) {
        this.id = id;
        this.pdf = pdf;
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}
