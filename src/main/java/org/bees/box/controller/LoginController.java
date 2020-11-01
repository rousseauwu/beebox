package org.bees.box.controller;

import org.bees.box.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @PostMapping("/login.do")
    public Student login(@RequestBody @Valid  Student student) throws InterruptedException {
        Thread.sleep(60000);
        student.setName("hello " + student.getName() + "");
        return student;
    }
}
