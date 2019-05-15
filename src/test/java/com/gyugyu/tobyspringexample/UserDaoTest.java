package com.gyugyu.tobyspringexample;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import user.dao.ConnectionMaker;
import user.dao.DConnectionMaker;
import user.dao.DaoFactory;
import user.dao.UserDao;
import user.domain.User;

import static org.hamcrest.CoreMatchers.is;

import java.sql.SQLException;

import static org.junit.Assert.assertThat;

public class UserDaoTest {

    private UserDao dao;
    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        dao = context.getBean("userDao", UserDao.class);
    }

    @Test
    public void count() throws SQLException, ClassNotFoundException{
        User userl = new User("gyumee" , "박성철", "springnol");
        User user2 = new User("leegw700", "이길원", "pringno2");
        User user3 = new User("bumjin", "박범진", "springno3" );
        dao.deleteAll(); assertThat(dao.getCount() , is(0));
        dao.add(userl);
        assertThat (dao .getCount() , is(1));
        dao .add(user2);
        assertThat(dao.getCount(), is(2));
        dao.add(user3);
        assertThat(dao.getCount() , is(3)) ;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);
        System.out.println(dao.get("whiteship").getName());*/
/*        UserDao userDao = new DaoFactory().userDao();


        User user = new User();
        user.setId("jingul2");
        user.setName("양진걸");
        user.setPassword("123");
        userDao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user2 = userDao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getId());
        System.out.println(user2.getPassword() + "조회 성공");*/

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);




    }

}
