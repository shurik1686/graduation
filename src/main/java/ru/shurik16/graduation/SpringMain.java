package ru.shurik16.graduation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.shurik16.graduation.model.Restaurant;
import ru.shurik16.graduation.model.Restaurant_menu;
import ru.shurik16.graduation.model.Role;
import ru.shurik16.graduation.model.User;
import ru.shurik16.graduation.service.RestaurantMenuService;
import ru.shurik16.graduation.web.user.AdminRestController;
import ru.shurik16.graduation.web.user.MenuRestController;
import ru.shurik16.graduation.web.user.RestaurantRestController;
import ru.shurik16.graduation.web.user.VoteRestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management (ARM)
/*        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(new String[]{"spring/spring-app.xml", "spring/spring-db.xml"})) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            RestaurantRestController restaurantRestController = appCtx.getBean(RestaurantRestController.class);
            MenuRestController menuRestController = appCtx.getBean(MenuRestController.class);
            VoteRestController voteRestController = appCtx.getBean(VoteRestController.class);
            List<User> userList = adminUserController.getAll();
            userList.forEach(System.out::println);
            adminUserController.create(new User(null, "userName", "email@mail5.ru", "password", Role.ADMIN));
            adminUserController.getAll().forEach(System.out::println);
            adminUserController.update(new User(100015, "userNameSSS", "email@mail5.ru", "password", Role.ADMIN),100015);
            adminUserController.getAll().forEach(System.out::println);
            //adminUserController.delete(100000);
            adminUserController.getAll().forEach(System.out::println);
            restaurantRestController.getAll().forEach(System.out::println);
            restaurantRestController.create(new Restaurant("Чин Чин"));
            restaurantRestController.getAll().forEach(System.out::println);
            System.out.println(restaurantRestController.getWithMenu(100003).getRestaurant_menus());
            restaurantRestController.update(new Restaurant(100002,"Чин Чин111"),100002);
            restaurantRestController.getAll().forEach(System.out::println);
            menuRestController.getAll().forEach(System.out::println);
            System.out.println(menuRestController.get(100011));
            menuRestController.getMenuRestaurant(100002).forEach(System.out::println);
            menuRestController.create(new Restaurant_menu("Шаурма", LocalDateTime.now(),"500",new Restaurant(100002,"Помидор")));
            menuRestController.getMenuRestaurant(100002).forEach(System.out::println);
            menuRestController.update(new Restaurant_menu(100010,"Шаурма", LocalDateTime.now(),"500",new Restaurant(100002,"Помидор")),100010);
            menuRestController.getAll().forEach(System.out::println);
            voteRestController.getAll().forEach(System.out::println);
            voteRestController.create(100004);
            voteRestController.getAll().forEach(System.out::println);
            voteRestController.delete(100013);
            voteRestController.getAll().forEach(System.out::println);
        }*/
    }
}
