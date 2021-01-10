package ru.shurik16.graduation.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shurik16.graduation.model.Restaurant_menu;
import ru.shurik16.graduation.repository.RestaurantMenuRepository;

import java.time.LocalDateTime;
import java.util.List;

import static ru.shurik16.graduation.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantMenuService {

    private final RestaurantMenuRepository repository;

    public RestaurantMenuService(RestaurantMenuRepository repository) {
        this.repository = repository;
    }

    public Restaurant_menu create(Restaurant_menu restaurant_menu) {
        Assert.notNull(restaurant_menu, "restaurant_menu must not be null");
        return repository.save(restaurant_menu);
    }

    public Restaurant_menu create(Restaurant_menu restaurant_menu, int id_restaurant) {
        Assert.notNull(restaurant_menu, "restaurant_menu must not be null");
        return repository.save(restaurant_menu, id_restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Restaurant_menu get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }


    public List<Restaurant_menu> getAll() {
        return repository.getAll();
    }

    public List<Restaurant_menu> getWithMenu(LocalDateTime date, int id) {
        return repository.getWithMenu(date, id);
    }

    public List<Restaurant_menu> getWithMenu(LocalDateTime date) {
        return repository.getWithMenu(date);
    }

    public void update(Restaurant_menu restaurant_menu) {
        Assert.notNull(restaurant_menu, "restaurant_menu must not be null");
        checkNotFoundWithId(repository.save(restaurant_menu), restaurant_menu.id());
    }
}
