package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
//    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    public User getUser(String model, int series) {

        return sessionFactory.getCurrentSession().createQuery(" select u from User u WHERE u.car.model = : param1 and u.car.series = : param2", User.class)
                .setParameter("param1", model)
                .setParameter("param2", series)
                .uniqueResult();
    }
}
