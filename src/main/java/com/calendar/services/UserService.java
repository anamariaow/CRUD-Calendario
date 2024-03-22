package com.calendar.services;

import com.calendar.entities.User;
import com.calendar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(User user, Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            userOpt.get().setNome(user.getNome());
            userOpt.get().setCognome(user.getCognome());
            userOpt.get().setDataDiNascita(user.getDataDiNascita());
//            userOpt.get().setCalendario(user.getCalendario());
            User userUpdate = userRepository.save(userOpt.get());
            return Optional.of(userUpdate);
        } else {
            return Optional.empty();
        }
    }

    public Optional<User> deleteUserById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            userRepository.delete(userOpt.get());
        } else {
            return Optional.empty();
        }
        return userOpt;
    }
}
