package org.su.sportPlay.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.su.sportPlay.Service.UserService;
import org.su.sportPlay.pojo.QueryInfo;
import org.su.sportPlay.pojo.User;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody User user){

        System.out.println("user:"+user);
        User uu = userService.getUserByNameAndPass(user);
        System.out.println("uu:"+uu);
        HashMap<String,Object> res = new HashMap<>();

        String flag = uu==null ?"error":"ok";

        res.put("flag",flag);
        res.put("user",uu);
        return JSON.toJSONString(res);
    }

    /**
     * @param queryInfo
     * 使用 RequestBody 时，前端要使用 post方法
     * 不使用RequestBody时，前端要使用 get方法，可以通过直接构造 ？xx=xx&xx=xx,也可以通过使用params方法
     *  const {data:res}=await this.$http.get("allUser",{
     *         params:this.queryInfo
     *       });
     * @return
     */
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        System.out.println("query all user");
        System.out.println(queryInfo.toString());

        int number = userService.getUserCounts("%"+queryInfo.getQuery()+"%");
        int itemStart = ((queryInfo.getPageNum()-1)*queryInfo.getPageSize());

        List<User> userList = userService.getAllUser("%"+queryInfo.getQuery()+"%",
                itemStart, queryInfo.getPageSize());
        for(User u:userList){
            System.out.println(u.getUsername());
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("number",number);
        res.put("data",userList);
        return JSON.toJSONString(res);
    }



    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer  id,
                                  @RequestParam("state") Boolean state){
        int i = userService.updateState(id, state);
        System.out.println("用户编号:"+id);
        System.out.println("用户状态:"+state);
        return i >0? "success": "error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        user.setRole("普通用户");
        user.setState(false);
        int i = userService.addUser(user);
        return i >0?"success":"error";
    }

    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public String getUser(@PathVariable("id") int id){
        System.out.println("编号:"+id);
        return JSON.toJSONString(userService.getUser(id));
        //User user = userService.getUser(id);
        //return JSON.toJSONString(user);
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        System.out.println(user);
        int i = userService.editUser(user);
        return i >0?"success":"error";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        System.out.println(id);
        int i = userService.deleteUser(id);
        //int i = 1;
        return i >0?"success":"error";
    }

}
