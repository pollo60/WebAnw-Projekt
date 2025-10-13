package edu.fra.uas.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.blind.annotation.RequestMapping;
import org.springframework.web.blind.annotation.RequestMethod;
import org.springframework.web.blind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping(value="hello", method=RequestMethod.GET)
    @ResponseBody 
    public String getHelloWorld() {
        return "<h1>Hello World Spring Boot!</h1>";
    }
}
