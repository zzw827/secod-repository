package com.xinyuan.ms.web.controller;

import com.xinyuan.ms.common.util.ResultUtil;
import com.xinyuan.ms.common.web.Message;
import com.xinyuan.ms.common.web.PageBody;
import com.xinyuan.ms.entity.User;
import com.xinyuan.ms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: hzx
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "保存", notes = "保存")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Message> save(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(ResultUtil.success());
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<Message> delete(@RequestBody List<Long> ids) {
        userService.removeList(ids);
        return ResponseEntity.ok(ResultUtil.success());
    }

    @ApiOperation(value = "更新", notes = "更新")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<Message> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(ResultUtil.success());
    }


    @ApiOperation(value = "条件查询", notes = "条件查询")
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Page<User>> query(@RequestBody PageBody pageBody) {
        Page<User> page = null;
        try {
            page = userService.query(pageBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(page);
    }
}
