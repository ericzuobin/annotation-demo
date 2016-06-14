package net.zuobin.dao;

import net.zuobin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Sahinn
 * @date 16/6/13
 * 使用Spring Data,JpaRepository
 */
public interface UserDao extends JpaRepository<User,Long> {
    //可以为空,使用接口的方法

    //使用query来做查询
    @Query("select u from User u where u.uid = :uid")
    public User findByUID(@Param("uid")Long uid);
}
