package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiend.projectms.dto.UserDTO;
import com.zhiend.projectms.entity.Admin;
import com.zhiend.projectms.mapper.AdminMapper;
import com.zhiend.projectms.page.BackPage;
import com.zhiend.projectms.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    @Override
    public boolean isEmailExists(String email) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        Admin existingUser = this.getOne(queryWrapper);
        return existingUser != null;
    }

    @Override
    public void addAdmin(UserDTO adminDTO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDTO, admin);
        this.save(admin);
    }

    @Override
    public BackPage<Admin> listByBackPage(Long pageNo, Long pageSize) {
        BackPage<Admin> AdminBackPage = new BackPage<>();
        // 设置条件构造器
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        // 构造分页信息，其中的Page<>(page, PAGE_RECORDS_NUM)的第一个参数是第几页，而第二个参数是每页的记录数
        Page<Admin> AdminPage = new Page<>(pageNo, pageSize);
        // page(AdminPage, wrapper)这里的第一个参数就是上面定义了的Page对象，第二个参数就是上面定义的条件构造器对象，通过调用这个方法就可以根据你的分页信息以及查询信息获取分页数据
        IPage<Admin> AdminIPage = page(AdminPage, wrapper);
        // 封装数据，其中getRecords()是获取记录数，getCurrent()获取当前页数，getPages()获取总页数，getTotal()获取记录总数，还要其他更多的方法，大家可以自行查看，在这里就不过多赘述了
        AdminBackPage.setContentList(AdminIPage.getRecords());
        AdminBackPage.setCurrentPage(AdminIPage.getCurrent());
        AdminBackPage.setTotalPage(AdminIPage.getPages());
        AdminBackPage.setTotalNum(AdminIPage.getTotal());
        return AdminBackPage;
    }
}
