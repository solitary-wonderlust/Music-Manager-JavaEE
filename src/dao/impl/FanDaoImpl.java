package dao.impl;

import dao.FanDao;
import pojo.*;

import java.util.List;
    //通过账号密码查询有无对应的fno
public class FanDaoImpl extends BaseDao implements FanDao {
    @Override
    public Fan queryByUsernameAndPassword(String username, String password) {
        String sql="SELECT fno,username,password FROM fan_log WHERE username= ? AND password= ? ";
        return queryForOne(Fan.class,sql,username,password);
    }
    //通过fno查询fan的所有信息
    @Override
    public Fan queryByFno(int fno) {
        String sql="SELECT * FROM fan WHERE fno=?";
        return queryForOne(Fan.class,sql,fno);
    }
    //通过fno查询喜欢的乐队
    public List<Band> queryLoveBandByfno(int fno) {
        String sql="SELECT flb.bno bno,bname,estime,distime,bleano,bmenum FROM flb,band WHERE flb.bno=band.bno AND fno= ? ";
        return queryForList(Band.class,sql,fno);
    }
    //通过fno查询喜欢的专辑
    public List<Album> queryLoveAlbum(int fno) {
        String sql="SELECT fla.ano,aname,aestime,abno,acom FROM fla,album WHERE fla.ano=album.ano AND fno= ? ";
        return queryForList(Album.class,sql,fno);
    }
    //通过fno查询喜欢的歌曲
    public List<Song> queryLoveSong(int fno) {
        String sql="SELECT fls.sno,sname,swriter,sano FROM fls,song WHERE fls.sno=song.sno AND fno= ? ";
        return queryForList(Song.class,sql,fno);
    }
    //通过fno查询参加的演唱会
    public List<Concert> queryConcert(int fno) {
        String sql="SELECT fac.cno,cname,cstartime,cendtime,clocal FROM fac,concert WHERE fac.cno=concert.cno AND fno= ? ";
        return queryForList(Concert.class,sql,fno);
    }
}
