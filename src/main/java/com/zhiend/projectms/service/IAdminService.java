package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.UserDTO;
import com.zhiend.projectms.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiend.projectms.page.BackPage;

import java.util.List;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
public interface IAdminService extends IService<Admin> {
    boolean isEmailExists(String email);
    void addAdmin(UserDTO adminDTO);
    BackPage<Admin> listByBackPage(Long pageNo, Long pageSize);

    void updateAdmin(Long id, UserDTO userDTO);
}
