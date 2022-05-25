package com.nigmacode.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nigmacode.apirest.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery("from User", User.class);
        List<User> users = theQuery.getResultList();
        return users;
    }

    @Override
    public User findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void save(User user){
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deletedById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery("delete from User where id=:cod_caso_uso");
        theQuery.setParameter("cod_caso_uso", id);
        theQuery.executeUpdate();
    }
}
