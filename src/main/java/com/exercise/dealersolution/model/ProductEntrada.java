package com.exercise.dealersolution.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class ProductEntrada {
    private Long id;
    private String description;
    private Long status;
    private String price;
    private Long quantity;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate deadline;

    public ProductEntrada(Long id, String description, Long status, String price, Long quantity, LocalDate deadline) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.deadline = deadline;
    }

    public ProductEntrada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", quantity=" + quantity +
                ", deadline=" + deadline +
                '}';
    }

}

