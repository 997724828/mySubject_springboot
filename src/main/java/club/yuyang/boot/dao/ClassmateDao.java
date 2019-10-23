package club.yuyang.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuyang
 * @date 2019/9/19 16:33
 */
@Mapper
public interface ClassmateDao {

    String findNameBySchoolAndInstituteAndClassmate(@Param("schoolId")Integer schoolId,
                                                    @Param("instituteId")Integer instituteId,
                                                    @Param("classmateId")Integer classmateId);
}
