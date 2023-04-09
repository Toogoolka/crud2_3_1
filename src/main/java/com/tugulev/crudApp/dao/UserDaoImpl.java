package com.tugulev.crudApp.dao;

import com.tugulev.crudApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
//    private EntityManager entityManager;
//    @Autowired
//    public UserDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//
//    public List<User> getAllUsers() {
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("from User");
//        entityManager.getTransaction().commit();
//        return query.getResultList();
//    }
//
//    public void add(User user) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();
//    }

}
