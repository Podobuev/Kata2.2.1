package hiber;

import hiber.config.AppConfig;
import hiber.dao.CarDao;
import hiber.dao.CarDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);


      UserService userService = context.getBean(UserService.class);

      System.out.println(userService.getUser("audi q3", 5693));

//      CarDao carDao = context.getBean(CarDaoImp.class);

//      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
//      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
//
//
//      Car car1 = new Car("Tesla model 3", 12345);
//      Car car2 = new Car("Tesla model 2", 98765);
//

//      user1.setCar(car1);
//      user2.setCar(car2);
//
//      userService.add(user1);
//      userService.add(user2);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("tesl 1", 1234)));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("bmw x5", 5678)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("audi q3", 5693)));
//
//
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println(user);
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

//      userService.drop();

//      context.close();
   }
}
