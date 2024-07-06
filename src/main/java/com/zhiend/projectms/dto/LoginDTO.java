package com.zhiend.projectms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname LoginDTO
 * @Description 登录DTO
 * @Date 2024/7/6 15:15
 * @Created by Zhiend
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String password;
    private String email;
}
