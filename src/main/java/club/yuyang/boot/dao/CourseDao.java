package club.yuyang.boot.dao;

import club.yuyang.boot.dto.IdentityDTO;
import club.yuyang.boot.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/24 19:12
 */
@Mapper
public interface CourseDao {

    //添加课程
    void addCourse(Course course);

    //根据相关信息查询新添加的课程是否会覆盖
    Course getCourse(Course course);

    //更新课程
    void updateCourse(Course course);

    //查询当前用户的所有课程
    List<Course> allCourses(IdentityDTO identityDTO);

    //根据id删除对应课程
    void delCourseById(int id);
}
