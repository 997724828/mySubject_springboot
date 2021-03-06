package club.yuyang.boot.controller;

import club.yuyang.boot.dto.IdentityDTO;
import club.yuyang.boot.dto.UserDTO;
import club.yuyang.boot.entity.Course;
import club.yuyang.boot.entity.School;
import club.yuyang.boot.entity.User;
import club.yuyang.boot.service.CourseService;
import club.yuyang.boot.service.InstituteService;
import club.yuyang.boot.service.SchoolService;
import club.yuyang.boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/8 9:00
 */
@Controller
public class IndexController {
    @Resource
    UserService userService;
    @Resource
    SchoolService schoolService;



//  跳转首页
    @RequestMapping("/")
    public String login(HttpServletRequest request){
       request.setAttribute("message","[　欢迎使用我要蹭课系统　]");
        return "login";
    }

//    验证登录
    @PostMapping("/index")
    public String checkLogin(@RequestParam("account")String account,
                             @RequestParam("password")String password,
                             HttpServletRequest request){

       UserDTO responseUser = userService.login(account,password);

        if (responseUser == null){
            //登录失败
            request.setAttribute("message","sorry登录失败，账号密码错误！");
            return "/login";
        }else {
            //登陆成功
            request.getSession().setAttribute("user",responseUser);
            return "redirect:/classmate";
        }
    }

    //  跳转注册页
    @RequestMapping("/join")
    public String join(Model model){
        List<School> list = schoolService.schoolList();
        model.addAttribute("schoolList",list);
        return "join";
    }

    //  退出系统
    @RequestMapping("/out")
    public String toOut(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/";
    }
}
