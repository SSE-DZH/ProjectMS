package com.zhiend.projectms.service.impl;

import com.zhiend.projectms.entity.User;
import com.zhiend.projectms.mapper.UserMapper;
import com.zhiend.projectms.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
