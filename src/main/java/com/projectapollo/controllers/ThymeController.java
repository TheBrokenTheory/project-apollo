package com.projectapollo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeController {
    @RequestMapping(value="/item")
    public String item(){
        return "item";
    }
}
