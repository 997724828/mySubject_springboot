package club.yuyang.boot.service;

/**
 * @author yuyang
 * @date 2019/9/19 12:53
 */
public interface InstituteService {

    //    3.1 根据学校Id和学院Id锁定学院名称
    String getInstituteName(Integer schoolId,Integer instituteId);

}
