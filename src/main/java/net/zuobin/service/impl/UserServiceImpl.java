package net.zuobin.service.impl;

import net.zuobin.dao.UserDao;
import net.zuobin.entity.User;
import net.zuobin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Sahinn
 * @date 16/6/13
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void findById(Long id) {

    }

    @Override
    public User findByUId(Long id) {
        return userDao.findByUID(id);
    }

}
