package com.example.controller;


import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.StringUtils;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.tools.CommonUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liubo16 on 2017/2/8.
 */
@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String phone, String password, Model model) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            model.addAttribute("error", "手机号或密码不能为空");
            return "home";
        }
        if (!CommonUtils.validatePhone(phone)) {
            model.addAttribute("error", "手机号格式有误");
            return "home";
        }
        User user = userService.getUser(phone);
        if (user == null) {
            model.addAttribute("error", "用户不存在");
            return "home";
        }
        model.addAttribute("user", user);
        System.out.println("phone:" + phone + "\npassword:" + password);
        return "redirect:index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(User user, Model model) {
        if (!CommonUtils.validatePhone(user.getPhone())) {
            model.addAttribute("error", "手机号错误");
            return "register";
        }
        if (userService.getUser(user.getPhone()) != null) {
            model.addAttribute("error", "用户已经存在");
            return "register";
        }

        int res = userService.saveUser(user);

        if (res <= 0) {
            model.addAttribute("error", "注册用户出错");
            return "register";
        }
        model.addAttribute("user", user);
        log.info("用户注册成功,{}", JSONUtils.toJSONString(user));
        return "redirect:index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(User user) {
        return "register";
    }
}
