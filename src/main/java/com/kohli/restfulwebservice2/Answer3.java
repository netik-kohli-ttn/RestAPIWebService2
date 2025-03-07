package com.kohli.restfulwebservice2;

import com.kohli.restfulwebservice2.answer5.UserDetail;
import com.kohli.restfulwebservice2.answer5.UserDetailService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "RestAPI Webservice Part 2 Exercise", description = "This project is developed by Netik Kohli to enhance proficiency in REST API development."))
@RestController
@Tag(name = "Swagger Exercise - Answer 3", description = "This class provides Get, Post and Delete operations")
public class Answer3 {
    private final User user;
    private UserDetailService userDetailService;
    
    @Autowired
    Answer3(UserDetailService userDetailService, User user) {
        this.userDetailService = userDetailService;
        this.user = user;
    }

    @GetMapping("/get")
    public List<UserDetail> getUser() {

       return userDetailService.getUsersList();
    }

    @PostMapping("/post")
    public List<UserDetail> putUser(@RequestBody UserDetail userDetails) {
        return userDetailService.addUserDetail(userDetails.getName(), userDetails.getEmail(), userDetails.getAge(), userDetails.getPhoneNumber());
    }
    @DeleteMapping("/delete")
    public List<UserDetail> deleteUser(@RequestBody UserDetail userDetails) {
        return userDetailService.deleteUserDetail(userDetails.getEmail());
    }
}
