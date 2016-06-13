package net.zuobin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(value="/test1",method= RequestMethod.GET)
    public ModelAndView test(){

        ModelAndView modelAndView = new ModelAndView("/test/test");
        modelAndView.addObject("name", "xxx");

        logger.error("test success");

        return modelAndView;
    }
}
