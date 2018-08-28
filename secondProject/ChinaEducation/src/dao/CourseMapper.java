package dao;

import entity.Course;

import java.util.HashMap;
import java.util.List;

public interface CourseMapper {
    //查询所有课程信息
    List<Course> getCourse();
    Course findCourseById(Integer id);
    //查询用户总数
    int selectCount();
    //分页操作，调用findByPage limit分页方法
    List<Course> findByPage(HashMap<String,Object> map);

    //删除对应id的课程
    Integer deleteCourse(Integer courseId);
}
