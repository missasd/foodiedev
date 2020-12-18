package com.imooc.controller;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class StuFooController {

    @Autowired
    StuService stuService;

    @GetMapping("/getStu/{id}")
    public Stu getStuById(@PathVariable("id") Integer id){
        return stuService.getStuInfo(id);
    }

    @PostMapping("/saveStu")
    public Object saveStu(){
        stuService.saveStu();
        return "ok";
    }

    @PostMapping("/updateStu")
    public Object updateStu(int id){
        stuService.updateStu(id);
        return "ok";
    }

    @DeleteMapping("/stu/{id}")
    public Stu delete(@PathVariable("id") int id){
        Stu stuInfo = stuService.getStuInfo(id);
        if (stuInfo != null){
            stuService.deleteStu(id);
        }
        return stuInfo;
    }

}
