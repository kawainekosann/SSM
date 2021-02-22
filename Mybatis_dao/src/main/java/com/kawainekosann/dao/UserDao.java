package com.kawainekosann.dao;

import com.kawainekosann.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    public List<User> findAll() throws IOException;
}
