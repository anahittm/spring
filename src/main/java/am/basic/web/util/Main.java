package am.basic.web.util;
import am.basic.web.model.Action;
import am.basic.web.model.Card;
import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryIMPL;
import am.basic.web.repository.UserRepositoryIMPLJdbc;
import am.basic.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) throws SQLException {
//        UserRepositor userRepository = new UserRepositoryImpl();
//        User user = userRepository.getById(10);
        //   System.out.println(user);
        // userRepository.Delete(user);
        //   userRepository.getByUsername("juki");
        //  User user1=userRepository.getById(2);
//        user1.setAge(100);
//        userRepository.update(user1);
//
//        User user1 = new User();
//        user1.setAge(22);
//        user1.setName("jhgfdsa");
//        Card card = new Card();
//        card.setId(2);
//        card.setName("naa");
//        card.setNumber("wd1234");
//        user1.setCard(card);
//        //userRepository.add(user1);
//        User user2 = userRepository.getById(26);
////        System.out.println(1);
////        System.out.println(user2.getCard());
////
//        Action action = new Action();
//        Action action1 = new Action();
//        action.setName("gfdsaa");
//        action1.setName("adsf");
//        action.setDescription("hgfdsa");
//        action1.setDescription("jhgfdsa");
//        List<Action> actions = Arrays.asList(action, action1);
//        user2.setAction(actions);
//     //   userRepository.update(user2);
//        User fromdb=userRepository.getById(26);
//        System.out.println(fromdb);
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println(1);
        UserService userService=  applicationContext.getBean(UserService.class);
        System.out.println(2);
        UserService userService1=  applicationContext.getBean(UserService.class);
        System.out.println(userService);
        System.out.println(userService1);
        User user=userService.getByUsername("jhgfds");
        System.out.println(userService.getUserRepository());
        System.out.println(userService1.getUserRepository());
    }
    //THIS IS DEV BRANCH
}