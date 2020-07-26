package com.luban.service.impl;

import com.luban.entity.UserEntity;
import com.luban.entity.UserEntityExample;
import com.luban.mapper.UserEntityMapper;
import com.luban.service.UserService;
import com.luban.web.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public List<UserEntity> list(PageRequest request, String username) {

        UserEntityExample userEntityExample = new UserEntityExample();
        UserEntityExample.Criteria criteria = userEntityExample.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameEqualTo(username);
        }

        if (request != null) {
            userEntityExample.setOrderByClause(request.toSqlString());
        }

        return userEntityMapper.selectByExample(null);
    }

    @Override
    public UserEntity find(Integer id) {
        return userEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public long count(String username) {

        UserEntityExample userEntityExample = new UserEntityExample();
        UserEntityExample.Criteria criteria = userEntityExample.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameEqualTo(username);
        }

        return userEntityMapper.countByExample(userEntityExample);
    }

    @Override
    public boolean create(UserEntity userEntity) {
        int i = userEntityMapper.insertSelective(userEntity);
        return i == 1;
    }

    @Override
    public boolean update(UserEntity userEntity) {
        int i = userEntityMapper.updateByPrimaryKeySelective(userEntity);

        return i == 1;
    }

    @Override
    public boolean delete(Integer id) {
        int i = userEntityMapper.deleteByPrimaryKey(id);
        return i == 1;
    }
}
