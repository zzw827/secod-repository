package com.xinyuan.ms.service;

import com.xinyuan.ms.entity.User;
import com.xinyuan.ms.mapper.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author hzx
 * @date 2019/7/10 10:11
 */
@Service
public class UserService extends BaseService<UserRepository, User,Long> {

    /**
     * 删除
     *
     * @param ids
     */
    public void removeList(List<Long> ids) {
        for (Long i : ids) {
            remove(i);
        }
    }
}
