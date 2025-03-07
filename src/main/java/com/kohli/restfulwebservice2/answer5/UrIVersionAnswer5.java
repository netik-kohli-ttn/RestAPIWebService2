package com.kohli.restfulwebservice2.answer5;

import com.kohli.restfulwebservice2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UrIVersionAnswer5 {
    private UserDetailService user;

    @Autowired
    public UrIVersionAnswer5(UserDetailService user) {
        this.user = user;
    }

    @GetMapping(value = "/v1/details")
    public User getUserV1Uri() {
        return user.lessDetails();
    }

    @GetMapping(value = "/v2/details")
    public UserDetail getUserV2Uri() {
        return user.moreDetails();
    }
}
