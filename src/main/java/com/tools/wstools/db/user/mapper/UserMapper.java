package com.tools.wstools.db.user.mapper;

import com.tools.wstools.db.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zp
 * @date 2024/9/29 17:06
 */
@Mapper
public interface UserMapper {
    int insert(User record);

    int update(User record);

    int delete(Long id);

    User selectById(Long id);

    List<User> selectAll();
}