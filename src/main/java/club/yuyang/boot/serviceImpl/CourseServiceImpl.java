package club.yuyang.boot.serviceImpl;

import club.yuyang.boot.dao.CourseDao;
import club.yuyang.boot.dto.IdentityDTO;
import club.yuyang.boot.entity.Course;
import club.yuyang.boot.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/25 18:43
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    CourseDao courseDao;

    //增加或覆盖一个课程
    @Override
    public void addOrUpdateCourse(Course course) {
        //从数据库中查询是否有相同时间段课程
        Course dbCourse = courseDao.getCourse(course);
        if (dbCourse!=null){
            //说明新添加的课程要覆盖原来的，即修改原记录
            course.setId(dbCourse.getId());
            courseDao.updateCourse(course);
        }else{
            //直接添加一个新的记录
            courseDao.addCourse(course);
        }
    }

    //输出当前用户课表
    @Override
    public List<Course> getAllCourses(IdentityDTO identityDTO) {
        return  courseDao.allCourses(identityDTO);
    }

    //删除对应课程
    @Override
    public void delCourseById(int id) {
        courseDao.delCourseById(id);
    }
}
