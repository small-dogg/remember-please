package com.smalldogg.rememberplease.domain.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/coords")
    public String index(){
        return "weather/coords";
    }
}
