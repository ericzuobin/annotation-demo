package net.zuobin.service;

import net.zuobin.entity.User;

/**
 * @author Sahinn
 * @date 16/6/13
 */
public interface UserService {

    void save(User user);

    void delete(User user);

    void update(User user);

    void findById(Long id);

    User findByUId(Long id);
}
