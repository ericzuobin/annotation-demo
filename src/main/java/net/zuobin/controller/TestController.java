package net.zuobin.controller;

import net.zuobin.entity.User;
import net.zuobin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sahinn
 * @date 16/6/8
 */
@Controller
@RequestMapping("/testmodel")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value="/test1",method= RequestMethod.GET)
    public ModelAndView test(){

        ModelAndView modelAndView = new ModelAndView("/test/test");
        modelAndView.addObject("name", "xxx");

        logger.error("test success");

        return modelAndView;
    }

    @RequestMapping(value="/saveUser",method= RequestMethod.GET)
    public ModelAndView testSaveUser(){

        User user = new User();
        user.setUid(10000l);
        user.setName("zhangsan");

        userService.save(user);


        ModelAndView modelAndView = new ModelAndView("/test/test");
        modelAndView.addObject("name", "xxx");

        logger.error("test success");

        return modelAndView;
    }

    @RequestMapping(value="/findUser",method= RequestMethod.GET)
    public ModelAndView testFindUser(){

        User user = userService.findByUId(10000l);


        ModelAndView modelAndView = new ModelAndView("/test/test");
        modelAndView.addObject("name", "xxx");

        logger.error("test success");

        return modelAndView;
    }
}
