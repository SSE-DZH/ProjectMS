package com.zhiend.projectms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhiend.projectms.mapper")
public class ProjectMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMsApplication.class, args);
    }

}
