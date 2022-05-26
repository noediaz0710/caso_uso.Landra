package com.nigmacode.apirest.service;

import java.util.List;

import com.nigmacode.apirest.entity.User;

public interface UserService {
    public List<User> findAll();

    public User findById(int id);

    public void save(User user);
    public User findByNombre(String nombre_caso_uso);
    public void deleteById(int id);
}
