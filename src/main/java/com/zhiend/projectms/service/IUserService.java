package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.UserDTO;
import com.zhiend.projectms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiend.projectms.page.BackPage;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
public interface IUserService extends IService<User> {
    boolean isEmailExists(String email);

    void register(UserDTO userDTO);

    BackPage<User> listByBackPage(Long pageNo, Long pageSize);

    void updateUser(Long id, UserDTO userDTO);
}
