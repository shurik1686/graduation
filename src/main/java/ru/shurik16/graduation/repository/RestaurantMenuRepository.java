package ru.shurik16.graduation.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.shurik16.graduation.model.Restaurant_menu;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RestaurantMenuRepository {

    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "restaurant.id");

    private final CrudRestaurantMenuRepository crudRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;

    public RestaurantMenuRepository(CrudRestaurantMenuRepository crudRepository, CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRepository = crudRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    public Restaurant_menu save(Restaurant_menu menu, int id_restaurant) {

        menu.setRestaurant(crudRestaurantRepository.getOne(id_restaurant));
        return crudRepository.save(menu);
    }

    public Restaurant_menu save(Restaurant_menu menu) {
        return crudRepository.save(menu);
    }

    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    public Restaurant_menu get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    public List<Restaurant_menu> getAll() {
        return crudRepository.findAll(SORT_NAME);
    }

    public List<Restaurant_menu> getWithMenu(LocalDateTime date, int id) {
        return crudRepository.getBetweenHalfOpen(date.withHour(0).withMinute(0).withSecond(0).withNano(0),
                date.withHour(23).withMinute(59).withSecond(59).withNano(59),
                id);
    }

    public List<Restaurant_menu> getWithMenu(LocalDateTime date) {
        return crudRepository.getBetweenHalfOpen(date.withHour(0).withMinute(0).withSecond(0).withNano(0),
                date.withHour(23).withMinute(59).withSecond(59).withNano(59));
    }
}
