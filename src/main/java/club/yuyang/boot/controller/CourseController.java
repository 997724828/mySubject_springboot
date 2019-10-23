package club.yuyang.boot.controller;

import club.yuyang.boot.entity.Course;
import club.yuyang.boot.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/9/24 19:11
 */
@Controller
public class CourseController {

    @Resource
    CourseService courseService;

    @PostMapping("/addOrUpdateCourse")
    public String addOrUpdateCourse(Course course) {
        courseService.addOrUpdateCourse(course);
        return "redirect:/person";
    }
}
