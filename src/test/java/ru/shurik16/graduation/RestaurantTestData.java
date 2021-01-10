package ru.shurik16.graduation;

import ru.shurik16.graduation.model.Restaurant;
import ru.shurik16.graduation.model.Role;
import ru.shurik16.graduation.model.User;

import java.util.Collections;
import java.util.Date;

import static ru.shurik16.graduation.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Restaurant.class,  "menus");

    public static final int RESTAURANT_ID = 100004;
    public static final int RESTAURANT_TWO_ID = START_SEQ + 1;
    public static final int NOT_FOUND = 10;

    public static final Restaurant restaurant = new Restaurant(RESTAURANT_ID, "Ковчег");
    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT_TWO_ID, "Вдрова");

    public static Restaurant getNew() {
        return new Restaurant(null, "New");
    }

    public static Restaurant getUpdated() {
        Restaurant updated = new Restaurant(restaurant);
        updated.setName("UpdatedName");
        return updated;
    }
}
