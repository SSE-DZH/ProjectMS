package com.zhiend.projectms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname UserDTO
 * @Description 新增用户DTO
 * @Date 2024/7/4 19:22
 * @Created by Zhiend
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String email;
}
