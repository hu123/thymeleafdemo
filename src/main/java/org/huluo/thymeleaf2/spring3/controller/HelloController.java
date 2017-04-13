package org.huluo.thymeleaf2.spring3.controller;

import org.huluo.thymeleaf2.spring3.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

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
    public String postSayWorld(@Valid Student student, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("错误啦");
            Student errorStudent = new Student();
            errorStudent.name = "errorinfo";
            model.addAttribute("student", errorStudent);
            return "result";
        }

        Student s = new Student();
        s.name = "zhangsan";
        model.addAttribute("student", s);
        return "result";
    }


    @RequestMapping(value = "/beanValidation")
    public String beanValidation(@Valid Student student,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();

            for (ObjectError objectError : objectErrors) {
                System.out.println(objectError.getObjectName() + "," + objectError.getDefaultMessage());
            }
            return "result";
        }
        return "result";
    }


    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String type) {
        if (type.endsWith(".html")) {
            return "/hello.html";
        }else {
            return "/hello.jsp";
        }

    }

}
