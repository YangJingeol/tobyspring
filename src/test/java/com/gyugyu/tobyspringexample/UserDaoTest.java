package com.gyugyu.tobyspringexample;

import user.dao.ConnectionMaker;
import user.dao.DConnectionMaker;
import user.dao.DaoFactory;
import user.dao.UserDao;
import user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);
        System.out.println(dao.get("whiteship").getName());*/
        UserDao userDao = new DaoFactory().userDao();


        User user = new User();
        user.setId("jingul2");
        user.setName("양진걸");
        user.setPassword("123");
        userDao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user2 = userDao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getId());
        System.out.println(user2.getPassword() + "조회 성공");

    }

}
