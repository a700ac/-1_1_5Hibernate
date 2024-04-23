package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.entity.User;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Util util = new Util();

        UserDao userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

        List<User> arr = new ArrayList<>();
        arr.add(new User("Name1", "LastName1", (byte) 20));
        arr.add(new User("Name2", "LastName2", (byte) 25));
        arr.add(new User("Name3", "LastName3", (byte) 31));
        arr.add(new User("Name4", "LastName4", (byte) 38));
        for (User user: arr) {
            userDaoHibernate.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        }
      userDaoHibernate.removeUserById(1);
      userDaoHibernate.getAllUsers();
      userDaoHibernate.cleanUsersTable();
      userDaoHibernate.dropUsersTable();

    }
}
