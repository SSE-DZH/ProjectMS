package com.zhiend.projectms.service.impl;

import com.zhiend.projectms.entity.Admin;
import com.zhiend.projectms.mapper.AdminMapper;
import com.zhiend.projectms.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
