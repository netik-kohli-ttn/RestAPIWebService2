package com.kohli.restfulwebservice2.answer5;

import com.kohli.restfulwebservice2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
    private final UserDetail userDetail;
    private final User user;
    @Autowired
    public UserDetailService(User user) {
        this.user = user;
        this.userDetail = new UserDetail();
    }
     public User lessDetails(){
         user.setName("Netik Kohli");
         user.setAge(24);
         return user;
     }
     public UserDetail moreDetails(){
         userDetail.setName("Netik Kohli");
         userDetail.setAge(24);
         userDetail.setEmail("netik@gmail.com");
         userDetail.setPhoneNumber(987244445);
         return userDetail;
     }
}
