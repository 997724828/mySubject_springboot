package club.yuyang.boot.controller;

import club.yuyang.boot.dto.IdentityDTO;
import club.yuyang.boot.dto.UserDTO;
import club.yuyang.boot.entity.Course;
import club.yuyang.boot.entity.User;
import club.yuyang.boot.service.CourseService;
import club.yuyang.boot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author yuyang
 * @date 2019/9/26 16:45
 */
@Controller
public class PersonController {
    @Resource
    CourseService courseService;
    @Resource
    UserService userService;

    //跳转个人课表
    @RequestMapping("/person")
    public String toPerson(HttpServletRequest request){
        //跳转到对应用户界面时传入相应信息
        UserDTO responseUser = (UserDTO) request.getSession().getAttribute("user");
        IdentityDTO identityDTO = new IdentityDTO();
        identityDTO.setSchoolId(responseUser.getSchoolId());
        identityDTO.setInstituteId(responseUser.getInstituteId());
        identityDTO.setClassmateId(responseUser.getClassmateId());
        List<Course> courseList = courseService.getAllCourses(identityDTO);
        request.setAttribute("courseList",courseList);
        return "person";
    }

    //跳转班级课表
    @GetMapping("/classmate")
    public String toPerson2(HttpServletRequest request){
        //跳转到对应用户界面时传入相应信息
        UserDTO responseUser = (UserDTO) request.getSession().getAttribute("user");
        IdentityDTO identityDTO = new IdentityDTO();
        identityDTO.setSchoolId(responseUser.getSchoolId());
        identityDTO.setInstituteId(responseUser.getInstituteId());
        identityDTO.setClassmateId(responseUser.getClassmateId());
        identityDTO.setTypes("必修");
        List<Course> classmateList = courseService.getAllCourses(identityDTO);
        request.setAttribute("classmateList",classmateList);
        return "person";
    }

    //删除课程操作
    @GetMapping("/del/{id}/{state}")
    public String toPerson3(@PathVariable("id") int id,
                            @PathVariable("state") String state){
        courseService.delCourseById(id);
        if ("person".equals(state)){
            return "redirect:/person";
        }else {
            return "redirect:/classmate";
        }
    }

    //密码修改操作
    @PostMapping("/updatePaw")
    public String toUpdatePaw(@Param("oldPaw")String oldPaw,
                              @Param("newPaw")String newPaw,
                              HttpServletRequest request,
                              Model model){
        //1、通过session中的account和接受到的旧密码进行比较确认本人操作
        UserDTO responseUser = (UserDTO) request.getSession().getAttribute("user");
        User dbuser = userService.login(responseUser.getAccount(),oldPaw);
        if (dbuser != null){
            //2、将id和新密码传参修改数据库信息
            User user = new User();
            user.setId(dbuser.getId());
            user.setPassword(newPaw);
            userService.updatePaw(user);
            return "redirect:/classmate";
        }else {
            model.addAttribute("message","不是本人操作");
            return "error";
        }
    }
}
