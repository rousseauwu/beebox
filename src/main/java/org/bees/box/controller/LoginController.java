package org.bees.box.controller;

import org.bees.box.configuration.WebPropertiesConfig;
import org.bees.box.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private WebPropertiesConfig webPropertiesConfig;

    @PostMapping("/login.do")
    public Student login(@RequestBody @Valid  Student student) throws InterruptedException {
        student.setName("hello " + student.getName() + "");

        System.out.println(webPropertiesConfig.getProjectName());
        return student;
    }
}
