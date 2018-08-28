package service;

import entity.Teacher;
import util.PageBean;

public interface ITeacherService {
    //查询总课程数
    int selectCount();
    //根据传入的当前页找到对应的pageBean对象
    PageBean<Teacher> findByTeacher(int currentpage);
}
