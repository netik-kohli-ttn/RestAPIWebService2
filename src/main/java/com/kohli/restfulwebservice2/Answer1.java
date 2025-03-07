package com.kohli.restfulwebservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Answer1 {

    MessageSource messageSource;
    @Autowired
    Answer1(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("answer1")
    public String internationalization(@RequestParam String name) {
          Locale locale = LocaleContextHolder.getLocale();
          return messageSource.getMessage("hello.user.message",null, "Hello", locale) + " " + name;
    }
}
