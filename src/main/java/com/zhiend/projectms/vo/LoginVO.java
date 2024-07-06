package com.zhiend.projectms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname LoginVO
 * @Description 登录返回信息
 * @Date 2024/7/6 15:16
 * @Created by Zhiend
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    private Long id;
    private String username;
    private String email;
}
