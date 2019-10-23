package club.yuyang.boot.serviceImpl;

import club.yuyang.boot.dao.ClassmateDao;
import club.yuyang.boot.service.ClassmateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/9/19 16:38
 */
@Service
public class ClassmateServiceImpl implements ClassmateService {
    @Resource
    ClassmateDao classmateDao;

    @Override
    public String getClassmateName(Integer schoolId, Integer instituteId, Integer classmateId) {
        String classmateName = classmateDao.findNameBySchoolAndInstituteAndClassmate(schoolId,instituteId,classmateId);
        return classmateName;
    }
}
