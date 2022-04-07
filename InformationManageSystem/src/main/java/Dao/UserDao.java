package Dao;

import Util.JDBCUtils;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDs());

    public User login(User user) {
        try {
            String sql = "select * from user where username = ? and password = ?;";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int register(User user) {
        String sql = "insert into user values (null, ?, ?);";
        return jdbcTemplate.update(sql, new Object[]{user.getUsername() , user.getPassword()}, new int[]{Types.VARCHAR, Types.VARCHAR});
    }

    public User exist(User user) {
        try {
            String sql = "select * from user where username = ?;";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
