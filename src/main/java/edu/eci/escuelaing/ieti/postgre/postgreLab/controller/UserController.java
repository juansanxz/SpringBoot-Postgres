package edu.eci.escuelaing.ieti.postgre.postgreLab.controller;

import edu.eci.escuelaing.ieti.postgre.postgreLab.exception.UserNotFoundException;
import edu.eci.escuelaing.ieti.postgre.postgreLab.model.User;
import edu.eci.escuelaing.ieti.postgre.postgreLab.model.UserDto;
import edu.eci.escuelaing.ieti.postgre.postgreLab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    User createUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
            return optionalUser.get();
        else throw new UserNotFoundException();
    }

}