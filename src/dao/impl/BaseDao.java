package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner=new QueryRunner();
    /**
     *
     * update()方法用来执行：Insert\Update\Delete语句
     * @return 返回-1，执行失败； 返回影响的行数
     */
    public int update(String sql,Object ... args){
        Connection conn= JdbcUtils.getConnection();

        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
           JdbcUtils.close(conn);
        }
            return -1;
    }
    public <T> T queryForOne(Class<T> type,String sql,Object ... args){
        Connection conn= JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
          JdbcUtils.close(conn);
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection conn= JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    public Object queryForSingleValue(String sql,Object...args){
        Connection conn=JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
          JdbcUtils.close(conn);
        }
        return null;
    }

}
