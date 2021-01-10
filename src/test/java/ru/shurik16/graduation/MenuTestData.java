package ru.shurik16.graduation;

import ru.shurik16.graduation.model.Restaurant;
import ru.shurik16.graduation.model.Restaurant_menu;

import java.time.LocalDateTime;

import static ru.shurik16.graduation.model.AbstractBaseEntity.START_SEQ;

public class MenuTestData {
    public static final TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Restaurant.class,  "menus");

    public static final int MENU_ID = 100010;
    public static final int MENU_TWO_ID = START_SEQ + 1;
    public static final int NOT_FOUND = 10;

    public static final Restaurant_menu menu = new Restaurant_menu(MENU_ID, "New1", LocalDateTime.now().withHour(10).withMinute(0).withSecond(0).withNano(0),"900",new Restaurant(100003,"Test"));
    public static final Restaurant_menu menu1 = new Restaurant_menu(MENU_TWO_ID, "New2", LocalDateTime.now().withHour(10).withMinute(0).withSecond(0).withNano(0),"700",new Restaurant(100003,"Test"));

    public static Restaurant_menu getNew() {
        return new Restaurant_menu(null, "New", LocalDateTime.now().withHour(10).withMinute(0).withSecond(0).withNano(0),"800",new Restaurant(100003,"Test"));
    }

    public static Restaurant_menu getUpdated() {
        Restaurant_menu updated = new Restaurant_menu(menu);
        updated.setName("UpdatedName");
        return updated;
    }
}
