package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);

   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public User getUser(String model, int series) {

      Car car = (Car) sessionFactory.getCurrentSession().createQuery("From Car where series = : param and model = :param2")
              .setParameter("param", series).setParameter("param2", model)
              .list().get(0);

      return  (User) sessionFactory.getCurrentSession().createQuery("FROM User where car.id = :param").
              setParameter("param", car.getId()).
              list().get(0);
   }


}
