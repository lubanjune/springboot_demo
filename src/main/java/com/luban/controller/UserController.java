package com.luban.controller;

import com.luban.entity.UserEntity;
import com.luban.service.UserService;
import com.luban.web.BaseController;
import com.luban.web.PageRequest;
import com.luban.web.PageResponse;
import com.luban.web.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public WebResult listUser(@RequestParam(required = false, defaultValue = "1") Integer page,
                              @RequestParam(required = false, defaultValue = "20") Integer size,
                              @RequestParam(required = false) String username) {

        PageRequest pageRequest = new PageRequest().setPage(page).setSize(size);

        List<UserEntity> list = userService.list(pageRequest,username);
        long count = userService.count(username);

        PageResponse pageResponse = new PageResponse().setTotal(count).setData(list).setPageRequest(pageRequest);

        return ok(pageResponse);
    }

    @GetMapping("/{id}")
    public WebResult getUser(@PathVariable(value = "id") Integer id) {
        UserEntity userEntity = userService.find(id);

        return ok(userEntity);
    }

    //    @DateTimeFormat(pattern = "yyyy-MM-dd")Date endTime
    @PostMapping("/create")
    public WebResult createUser(String username, String password, Integer sex, Integer age) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setSex(sex);
        userEntity.setAge(age);

        boolean b = userService.create(userEntity);
        return b ? ok() : defaultErr();
    }

    @PostMapping("/update")
    public WebResult updateUser(Integer id, String username, String password, Integer age) {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        if (!StringUtils.isEmpty(username)) {
            userEntity.setUsername(username);
        }

        if (!StringUtils.isEmpty(password)) {
            userEntity.setPassword(password);
        }

        if (age != null) {
            userEntity.setAge(age);
        }

        boolean b = userService.update(userEntity);
        return b ? ok() : defaultErr();
    }

    @PostMapping("/delete/{id}")
    public WebResult deleteUser(@PathVariable Integer id) {

        boolean b = userService.delete(id);
        return b ? ok() : defaultErr();
    }
}
