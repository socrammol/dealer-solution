package com.exercise.dealersolution.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Long status;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "deadline")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate deadline;

    public ProductEntity(Long id, String description, Long status, Double price, Long quantity, LocalDate deadline) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.deadline = deadline;
    }

    public ProductEntity() {
    }

    public ProductEntity(ProductEntrada productEntrada) {
        if(productEntrada.getId() != null){
            this.id = productEntrada.getId();
        }
        this.deadline = productEntrada.getDeadline();
        this.description = productEntrada.getDescription();
        this.quantity = productEntrada.getQuantity();
        this.status = productEntrada.getStatus();
        this.price = Double.valueOf(productEntrada.getPrice().replaceAll(",",""));
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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

    public LocalDate getDeadline() {
        return deadline;
    }
}
