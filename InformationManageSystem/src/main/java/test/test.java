package test;

import Dao.FlyAshDao;
import Dao.UserDao;
import Util.GraphicUtils;
import domain.FlyAsh;
import domain.User;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class test {

    @Test
    public void DateTest(){

    }

    @Test
    public void FlyAshDeleteTest(){
        FlyAsh flyAsh = new FlyAsh();
        flyAsh.setId(2);
        FlyAshDao flyAshDao = new FlyAshDao();
        int res = flyAshDao.delete(flyAsh);
        if(res > 0){
            System.out.println("succeed!");
        }else{
            System.out.println("failed!");
        }
    }

    @Test
    public void FlyAshDaoInsertTest(){
        FlyAsh flyAsh = new FlyAsh(0,"慈溪飞灰","飞灰",new Date(2020-1900,9-1,1),"电熔融","无");
        FlyAshDao flyAshDao = new FlyAshDao();
        int res = flyAshDao.insert(flyAsh);
        if (res > 0) {
            System.out.println("succeed!");
        } else {
            System.out.println("failed!");
        }
    }

    @Test
    public void FlyAshDaoSeachAllTest(){
        FlyAshDao flyAshDao = new FlyAshDao();
        List<FlyAsh> flyAshes = flyAshDao.searchAll();
        for(FlyAsh fa : flyAshes) {
            System.out.println(fa);
        }
    }

    @Test
    public void FlyAshDaoNameSearchTest(){
        FlyAsh flyAsh = new FlyAsh();
        FlyAshDao flyAshDao = new FlyAshDao();
        flyAsh.setName("诸暨飞灰");
        FlyAsh res = flyAshDao.nameSearch(flyAsh);
        System.out.println(res);
    }

    @Test
    public void FlyAshDaoOriginSearchTest(){
        FlyAsh flyAsh = new FlyAsh();
        flyAsh.setOrigin("诸暨");
        System.out.println(flyAsh);
        FlyAshDao flyAshDao = new FlyAshDao();
        Map<String, Object> result = flyAshDao.originSearch(flyAsh);
        System.out.println(result);
    }

    @Test
    public void UserDaoLoginTest() {
        User user = new User();
        user.setUsername("Alan");
        user.setPassword("aaa");
        UserDao userDao = new UserDao();
        System.out.println(userDao.login(user));
    }

    @Test
    public void UserDaoRegisterTest(){
        User user = new User();
        user.setUsername("Cart");
        user.setPassword("ccc");
        UserDao userDao = new UserDao();
        System.out.println(userDao.register(user));
    }

    @Test
    public void UserDaoExistTest(){
        User user = new User();
        UserDao userDao = new UserDao();
        user.setUsername("blan");
        User exist = userDao.exist(user);
        System.out.println(exist);
    }
}
