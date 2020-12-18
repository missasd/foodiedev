package com.imooc.service;

import com.imooc.pojo.Stu;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface UserService {
    /**
     * 判断用户名是否存在
     */
    boolean queryUserIsExist(String username);

    // BO用于从前端接受数据
    // 创建用户
    public Users createUser(UserBO userBO);

    // 检索用户名和密码是否匹配，用于登录
    public Users queryUserForLogin(String username, String password);
}
