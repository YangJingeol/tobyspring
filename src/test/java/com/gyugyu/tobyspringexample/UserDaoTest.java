package com.gyugyu.tobyspringexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        dao = context.getBean("userDao", UserDao.class);
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException{
        User user1 = new User("gyumee" , "박성철", "springnol");
        User user2 = new User("leegw700", "이길원", "pringno2");

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
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
