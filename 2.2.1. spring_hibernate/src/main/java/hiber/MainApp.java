package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Vasiliy", "Ivanov", "vasyaivaon77@mail.ru");
        user1.setCar(new Car(user1, "Lada", 2114));


        User user2 = new User("Alexey", "Kukushkin", "alexku123@yandex.ru");
        user2.setCar(new Car(user2, "UAZ", 2206));

        userService.add(user1);
        userService.add(user2);

        userService.listUsers().forEach(System.out::println);

        System.out.println(userService.getUserByCar("UAZ", 2206));

        context.close();
    }
}
