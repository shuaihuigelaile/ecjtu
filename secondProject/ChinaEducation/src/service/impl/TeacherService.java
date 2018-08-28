package service.impl;

import dao.TeacherMapper;
import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ITeacherService;
import util.PageBean;

import java.util.HashMap;
import java.util.List;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public int selectCount() {
        return teacherMapper.selectCount();
    }

    @Override
    public PageBean<Teacher> findByTeacher(int currentpage) {
        HashMap<String,Object> map=new HashMap<>();
        PageBean<Teacher> pageBean=new PageBean<Teacher>();
        //封装当前传进来的页数
        pageBean.setCurrPage(currentpage);
        //每页显示的数据
        int pageSize=4;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=teacherMapper.selectCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentpage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        List<Teacher> lists=teacherMapper.findByTeacher(map);
        pageBean.setLists(lists);
        return pageBean;
    }
}
