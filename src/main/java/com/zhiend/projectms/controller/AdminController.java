package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.UserDTO;
import com.zhiend.projectms.entity.Admin;
import com.zhiend.projectms.page.BackPage;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
        boolean isEmailExists = adminService.isEmailExists(adminDTO.getEmail());

        if (isEmailExists) {
            return Result.error("Email already exists");
        }

        adminService.addAdmin(adminDTO);
        return Result.success("Admin added successfully");
    }

    @ApiOperation("获取所有管理员分页信息")
    @GetMapping("/all")
    public Result<BackPage<Admin>> getAllAdmins(@RequestParam("pageNo") Long pageNo, @RequestParam("pageSize") Long pageSize) {
        BackPage<Admin> admins = adminService.listByBackPage(pageNo, pageSize);
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
    public Result<?> updateAdmin(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        boolean isEmailExists = adminService.isEmailExists(userDTO.getEmail());

        if (isEmailExists) {
            return Result.error("Email already exists");
        }

        try {
            adminService.updateAdmin(id, userDTO);
            return Result.success("Admin updated successfully");
        } catch (Exception e) {
            return Result.error("An error occurred: " + e.getMessage());
        }
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

