package com.kohli.restfulwebservice2.answer5;

import com.kohli.restfulwebservice2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class MimeTypeAnswer5 {
    private UserDetailService user;

    @Autowired
    public MimeTypeAnswer5(UserDetailService user) {
        this.user = user;
    }

    @GetMapping(value = "/details", produces = "application/vnd.company.app-v1+json")
    public User getUserV1() {
        return user.lessDetails();
    }

    @GetMapping(value = "/details", produces = "application/vnd.company.app-v2+json")
    public UserDetail getUserV2() {
        return user.moreDetails();
    }
}

