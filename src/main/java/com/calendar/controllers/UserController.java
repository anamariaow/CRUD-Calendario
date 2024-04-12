package com.calendar.controllers;

import com.calendar.entities.Evento;
import com.calendar.entities.User;
import com.calendar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> postUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.addUser(user));
    }
    @GetMapping("/userlist")
    public ResponseEntity<List<User>> getUserList(){
        return ResponseEntity.ok().body(userService.getUserList());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> userOpt = userService.getUser(id);
        if(userOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userOpt.get());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        Optional<User> userOpt = userService.updateUser(user ,id);
        if(userOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userOpt.get());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id){
        Optional<User> userOpt = userService.deleteUserById(id);
        if(userOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userOpt.get());
    }
}
