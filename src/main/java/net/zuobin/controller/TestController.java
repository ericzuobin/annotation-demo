package net.zuobin.controller;

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

    @RequestMapping(value="/test1",method= RequestMethod.GET)
    public ModelAndView test(){

        ModelAndView modelAndView = new ModelAndView("/test/test");
        modelAndView.addObject("name", "xxx");
        return modelAndView;
    }
}
