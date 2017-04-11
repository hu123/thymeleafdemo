package org.huluo.thymeleaf2.spring3.controller;

import org.huluo.thymeleaf2.spring3.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HelloController {

    @RequestMapping("/aaa")
    public String sayHello() {
        return "success";
    }



    @RequestMapping(value = "/student" ,method = RequestMethod.GET)
    public String getSayWorld(Model model ) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "result";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String postSayWorld(@Valid Student student, Model model) {

        Student s = new Student();
        s.name = "zhangsan";
        model.addAttribute("student", s);
        return "result";
    }

}
