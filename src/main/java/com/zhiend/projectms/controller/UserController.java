package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.UserDTO;
import com.zhiend.projectms.entity.User;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.save(user);
        return Result.success("User registered successfully");
    }

    @ApiOperation(value = "获取所有用户")
    @GetMapping("/all")
    public Result<List<User>> getAllUsers() {
        List<User> users = userService.list();
        return Result.success(users);
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
    public Result<?> updateUser(@RequestBody User user) {
//        User user = userService.getById(user.getId());
        if (userService.getById(user.getId()) == null) {
            return Result.error("User not found");
        }
//        BeanUtils.copyProperties(userDTO, user);
        userService.updateById(user);
        return Result.success("User updated successfully");
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public Result<?> deleteUser(@PathVariable Integer id) {
        boolean removed = userService.removeById(id);
        if (!removed) {
            return Result.error("User not found");
        }
        return Result.success("User deleted successfully");
    }
}

