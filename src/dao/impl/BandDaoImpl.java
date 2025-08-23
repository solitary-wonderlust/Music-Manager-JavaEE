package dao.impl;

import dao.BandDao;
import pojo.Band;
import pojo.Fan;

import java.util.List;

public class BandDaoImpl extends BaseDao implements BandDao {
    /**
     * 通过用户名密码参数查询数据库中的band_log表有无符合的结果
     * @param username
     * @param password
     * @return 若用户名密码正确，返回一个Band对象且根据查询结果对其bno属性赋值；否则返回NULL
     */
    @Override
    public Band queryByUsernameAndPassword(String username, String password) {
        String sql="SELECT bno,username,password FROM band_log WHERE username= ? AND password= ? ";
        return queryForOne(Band.class,sql,username,password);
    }
    //通过bno查询该乐队的所有信息，并通过一个Band对象返回
    @Override
    public Band queryByBno(int bno) {
        String sql="SELECT * FROM band WHERE bno=?";
        return queryForOne(Band.class,sql,bno);
    }
}
