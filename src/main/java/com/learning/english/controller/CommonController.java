package com.learning.english.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.english.service.CommonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class CommonController {
    @Autowired
    public CommonService commonservice;

    @RequestMapping(value ="/", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request, HttpSession session) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println("你输入的用户名为：" + account);
        System.out.println("你输入的密码为：" + password);
        String tname = commonservice.login(account, password);
        session.setAttribute("tname", tname);
        if (tname == null) {
            return "redirect:/";
        } else {
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginindex() {
        return "/index";

    }
}
