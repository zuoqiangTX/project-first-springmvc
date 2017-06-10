package com.zuoqiang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Think on 2017/6/5.
 */
@Controller
public class HelloController {
    private  static final Logger logger=LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        logger.info("hello 方法被调用！");
        ModelAndView mv=new ModelAndView();
        mv.addObject("message","Hello World!");
        mv.setViewName("hello");
        return mv;
    }


}
