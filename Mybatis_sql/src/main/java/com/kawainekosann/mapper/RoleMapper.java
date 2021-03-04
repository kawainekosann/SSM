package com.kawainekosann.mapper;

import com.kawainekosann.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("SELECT * FROM sys_user_role ur, sys_role r WHERE ur.userid=#{id} and ur.roleid = r.\"id\" ")
    public List<Role> findByUid(int uid);
}
