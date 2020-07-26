package com.luban.service;

import com.luban.entity.UserEntity;
import com.luban.web.PageRequest;

import java.util.List;

public interface UserService {

    List<UserEntity> list(PageRequest request,String username);

    UserEntity find(Integer id);

    long count(String username);

    boolean create(UserEntity userEntity);

    boolean update(UserEntity userEntity);

    boolean delete(Integer id);
}
