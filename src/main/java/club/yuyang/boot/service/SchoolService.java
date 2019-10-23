package club.yuyang.boot.service;

import club.yuyang.boot.entity.School;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/11 11:07
 */
public interface SchoolService {

    //    2.1 注册选择学校模块
    List<School> schoolList();

    //    2.2 根据学校id查询学校名称
    String getSchoolName(Integer schoolId);
}
