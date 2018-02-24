package cn.unisolution.demo.controller;

import cn.unisolution.demo.utils.DBJYJYSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/2/13.
 */
@RestController
public class IndexController {

    @Autowired
    private DBJYJYSetting dbjyjy;


    @RequestMapping("/")
    public String index(){
        return "dbjyjy info url :"+dbjyjy.getUrl()+" host :"+dbjyjy.getHost()+" port :"+dbjyjy.getPort();
    }

}
