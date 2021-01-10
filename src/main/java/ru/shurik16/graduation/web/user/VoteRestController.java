package ru.shurik16.graduation.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.shurik16.graduation.model.Restaurant_menu;
import ru.shurik16.graduation.model.Vote;
import ru.shurik16.graduation.service.RestaurantMenuService;
import ru.shurik16.graduation.service.VoteService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class VoteRestController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService service;

    public List<Vote> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Vote get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public Vote create(Vote vote) {
        log.info("create {}", vote);
        return service.create(vote);
    }

    public Vote create(int id_restaurant) {
        log.info("create vote {}", id_restaurant);
        return service.create(id_restaurant);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Vote vote, int id) {
        log.info("update {} with id={}", vote, id);
        service.update(vote);
    }
}
