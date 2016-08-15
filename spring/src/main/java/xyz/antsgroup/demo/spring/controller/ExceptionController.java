package xyz.antsgroup.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class ExceptionController {

    @RequestMapping("/test/exception1")
    public void one() {
        throw new RuntimeException("发生 RuntimeException");
    }

    @ExceptionHandler
    public String resolveException(Exception e) {
        e.printStackTrace();
        return e.toString();
    }
}
