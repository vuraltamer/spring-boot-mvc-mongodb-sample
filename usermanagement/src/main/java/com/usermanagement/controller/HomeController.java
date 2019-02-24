package com.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/*
 * CONTROLLER for web pages
 *
 * */
@Controller
public class HomeController {

    /*
     * http://localhost:8080/home
     * Request Type : GET
     *
     * */
    @GetMapping({"/"})
    public String home() {

        return "home";
    }
}
