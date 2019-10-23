package club.yuyang.boot.service;

import club.yuyang.boot.dto.IdentityDTO;
import club.yuyang.boot.entity.Course;

import java.util.List;


/**
 * @author yuyang
 * @date 2019/9/25 18:42
 */
public interface CourseService {

    //5.1 根据录入的课程决定是增加新课程还是更新
    void addOrUpdateCourse(Course course);

    //5.2 输出当前用户课表
    List<Course> getAllCourses(IdentityDTO identityDTO);

    //5.3 删除对应课程
    void delCourseById(int id);
}
