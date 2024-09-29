package com.tools.wstools.db.user.entity;

import lombok.Data;

/**
 * @author zp
 * @date 2024/9/29 17:03
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
