package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.UserDTO;
import com.zhiend.projectms.entity.Admin;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员管理")
@Slf4j
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation("添加管理员")
    @PostMapping("/add")
    public Result<?> addAdmin(@RequestBody UserDTO adminDTO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDTO, admin);
        adminService.save(admin);
        return Result.success("Admin added successfully");
    }

    @ApiOperation("获取所有管理员")
    @GetMapping("/all")
    public Result<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.list();
        return Result.success(admins);
    }

    @ApiOperation("根据ID获取管理员")
    @GetMapping("/{id}")
    public Result<Admin> getAdminById(@PathVariable Integer id) {
        Admin admin = adminService.getById(id);
        if (admin == null) {
            return Result.error("Admin not found");
        }
        return Result.success(admin);
    }

    @ApiOperation("更新管理员")
    @PutMapping("/{id}")
    public Result<?> updateAdmin(@RequestBody Admin admin) {
//        Admin admin = adminService.getById(id);
        if (adminService.getById(admin.getId()) == null) {
            return Result.error("Admin not found");
        }
//        BeanUtils.copyProperties(adminDTO, admin);
        adminService.updateById(admin);
        return Result.success("Admin updated successfully");
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("/{id}")
    public Result<?> deleteAdmin(@PathVariable Integer id) {
        boolean removed = adminService.removeById(id);
        if (!removed) {
            return Result.error("Admin not found");
        }
        return Result.success("Admin deleted successfully");
    }
}

