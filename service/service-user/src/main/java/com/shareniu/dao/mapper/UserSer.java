package com.shareniu.dao.mapper;
import java.util.List;

import com.shareniu.dao.entity.UserEntity;
import com.shareniu.user.po.UserPo;


/**
 * TUser Query Dao
 * @author system
 */
public interface UserSer {
    /**
     * query list without page
     * @author system
     * @param tUser tUser 
     * @return List<TUserEntity>
     */
    public List<UserEntity> selectTUserListByCond(UserPo tUser);
    
    /**
     * query record
     * @author system
     * @param tUser tUser
     * @return TUserEntity
     */
    public UserEntity selectTUserByCond(UserPo tUser);
}