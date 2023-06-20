package com.codingsarthak.springBootApi.controller;

import com.codingsarthak.springBootApi.model.Users;
import com.codingsarthak.springBootApi.repositories.EmployeeRepository;
import com.codingsarthak.springBootApi.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/signin")
    private String UserSignIn(@RequestBody Users users){

//        long roll_no= users.getRoll_No();

        if(!userRepository.existsById(users.getRoll_No())){
            userRepository.save(users);
            return users.getFirstName() + "SAVED";
        }
        else {
            System.out.println("Roll No already exist, Please Login to Continue");
            return "Customer Id already Exist";
        }
    }

    @GetMapping (value = "/login")
    private String UserLogin(@RequestBody Users users){

        if(userRepository.existsById(users.getRoll_No())){
            return users.getFirstName() + " LOGIN SUCCESS";
        }

        else {
            System.out.println("No Roll No exist, Please Signin to Continue");
            return "Please Sign In";
        }
    }


    @DeleteMapping(value = "/login /{id}")
    private void deleteEmployee(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
