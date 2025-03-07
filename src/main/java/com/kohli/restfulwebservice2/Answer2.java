package com.kohli.restfulwebservice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-details")
public class Answer2 {
    private final List<User> userList;

    public Answer2() {
        this.userList = new ArrayList<>();
    }

    @PostMapping(path = "/post", consumes = "application/xml")
    public List<User> userPost(@RequestBody User user) {
        userList.add(user);
        return userList;
    }

    @GetMapping(path = "/get", produces = "application/xml")
    public List<User> userGet() {
        return userList;
    }
}
