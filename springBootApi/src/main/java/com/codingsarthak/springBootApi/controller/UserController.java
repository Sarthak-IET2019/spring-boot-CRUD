package com.codingsarthak.springBootApi.controller;

import com.codingsarthak.springBootApi.model.Users;
import com.codingsarthak.springBootApi.repositories.EmployeeRepository;
import com.codingsarthak.springBootApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/signin")
    private Users addEmployee(@RequestBody Users users){

//        long roll_no= users.getRoll_No();
//        if(userRepository.existsById(roll_no))
//            return Exception;
//            UserAlreadyExistException = new UserAlreadyExistException(roll_no)
//            return u ;
//
//        }
//        else

        return userRepository.save(users);
    }
}
