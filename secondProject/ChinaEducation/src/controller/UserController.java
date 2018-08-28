package controller;

import entity.Course;
import entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    //注册
//    @RequestMapping("/list")
//    public String getUser(Model model){
//        List<User> users=userService.getUsers();
//        model.addAttribute("list",users);
////        return "userlist";
//        return  "redirect:/app/userlist.jsp";
//    }
    @RequestMapping("/list")
    public String getUser(Model model){
        List<User> users=userService.getUsers();
        model.addAttribute("list",users);
        return "forward:/app/userlist.jsp";
    }


//    @RequestMapping("/")
//    public String index(){
//        return "forward:/list";
//    }

    //响应页面的删除
    @RequestMapping("delete")
    @ResponseBody
    public String deleteUserById(Integer id) {
		/*if(userService.deleteUserById(id)>0){
			return "ok";
		}else{
			return "error";
		}*/
        return userService.deleteUserById(id)>0?"ok":"error";
        //return "OK";
    }

    //响应页面点击修改的
    @RequestMapping("/edit")
    @ResponseBody
    public User getUserById(Integer id,Model model) {
        User user=userService.getUserById(id);
        //需要保存id,如若不保存，Id为null
        model.addAttribute("id", id);
        System.out.println("需要修改的用户！！！"+user);
        return user;
    }

    //点击页面的保存修改
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(@ModelAttribute User user) {
		/*if(userService.updateUser(user)>0){
			System.out.println("修改用户成功");
			return "ok";
		}else{
			return "error";
		}*/
		System.out.println("进入了更新方法");
        return userService.updateUser(user)>0?"ok":"error";
    }
    //实现注册
    @RequestMapping("/register")
    public String registerUser(@ModelAttribute User user,Model model){
        System.out.println("用户注册:"+user.getUsername()+user.getPassword());
        userService.register(user);
        model.addAttribute("msg","注册成功");
        return "login";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+password);
        HttpSession session=request.getSession();
        if (userService.login(username,password)){
            System.out.println("进入了正式的方法");
            session.setAttribute("name",username);
            session.setMaxInactiveInterval(30*60);
            return  "redirect:/app/index.html";
        }
        return "login";
    }
    //取出session,判断是否登录
    @RequestMapping("/getLogin")
    @ResponseBody
    public Object getLogin(HttpServletRequest request){
        HttpSession session=request.getSession();
        Object name=session.getAttribute("name");
        System.out.println("多来点参数，以便自己查找");
        System.out.println("session的name值为"+name);
        return name;
    }
    //重定向到主页
    @RequestMapping("/")
    public String index(){
        return "redirect:/app/index.html";
    }



    //后台的一些操作
    @RequestMapping("/adminLogin")
    public String adminLogin(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+password);
        HttpSession session=request.getSession();
        if (userService.login(username,password)){
            System.out.println("进入了正式的方法");
            session.setAttribute("name",username);
            session.setMaxInactiveInterval(30*60);
            return  "redirect:/X-admin/index.html";
        }
        return "redirect:/X-admin/login.html";
    }

    @RequestMapping("/getAdminLogin")
    @ResponseBody
    public Object getAdminLogin(HttpServletRequest request){
        HttpSession session=request.getSession();
        Object name=session.getAttribute("name");
        System.out.println("多来点参数，以便自己查找");
        System.out.println("session的name值为"+name);
        return name;
    }

    //获得所有的user
    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List getCourse(){
        List<User> users = userService.findAllUsers();
        return users;
    }
    //根据用户id删除用户
    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(HttpServletRequest request){
        Integer userId=Integer.parseInt(request.getParameter("id"));
        System.out.println("id的值为"+userId);
        userService.deleteUserByUserId(userId);
    }


    @RequestMapping("/addUser")
    @ResponseBody
    public String addAdminUser(@ModelAttribute User user) {
        System.out.println("user的输出值");
        System.out.println(user);
        System.out.println("进入了添加用户方法");
        return userService.addAdminUser(user)>0?"ok":"error";
    }
}
