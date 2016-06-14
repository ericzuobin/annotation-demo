package net.zuobin.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Sahinn
 * @date 16/6/13
 */
public class UserDaoImpl{

    //UserDao如果需要扩展,就需要此EntityManager
    @PersistenceContext
    private EntityManager em;



}
