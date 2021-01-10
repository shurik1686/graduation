package ru.shurik16.graduation.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "restaurant_menu")
public class Restaurant_menu extends AbstractNamedEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDateTime date;

    @Column(name = "price", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @NotNull
    @JsonIgnore
    private Restaurant restaurant;

    public Restaurant_menu(Integer id, String name, @NotNull LocalDateTime date, @NotBlank @Size(min = 2, max = 120) String price, Restaurant restaurant) {
        super(id, name);
        this.date = date;
        this.price = price;
        this.restaurant = restaurant;
    }

    public Restaurant_menu(Restaurant_menu menu) {
        this(menu.id,menu.name,menu.date,menu.price,menu.restaurant);
    }

    public Restaurant_menu(String name, @NotNull LocalDateTime date, @NotBlank @Size(min = 2, max = 120) String price, Restaurant restaurant) {
        this(new Restaurant_menu(null, name, date, price, restaurant));
    }

    public Restaurant_menu() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Restaurant_menu{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
