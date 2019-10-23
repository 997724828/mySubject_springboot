package club.yuyang.boot.serviceImpl;

import club.yuyang.boot.dao.ClassmateDao;
import club.yuyang.boot.dao.InstituteDao;
import club.yuyang.boot.dao.SchoolDao;
import club.yuyang.boot.dao.UserDao;
import club.yuyang.boot.dto.UserDTO;
import club.yuyang.boot.entity.User;
import club.yuyang.boot.service.ClassmateService;
import club.yuyang.boot.service.InstituteService;
import club.yuyang.boot.service.SchoolService;
import club.yuyang.boot.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/9/10 8:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Resource
    SchoolService schoolService;
    @Resource
    InstituteService instituteService;
    @Resource
    ClassmateService classmateService;

    @Override
    public UserDTO login(String account,String password) {

        User user = userDao.findByIdAndPaw(account,password);

        if (user == null){
            return null;
        }else {
            Integer schoolId = user.getSchoolId();
            Integer instituteId = user.getInstituteId();
            Integer classmateId = user.getClassmateId();

            String schoolName = schoolService.getSchoolName(schoolId);
            String instituteName = instituteService.getInstituteName(schoolId, instituteId);
            String classmateName = classmateService.getClassmateName(schoolId, instituteId, classmateId);

            UserDTO userDTO = new UserDTO();

            BeanUtils.copyProperties(user, userDTO);
            userDTO.setSchoolName(schoolName);
            userDTO.setInstituteName(instituteName);
            userDTO.setClassmateName(classmateName);
            return userDTO;
        }
    }

    @Override
    public int updatePaw(User user) {
        int i = userDao.updatePaw(user);
        return i;
    }
}
