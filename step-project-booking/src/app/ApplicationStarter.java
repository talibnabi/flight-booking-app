package app;

import controller.concretes.FlightControllerManager;
import dao.abstracts.DAO;
import dao.concretes.UserDAOManager;
import entity.User;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class ApplicationStarter {
    private static final DAO<User> userDAO = new UserDAOManager();
    private static final FlightControllerManager flightControllerManager = new FlightControllerManager();

    public static void main(String[] args)  {
//        System.out.println(flightControllerManager.showFlightById(1));
//        flightControllerManager.fillFlight();
//        flightControllerManager.showAllFlight().forEach(System.out::println);
//        ApplicationStarter starter = new ApplicationStarter();
//        String line = starter.readLine();
//        System.out.println(line);
//        User user = new User("Sahin", "Mehriban");
//        User user1 = new User("Sahin", "Mehriban");
//        User user2 = new User("Sahin", "Mehriban");
//        User user3 = new User("Sahin", "Mehriban");
//        create(user);
//        create(user1);
//        create(user2);
//        create(user3);
//        getAll().orElseThrow().forEach(System.out::println);
//        System.out.println();
//        System.out.println(getById(21).orElseThrow());
    }


    public String readLine() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input.trim();
    }

    public String read() {
        Scanner sc = new Scanner(System.in);
        return sc.next().trim();
    }

    private static Boolean create(User user) {
        return userDAO.create(user);
    }

    private static Boolean delete(int id) {
        return userDAO.delete(id);
    }

    private static Optional<List<User>> getAll() {
        return userDAO.getAll();
    }

    private static Optional<User> getById(int id) {
        return userDAO.getById(id);
    }
}
