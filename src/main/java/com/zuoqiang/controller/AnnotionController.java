package com.zuoqiang.controller;


import com.alibaba.fastjson.JSONObject;
import com.zuoqiang.bean.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Think on 2017/6/10.
 */
@Controller
public class AnnotionController {
    private  static final Logger logger=LoggerFactory.getLogger(AnnotionController.class);

    //测试Model
    @RequestMapping(value = "/message")     //访问地址http://localhost:8080/message
    public String test1(Model model){
        model.addAttribute("message","zuoqiang");
        return "message";
    }
    //测试ModelAndView
    @RequestMapping(value = "/message1")   //访问地址http://localhost:8080/message1
    public ModelAndView test2(ModelAndView mv){
        mv.addObject("message","wangbin");
        mv.setViewName("message");
        return mv;
    }

    @RequestMapping(value = "/message2")   //访问地址http://localhost:8080/message
    public ModelAndView test3(){
        ModelAndView mv =new ModelAndView();
        mv.addObject("message","liwenzhe");
        mv.setViewName("message");
        return mv;
    }

    //测试RequestParam
    @RequestMapping(value="/message3" ,method = RequestMethod.GET)  //访问地址http://localhost:8080/message3?login=zuoqiang&pass=123456
    public  String test4(
            @RequestParam String login,
            @RequestParam String pass,
            Model mv){
        mv.addAttribute("message","账号和密码是:"+login+pass);
        return "message";
    }

    //测试URL动态参数
    @RequestMapping(value = "/message/{str}")    //访问地址 http://localhost:8080/message/1
    public String test5(
            @PathVariable  Integer str,
            Model model){
        model.addAttribute("message",str);
        return  "message";
    }

    //测试头信息
    @RequestMapping(value = "/messageHead")    //访问路径http://localhost:8080/messageHead
    public String test6(
            @RequestHeader("User-Agent") String str,
            Model model){
        model.addAttribute("message",str);
        return  "message";
    }

    //测试Cookie
    @RequestMapping(value = "/messageCookie")    //访问路径http://localhost:8080/messageCookie
    public String test7(
            @CookieValue("JSESSIONID") String str,
            Model model){
        model.addAttribute("message",str);
        return  "message";
    }

    //测试ModelAttribute方法
    //1)测试@ModelAttribute(value="")返回具体的方法
    /*@ModelAttribute("value")
    public String userMoel(      //此方法在所有的RequestMapping前面执行
    @RequestParam(value = "login")  String login){
        return login;

    }
    @RequestMapping(value = "/test")     //访问路径http://localhost:8080/test?login=yuanjiahui
    public String test8(){
        return  "message";
    }*/

    //2)@ModelAttribute注解返回void值的方法
    /*@ModelAttribute
    public void userMoel2(Model model){
        model.addAttribute("value2","lixin");

    }
    @RequestMapping(value = "/test2")     //访问路径http://localhost:8080/test2?login=1
    public String test9(){
        return  "message";
    }*/


    //测试JSON
    //1)发送JSON
    @RequestMapping(value = "/json/recjson")     //访问路径http://localhost:8080/send_json.jsp   send_json.jsp不能放在WIN-INF目录(这个目录下面的文件是受服务器保护的。)下，因为这个目录不能直接访问
    public void test9(@RequestBody Book book,
           HttpServletResponse httpServletResponse) throws IOException {
        //book.setId("2");
        //book.setName("大话数据结构");
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().println(JSONObject.toJSONString(book));
    }

    //发送json格式的数据
    @RequestMapping(value = "/json/sendjson")     //访问路径http://localhost:8080/recive_json.jsp
    @ResponseBody  //将objec发送成json传到前台去
    public Object getobject() {
        List<Book> bookList=new ArrayList<Book>();
        Book book=new Book();
        book.setId("2");
        book.setName("大话数据结构");
        bookList.add(book);
        Book book2=new Book();
        book2.setId("2");
        book2.setName("大话数据结构");
        bookList.add(book2);
        return bookList;
    }


}
