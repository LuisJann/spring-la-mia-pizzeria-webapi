package org.learning.springlamiapizzeriacrud.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private LocalDate startDiscount;
    private LocalDate endDiscount;

    @ManyToOne
    private Pizza pizza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDiscount() {
        return startDiscount;
    }

    public void setStartDiscount(LocalDate startDiscount) {
        this.startDiscount = startDiscount;
    }

    public LocalDate getEndDiscount() {
        return endDiscount;
    }

    public void setEndDiscount(LocalDate endDiscount) {
        this.endDiscount = endDiscount;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
