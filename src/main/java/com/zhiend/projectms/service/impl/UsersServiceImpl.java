package com.zhiend.projectms.service.impl;

import com.zhiend.projectms.entity.Users;
import com.zhiend.projectms.mapper.UsersMapper;
import com.zhiend.projectms.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
