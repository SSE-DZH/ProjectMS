package com.zhiend.projectms.mapper;

import com.zhiend.projectms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
