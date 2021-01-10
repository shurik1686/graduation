package ru.shurik16.graduation.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shurik16.graduation.model.Restaurant;
import ru.shurik16.graduation.repository.RestaurantRepository;

import java.util.List;

import static ru.shurik16.graduation.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }


    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    public Restaurant getWithMenu(int id) {
        return repository.getWithMenu(id);
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(repository.save(restaurant), restaurant.id());
    }
}
