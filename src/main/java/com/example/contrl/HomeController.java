package com.example.contrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liubo16 on 2017/2/8.
 */
@Controller
public class HomeController {


    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("name","my login");
        System.out.println("==============================================");
        return "home";
    }
}
