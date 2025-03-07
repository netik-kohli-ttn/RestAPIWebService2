package com.kohli.restfulwebservice2;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class Answer4 {
    @Autowired
    User user;

    @PostMapping("/static")
    public User getUserStatic(@RequestBody User userDetails) {
        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());
        user.setPassword(userDetails.getPassword());
        return user;
    }

    @PostMapping("/dynamic")
    public MappingJacksonValue getUserDynamic(@RequestBody User userDetails) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "age");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(userDetails);
        mapping.setFilters(filters);
        return mapping;
    }
}
