package ru.shurik16.graduation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.shurik16.graduation.model.Role;
import ru.shurik16.graduation.model.User;
import ru.shurik16.graduation.web.user.AdminRestController;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management (ARM)
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(new String[]{"spring/spring-app.xml", "spring/spring-db.xml"})) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            List<User> userList = adminUserController.getAll();
            for (User user : userList)
                System.out.println(user);
            adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ADMIN));
            adminUserController.create(new User(null, "userName1", "email@mail.ru", "password", Role.ADMIN));
            adminUserController.create(new User(null, "userName2", "email@mail.ru", "password", Role.ADMIN));
            adminUserController.create(new User(null, "userName3", "email@mail.ru", "password", Role.ADMIN));
            for (User user : userList)
                System.out.println(user);
        }
    }
}
