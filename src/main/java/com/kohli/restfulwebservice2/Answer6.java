package com.kohli.restfulwebservice2;

import com.kohli.restfulwebservice2.answer5.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Answer6 {

    @Autowired
    UserDetail user;

    @GetMapping("/hateoas")
    public EntityModel<UserDetail> getUser() {
        user.setName("Netik Kohli");
        user.setEmail("netik@gmail.com");
        user.setAge(23);
        user.setPhoneNumber(980083737);

        EntityModel<UserDetail> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkToAllUsers = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(Answer6.class).getUserDetail());

        entityModel.add(linkToAllUsers.withRel("all-users"));
        return entityModel;
    }

    @GetMapping("getuser")
    public UserDetail getUserDetail() {
        return user;
    }
}

