package club.yuyang.boot.service;

import club.yuyang.boot.dto.UserDTO;
import club.yuyang.boot.entity.User;

/**
 * @author yuyang
 * @date 2019/9/10 8:42
 */
public interface UserService {

    //   1.1 登录模块
    UserDTO login(String account, String password);
    //   1.2 密码修改模块
    int updatePaw(User user);
}
