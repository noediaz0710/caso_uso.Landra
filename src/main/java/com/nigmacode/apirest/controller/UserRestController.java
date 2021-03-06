package com.nigmacode.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nigmacode.apirest.entity.User;
import com.nigmacode.apirest.service.UserService;

//Incicamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/

public class UserRestController {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private UserService userService;

    /*Este método ser hará cuando por una petición GET(como indica la anotacion)
    se llame a la url http://127.0.0.1:8080/api/users
    */
    @GetMapping("/users")
    public List<User> findAll() {

        //retornará todos los usuarios
        return userService.findAll();
    }

    /*Este método ser hará cuando por una petición GET(como indica la anotacion)
    se llame a la url http://127.0.0.1:8080/api/users/1
    */
    @GetMapping("/users/id/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.findById(userId);

        if(user==null) {
            throw new RuntimeException("User id not found -" +userId);
        }
        //retornará al usuario con id pasado en la url
        return user;
    }


    /*Este método ser hará cuando por una petición GET(como indica la anotacion)
    se llame a la url http://127.0.0.1:8080/api/users
    */
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setCod_caso_uso(0);

        //Este metodo guardará al usario enviado
        userService.save(user);

        return user;
    }



    /*Este método ser hará cuando por una petición GET(como indica la anotacion)
    se llame a la url http://127.0.0.1:8080/api/users
    */
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.save(user);

        //este metodo actualizará al usuario enviado

        return user;
    }

    /*Este método ser hará cuando por una petición GET(como indica la anotacion)
    se llame a la url http://127.0.0.1:8080/api/users/1
    */
    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable int userId){
        User user = userService.findById(userId);

        if (user==null){
         throw new RuntimeException("User id not found -"+userId);
        }
        userService.deleteById(userId);

        //Este método, recibirá el ide de un usuario por URL y se borrará de la bd.
        return "Delete user id -"+userId;
    }
    @GetMapping("users/{nombre_caso_uso}")
    public User getNombreCasoUso(@PathVariable String nombre_caso_uso){
        User user = userService.findByNombre(nombre_caso_uso);

        if (user==null){
            throw new RuntimeException("Nombre caso de uso not found -"+nombre_caso_uso);
        }

        //Este método, recibirá el ide de un usuario por URL y se borrará de la bd.
        return user;
    }

}
