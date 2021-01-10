package ru.shurik16.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("date DESC")
    @JsonIgnore
    private List<Restaurant_menu> menus;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id,name);
    }

    public Restaurant(String name) {
        this(new Restaurant(null,name));
    }

    public Restaurant(Restaurant restaurant) {
        this(restaurant.getId(),restaurant.getName());
    }

    public List<Restaurant_menu> getRestaurant_menus() {
        return menus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
