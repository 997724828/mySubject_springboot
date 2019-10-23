package club.yuyang.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuyang
 * @date 2019/9/19 12:49
 */
@Mapper
public interface InstituteDao {

    String findNameBySchoolAndInstitute(@Param("schoolId")Integer schoolId,@Param("instituteId")Integer instituteId);
}
