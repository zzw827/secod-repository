package com.xinyuan.ms.mapper;

import com.xinyuan.ms.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author hzx
 * @date 2019/7/10 10:10
 */
@Repository
public interface UserRepository extends BaseJpaRepository<User,Long>{

}
