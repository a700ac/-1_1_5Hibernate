package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.entity.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;



public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }



    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users(" +
                "ID BIGINT NOT NULL AUTO_INCREMENT, NAME VARCHAR(45), " +
                "LASTNAME VARCHAR(45), AGE TINYINT, PRIMARY KEY (ID) )";
        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        User user = new User(name, lastName, age);
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id){
        Transaction transaction = null;
        User user = new User();
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            }
        }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        User user = new User();
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<User> emp = session.createQuery("from User").getResultList();
            for(User e: emp) {
                System.out.println(e);
            }
            transaction.commit();
            return emp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        User user = new User();
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}