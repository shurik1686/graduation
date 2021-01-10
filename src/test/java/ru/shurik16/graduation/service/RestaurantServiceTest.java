package ru.shurik16.graduation.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.shurik16.graduation.TimingExtension;
import ru.shurik16.graduation.model.Restaurant;
import ru.shurik16.graduation.model.User;
import ru.shurik16.graduation.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.shurik16.graduation.RestaurantTestData.RESTAURANT_MATCHER;
import static ru.shurik16.graduation.RestaurantTestData.getNew;
import static ru.shurik16.graduation.RestaurantTestData.RESTAURANT_ID;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
//@ExtendWith(SpringExtension.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ExtendWith(TimingExtension.class)
class RestaurantServiceTest {

    @Autowired
    protected RestaurantService service;

    @Test
    void create() {
        Restaurant created = service.create(getNew());
        int newId = created.id();
        Restaurant restaurant = getNew();
        restaurant.setId(newId);
        RESTAURANT_MATCHER.assertMatch(created, restaurant);
        RESTAURANT_MATCHER.assertMatch(service.get(newId), restaurant);
    }

    @Test
    void delete() {
        service.delete(RESTAURANT_ID);
        assertThrows(NotFoundException.class, () -> service.get(RESTAURANT_ID));
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getWithMenu() {
    }

    @Test
    void update() {
    }
}