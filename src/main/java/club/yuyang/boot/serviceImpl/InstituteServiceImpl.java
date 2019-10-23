package club.yuyang.boot.serviceImpl;

import club.yuyang.boot.dao.InstituteDao;
import club.yuyang.boot.service.InstituteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/9/19 13:06
 */
@Service
public class InstituteServiceImpl implements InstituteService {

    @Resource
    private InstituteDao instituteDao;

    @Override
    public String getInstituteName(Integer schoolId, Integer instituteId) {
        String instituteName = instituteDao.findNameBySchoolAndInstitute(schoolId,instituteId);
        return instituteName;
    }
}
