package com.kohli.restfulwebservice2.answer5;

import com.kohli.restfulwebservice2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class RequestParamAnswer5 {
    private UserDetailService user;

    @Autowired
    public RequestParamAnswer5(UserDetailService user) {
        this.user = user;
    }

    @GetMapping(value = "/details", params = "version=1")
    public User getUserV1() {
        return user.lessDetails();
    }

    @GetMapping(value = "/details", params = "version=2")
    public UserDetail getUserV2() {
        return user.moreDetails();
    }
}

