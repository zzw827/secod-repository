package com.xinyuan.ms.web.request;

import com.xinyuan.ms.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hwz
 * @Description:
 * @date 2018/5/3017:55
 */
@Data
public class SaveUserRequest {

    @ApiModelProperty(value = "所属角色,（1管理员，2医生，3用户，4客服）", name = "role")
    private Long role;

    @ApiModelProperty(value = "用户信息", name = "user")
    private User user;
}
