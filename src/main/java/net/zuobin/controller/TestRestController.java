package net.zuobin.controller;

import net.zuobin.bean.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sahinn
 * @date 16/6/8
 */
@RestController
@RequestMapping("/testrest")
public class TestRestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld(){
        return  "Hello World!!!!";
    }

    @RequestMapping(value="/testxml",
            method=RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public UserInfo testXml(){

        UserInfo userInfo = new UserInfo();

        userInfo.setId("10000");
        userInfo.setName("zhangsan");
        userInfo.setAddr("BeiJing");
        userInfo.setPhone("13800138000");

        return userInfo;
    }
}
