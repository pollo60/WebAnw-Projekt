package edu.fra.uas.Altaystest.controllerDS5only;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AltaysController {

    @RequestMapping(value = "hello", method=RequestMethod.GET)
    @ResponseBody
    public String getHelloWorld() {
        return "<h1> Hello World from AltaysTestApplication </h1>";
        
    }

}
