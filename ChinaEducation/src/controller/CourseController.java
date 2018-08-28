package controller;

import entity.Course;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.ICourseService;
import util.PageBean;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @RequestMapping("/course")
    @ResponseBody
    public List getCourse(Model model){
        List<Course> courses = courseService.getCourses();
        //model.addAttribute("list",courses);
        return courses;
    }
    @RequestMapping("/chooseCourse")
    @ResponseBody
    public Course getCourse(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("id"));
        Course course = courseService.findCourseById(id);
        return course;
    }

    @RequestMapping("/courses")
    @ResponseBody
    public PageBean<Course> getAllCourse(@RequestParam(defaultValue = "1")int currentPage){
        System.out.println("当前页面的数值是:"+currentPage);
        PageBean<Course> pageBean = courseService.findByPage(currentPage);
        System.out.println("我进来了");
        return pageBean;
    }

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public Integer deleteCourse(HttpServletRequest request){
        //把id参数传过来
        Integer courseId=Integer.parseInt(request.getParameter("courseId"));
        return courseService.deleteCourseId(courseId);
    }
}
