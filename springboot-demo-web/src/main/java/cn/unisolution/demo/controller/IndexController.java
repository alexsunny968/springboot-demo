package cn.unisolution.demo.controller;

import cn.unisolution.demo.domain.User;
import cn.unisolution.demo.utils.DBJYJYSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/13.
 */
@RestController
public class IndexController {

    @Autowired
    private DBJYJYSetting dbjyjy;



    @RequestMapping("/")
    public User index(){

        return new User(100l,"AAA",20,"2017-01-01");
        //return "dbjyjy info url :"+dbjyjy.getUrl()+" host :"+dbjyjy.getHost()+" port :"+dbjyjy.getPort();
    }


    @RequestMapping("/indexlist")
    public List<User> indexList(){

        List<User> userList = new ArrayList<>();
        userList.add(new User(88l,"AAA",20,"2017-01-01"));
        userList.add(new User(89l,"BBB",21,"2017-02-01"));

        return userList;
        //return "dbjyjy info url :"+dbjyjy.getUrl()+" host :"+dbjyjy.getHost()+" port :"+dbjyjy.getPort();
    }


/*

    @RequestMapping("/")
    public String index(){
        return "dbjyjy info url :"+dbjyjy.getUrl()+" host :"+dbjyjy.getHost()+" port :"+dbjyjy.getPort();
    }
    */

}
