package org.su.sportPlay.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.su.sportPlay.Service.MenuService;
import org.su.sportPlay.pojo.Mainmenu;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Resource
    MenuService menuService;

    @RequestMapping("/menu")
    public String getMenu(){
        HashMap<String, Object> data=new HashMap<>();
        List<Mainmenu> menu = menuService.getMenu();
        if(menu==null){
            data.put("status",404);
        }else {
            data.put("data", menu);
            data.put("status", 200);
        }
        System.out.println(" get Menu! ");
        return JSON.toJSONString(data);
    }
}
