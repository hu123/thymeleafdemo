package org.huluo.thymeleaf2.spring3.entity;

import javax.validation.constraints.Size;

public class Student {
    @Size(min = 2,max = 3 ,message = "length not qualified")
    public String name  = "";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
