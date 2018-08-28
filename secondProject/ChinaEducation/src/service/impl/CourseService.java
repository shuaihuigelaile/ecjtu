package service.impl;

import dao.CourseMapper;
import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ICourseService;
import util.PageBean;

import java.util.HashMap;
import java.util.List;
@Service
public class CourseService implements ICourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> getCourses() {
        return courseMapper.getCourse();
    }

    @Override
    public Course findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public int selectCount() {
        return courseMapper.selectCount();
    }

    @Override
    public PageBean<Course> findByPage(int currentpage) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        PageBean<Course> pageBean = new PageBean<Course>();
        //封装当前页数
        pageBean.setCurrPage(currentpage);
        //每页显示的数据
        int pageSize=4;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = courseMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentpage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        //封装每页的数据
        List<Course> lists = courseMapper.findByPage(map);
        pageBean.setLists(lists);
        return pageBean;
    }

    @Override
    public Integer deleteCourseId(Integer courseId) {
        return courseMapper.deleteCourse(courseId);
    }


}
