package club.yuyang.boot.serviceImpl;

import club.yuyang.boot.dao.SchoolDao;
import club.yuyang.boot.entity.School;
import club.yuyang.boot.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/11 11:08
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    SchoolDao schoolDao;

    @Override
    public List<School> schoolList() {
        List<School> list = schoolDao.findAll();
        return list;
    }

    @Override
    public String getSchoolName(Integer schoolId) {
        String schoolName = schoolDao.findNameById(schoolId);
        return schoolName;
    }
}
