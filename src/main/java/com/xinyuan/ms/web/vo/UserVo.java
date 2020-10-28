package com.xinyuan.ms.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**

 * @author hwz
 */
@Data

public class UserVo  {

    @ApiModelProperty(value = "主键", name = "id", example = "0")
    private Long id;

    @ApiModelProperty(value = "昵称", name = "nickname", example = "张三")
    private String nickname;

    @ApiModelProperty(value = "用户名（唯一）", name = "username", example = "username")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "password")
    @Column(name = "password")
    private String password;

}
