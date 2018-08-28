package service;


import entity.Course;
import util.PageBean;


import java.util.List;

public interface ICourseService {

    //获得所有课程
    List<Course> getCourses();

    Course findCourseById(Integer id);
    //分页处理
    int selectCount();

    PageBean<Course> findByPage(int currentpage);

    //删除对应id的课程
    Integer deleteCourseId(Integer courseId);
}
