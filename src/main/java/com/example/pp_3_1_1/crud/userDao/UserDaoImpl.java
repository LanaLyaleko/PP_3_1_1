package com.example.pp_3_1_1.crud.userDao;

import com.example.pp_3_1_1.crud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("SELECT u FROM User u",
                User.class).getResultList();
        return users;
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User findUserById(int id){
        return entityManager.find(User.class, id);
    }
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }


    @Transactional
    @Override
    public User edit(User user) {
        return entityManager.merge(user);
    }
}