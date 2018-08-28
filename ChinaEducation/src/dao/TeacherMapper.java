package dao;

import entity.Teacher;

import java.util.HashMap;
import java.util.List;

public interface TeacherMapper {
    //查询总老师数
    int selectCount();
    //分页操作，查询每一页的老师数量
    List<Teacher> findByTeacher(HashMap<String,Object> map);
}
