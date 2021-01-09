package ru.shurik16.graduation.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.shurik16.graduation.model.Restaurant;
import ru.shurik16.graduation.model.User;
import ru.shurik16.graduation.service.RestaurantService;
import ru.shurik16.graduation.service.UserService;

import java.util.List;

@Controller
public class RestaurantRestController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService service;

    public List<Restaurant> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Restaurant getWithMenu(int id) {
        log.info("getWithMenu");
        return service.getWithMenu(id);
    }


    public Restaurant get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public Restaurant create(Restaurant restaurant) {
        log.info("create {}", restaurant);
        //checkNew(user);
        return service.create(restaurant);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Restaurant restaurant, int id) {
        log.info("update {} with id={}", restaurant, id);
        //assureIdConsistent(user, id);
        service.update(restaurant);
    }
}
