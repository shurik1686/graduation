package ru.shurik16.graduation.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.shurik16.graduation.model.Restaurant_menu;
import ru.shurik16.graduation.service.RestaurantMenuService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MenuRestController11 {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantMenuService service;

    public List<Restaurant_menu> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public List<Restaurant_menu> getMenuRestaurant(int id) {
        log.info("getMenuRestaurant");
        return service.getWithMenu(LocalDateTime.now(), id);
    }

    public List<Restaurant_menu> getMenu() {
        log.info("getMenu");
        return service.getWithMenu(LocalDateTime.now());
    }


    public Restaurant_menu get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public Restaurant_menu create(Restaurant_menu menu) {
        log.info("create {}", menu);
        return service.create(menu);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Restaurant_menu menu, int id) {
        log.info("update {} with id={}", menu, id);
        service.update(menu);
    }
}
