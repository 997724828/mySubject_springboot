package club.yuyang.boot.dao;


import club.yuyang.boot.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/11 11:03
 */
@Mapper
public interface SchoolDao {

    List<School> findAll();

    String findNameById(@Param("schoolId") Integer schoolId);
}
