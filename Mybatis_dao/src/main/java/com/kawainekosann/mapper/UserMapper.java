package com.kawainekosann.mapper;

import com.kawainekosann.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findByCondition(User user);
    public List<User> findByIds(List<Integer> ids);
    public void save(User user);
}
