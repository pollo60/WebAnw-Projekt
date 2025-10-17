package edu.fra.uas.Sino.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;    
public class HelloWorldController {
@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getHelloWorld() {
        return "<h1>Hello World Spring Boot!</h1>";
    }
}
