package club.yuyang.boot.service;

/**
 * @author yuyang
 * @date 2019/9/19 16:34
 */
public interface ClassmateService {

    //    4.1 根据学校Id,学院Id和班级Id锁定班级名称
    String getClassmateName(Integer schoolId,Integer instituteId,Integer classmateId);
}
