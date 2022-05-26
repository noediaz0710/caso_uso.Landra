package com.nigmacode.apirest.dao;

import java.util.List;

import com.nigmacode.apirest.entity.User;

import javax.transaction.Transactional;

public interface UserDAO {
    public List<User> findAll();

    public User findById(int id);


    public void save(User user);

    public void deletedById(int id);
    public User findByNombre(String nombre_caso_uso);
    @Transactional
    void deletedById(String nombre_caso_uso);
}
