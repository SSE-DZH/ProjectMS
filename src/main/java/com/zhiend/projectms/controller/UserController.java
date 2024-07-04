package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.UserDTO;
import com.zhiend.projectms.entity.User;
import com.zhiend.projectms.page.BackPage;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Result<?> register(@RequestBody UserDTO userDTO) {
        boolean isEmailExists = userService.isEmailExists(userDTO.getEmail());

        if (isEmailExists) {
            return Result.error("Email already exists");
        }

        userService.register(userDTO);
        return Result.success("User registered successfully");
    }


    @ApiOperation(value = "获取所有用户分页信息")
    @GetMapping("/all")
    public Result<BackPage<User>> getAllUsers(@RequestParam("pageNo") Long pageNo, @RequestParam("pageSize") Long pageSize) {
        if (pageNo == null || pageSize == null) {
            return Result.error("pageNo and pageSize cannot be null");
        }
        log.info("getAllUsers: pageNo={}, pageSize={}", pageNo, pageSize);
        BackPage<User> userBackPage = userService.listByBackPage(pageNo, pageSize);
        if(userBackPage == null){
            return Result.error("User not found");
        }
        return Result.success(userBackPage);
    }


    @ApiOperation(value = "根据ID获取用户")
    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Integer id) {
        User user = userService.getById(id);
        if (user == null) {
            return Result.error("User not found");
        }
        return Result.success(user);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/{id}")
    public Result<?> updateAdmin(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        boolean isEmailExists = userService.isEmailExists(userDTO.getEmail());

        if (isEmailExists) {
            return Result.error("Email already exists");
        }

        try {
            userService.updateAdmin(id, userDTO);
            return Result.success("Admin updated successfully");
        } catch (Exception e) {
            return Result.error("An error occurred: " + e.getMessage());
        }
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    @Transactional
    public Result<?> deleteUser(@PathVariable Integer id) {
        boolean removed = userService.removeById(id);
        if (!removed) {
            return Result.error("User not found");
        }
        return Result.success("User deleted successfully");
    }
}

