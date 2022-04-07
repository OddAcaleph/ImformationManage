package Dao;

import Util.JDBCUtils;
import domain.FlyAsh;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class FlyAshDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDs());

    public int updata(int id, FlyAsh newFA) {
        try {
            String sql = "update FlyAsh set name = ? , type = ? , getDate = ? , origin = ? , remark = ? where id = ?;";
            return jdbcTemplate.update(sql, newFA.getName(), newFA.getType(), newFA.getGetDate(), newFA.getOrigin(), newFA.getRemark(), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void deleteIds(int[] ids) {
        try {
            String sql = "delete from FlyAsh where id = ?;";
            for (int i = 0; i < ids.length; i++) {
                jdbcTemplate.update(sql, ids[i]);
            }
            String reset_auto_increment1 = "alter table FlyAsh drop id;";
            String reset_auto_increment2 = "alter table FlyAsh add id int primary key auto_increment first;";
            jdbcTemplate.execute(reset_auto_increment1);
            jdbcTemplate.execute(reset_auto_increment2);
        }catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public int delete(int id){
        try {
            String sql = "delete from FlyAsh where id = ?;";
            int res = jdbcTemplate.update(sql, id);
            String reset_auto_increment1 = "alter table FlyAsh drop id;";
            String reset_auto_increment2 = "alter table FlyAsh add id int primary key auto_increment first;";
            jdbcTemplate.execute(reset_auto_increment1);
            jdbcTemplate.execute(reset_auto_increment2);
            return res;
        }catch (DataAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int delete(FlyAsh fa){
        try {
            String sql = "delete from FlyAsh where id = ?;";
            int res = jdbcTemplate.update(sql, fa.getId());
            String reset_auto_increment1 = "alter table FlyAsh drop id;";
            String reset_auto_increment2 = "alter table FlyAsh add id int primary key auto_increment first;";
            jdbcTemplate.execute(reset_auto_increment1);
            jdbcTemplate.execute(reset_auto_increment2);
            return res;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int insert(FlyAsh fa){
        FlyAsh existed = this.nameSearch(fa);
        if(existed != null) return -1;
        String sql = "insert into FLyASh values (?, ?, ?, ?, ?, ?);";
        try {
            return jdbcTemplate.update(sql, fa.getId(), fa.getName(), fa.getType(), fa.getGetDate(), fa.getOrigin(), fa.getRemark());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<FlyAsh> searchAll(){
        try{
            String sql = "select * from FlyAsh;";
            List<FlyAsh> flyAshes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<FlyAsh>(FlyAsh.class));
            return flyAshes;
        } catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public FlyAsh idSearch(int id){
        try {
            String sql = "select * from FlyAsh where id = ?;";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<FlyAsh>(FlyAsh.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public FlyAsh nameSearch(FlyAsh fa){
        try {
            String sql = "select * from FlyAsh where name = ?;";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<FlyAsh>(FlyAsh.class), fa.getName());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Object> originSearch(FlyAsh fa) {
        try{
            String sql = "select * from FlyAsh where origin = ?;";
            return jdbcTemplate.queryForMap(sql, fa.getOrigin());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
