package controller;

import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ITeacherService;
import util.PageBean;

@Controller
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/teacher")
    @ResponseBody
    public PageBean<Teacher> getAllTeacher(@RequestParam(defaultValue = "1")int currentPage){
        PageBean<Teacher> pageBean=teacherService.findByTeacher(currentPage);
        return pageBean;
    }

}
