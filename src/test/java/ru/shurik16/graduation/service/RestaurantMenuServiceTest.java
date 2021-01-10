package ru.shurik16.graduation.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.shurik16.graduation.TimingExtension;
import ru.shurik16.graduation.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.shurik16.graduation.MenuTestData.MENU_ID;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
//@ExtendWith(SpringExtension.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ExtendWith(TimingExtension.class)
class RestaurantMenuServiceTest {

    @Autowired
    protected RestaurantMenuService service;

    @Test
    void create() {
    }

    @Test
    void delete() {
        service.delete(MENU_ID);
        assertThrows(NotFoundException.class, () -> service.get(MENU_ID));
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
    void testGetWithMenu() {
    }

    @Test
    void update() {
    }
}