package com.mostbet.triggerCampaign.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "admin/dashboard";
    }

    @RequestMapping("/user/list")
    public String listUser(){
        return "admin/user-list";
    }

    @RequestMapping("/user/add")
    public String addUser(){
        return "admin/user-add";
    }

}
