package dao.impl;

import dao.impl.BaseDao;
import org.junit.Test;
import pojo.*;

import java.sql.Date;
import java.util.List;

public class DaoImpl extends BaseDao {
    //查询乐迷未关注的乐队
    public List<Band> queryOtherBand(int fno){
        String sql="SELECT * FROM band \n" +
                "WHERE bno NOT IN\n" +
                "\t(SELECT flb.bno\n" +
                "\tFROM flb,band \n" +
                "\tWHERE flb.bno=band.bno AND fno= ? \n" +
                "\t)";
        return queryForList(Band.class,sql,fno);
    }
    //查询乐迷未喜欢的专辑
    public List<Album> queryOtherAlbum(int fno) {
        String sql="SELECT * FROM album \n" +
                "WHERE ano NOT IN\n" +
                "\t(SELECT fla.ano\n" +
                "\tFROM fla,album \n" +
                "\tWHERE fla.ano=album.ano AND fno= ? \n" +
                "\t);";
        return queryForList(Album.class,sql,fno);
    }
    //查询乐迷未喜欢的歌曲
    public List<Song> queryOtherSong(int fno) {
        String sql="SELECT * FROM song \n" +
                "WHERE sno NOT IN\n" +
                "\t(SELECT fls.sno\n" +
                "\tFROM fls,song \n" +
                "\tWHERE fls.sno=song.sno AND fno= ? \n" +
                "\t); ";
        return queryForList(Song.class,sql,fno);
    }
    //查询乐迷未参加的演唱会
    public List<Concert> queryOtherConcert(int fno) {
        String sql="SELECT * FROM concert \n" +
                "WHERE cno NOT IN\n" +
                "\t(SELECT fac.cno\n" +
                "\tFROM fac,concert \n" +
                "\tWHERE fac.cno=concert.cno AND fno= ? \n" +
                "\t); ";
        return queryForList(Concert.class,sql,fno);
    }
    //修改乐迷基本信息
    public void updateFan(int fno,String fname,String fsex,int fage,String fjob){
        String sql="UPDATE fan\n" +
                "\tSET fname=? , fsex=?,fage=?,fjob=?\n" +
                "\tWHERE fno=?";
        update(sql,fname,fsex,fage,fjob,fno);
    }
    //通过乐队名称删除喜欢的乐队
    public void deleteLoveBand(int fno,String bname){
        String sql="DELETE FROM flb\n" +
                "WHERE fno=? AND bno IN\n" +
                "\t(\n" +
                "\t\tSELECT bno FROM band\n" +
                "\t\tWHERE bname=? \n" +
                "\t)";
        update(sql,fno,bname);
    }
    //通过乐队名称添加喜欢的乐队
    public void addLoveBand(int fno,String bname){
        String sql="INSERT INTO flb (fno,bno) VALUES (?,(SELECT bno FROM band WHERE bname=?))";
        update(sql,fno,bname);
    }
    //通过专辑名称删除喜欢的专辑
    public void deleteLoveAlbum(int fno,String aname){
        String sql="DELETE FROM fla\n" +
                "WHERE fno=? AND ano IN\n" +
                "\t(\n" +
                "\t\tSELECT ano FROM album\n" +
                "\t\tWHERE aname=? \n" +
                "\t)";
        update(sql,fno,aname);
    }
    //通过专辑名称添加喜欢的专辑
    public void addLoveAlbum(int fno,String aname){
        String sql="INSERT INTO fla (fno,ano) VALUES (?,(SELECT ano FROM album WHERE aname=?))";
        update(sql,fno,aname);
    }
    //通过歌曲名称删除喜欢的歌曲
    public void deleteLoveSong(int fno,String sname){
        String sql="DELETE FROM fls\n" +
                "WHERE fno=? AND sno IN\n" +
                "\t(\n" +
                "\t\tSELECT sno FROM song\n" +
                "\t\tWHERE sname=? \n" +
                "\t)";
        update(sql,fno,sname);
    }
    //通过歌曲名称添加喜欢的歌曲
    public void addLoveSong(int fno,String sname){
        String sql="INSERT INTO fls (fno,sno) VALUES (?,(SELECT sno FROM song WHERE sname=?))";
        update(sql,fno,sname);
    }
    //通过演唱会名称删除参加的演唱会
    public void deleteLoveConcert(int fno,String cname){
        String sql="DELETE FROM fac\n" +
                "WHERE fno=? AND cno IN\n" +
                "\t(\n" +
                "\t\tSELECT cno FROM concert\n" +
                "\t\tWHERE cname=? \n" +
                "\t)";
        update(sql,fno,cname);
    }
    //通过演唱会名称将演唱会添加到参加的演唱会
    public void addLoveConcert(int fno,String cname){
        String sql="INSERT INTO fac (fno,cno) VALUES (?,(SELECT cno FROM concert WHERE cname=?))";
        update(sql,fno,cname);
    }


    //通过bno查询乐队成员
    public List<Member> queryBandMember(int bno){
        String sql="SELECT Division,mname,mage,msex FROM band,banmer,member\n" +
                "WHERE bno=? AND bmbno=bno AND bmmno=mno";
        return queryForList(Member.class,sql,bno);
    }
    //通过bno查询乐队专辑
    public List<Album> queryBandAlbum(int bno) {
        String sql = "SELECT * FROM album\n" +
                "WHERE abno =?;";
        return queryForList(Album.class,sql,bno);
    }
    //通过bno查询乐队歌曲
    public List<Song> queryBandSong(int bno) {
        String sql = "SELECT sname,swriter,aname FROM song,album\n" +
                "WHERE sano=ano AND sano IN\n" +
                "\t(SELECT ano FROM album\n" +
                "\tWHERE abno=?\n" +
                "\t)";
        return queryForList(Song.class,sql,bno);
    }
    //通过bno查询乐队演唱会
    public List<Concert> queryBandConcert(int bno) {
        String sql = "SELECT * FROM concert\n" +
                "WHERE cno IN\n" +
                "\t(SELECT cbs_cno FROM  cbs\n" +
                "\tWHERE cbs_bno=?\n" +
                "\t)";
        return queryForList(Concert.class,sql,bno);
    }
    //通过bno查询乐队的粉丝
    public List<Fan> queryBandFan(int bno) {
        String sql = "SELECT fname,fsex,fage,fjob FROM fan,flb\n" +
                "WHERE fan.fno=flb.fno AND flb.bno=?;";
        return queryForList(Fan.class,sql,bno);
    }
    //通过bno查询喜欢乐队的专辑的粉丝
    public List<Fan> queryAlbumFan(int bno){
        String sql="SELECT aname lovealbumname,fname,fsex,fage,fjob \n" +
                "FROM fan,fla,album\n" +
                "WHERE fan.fno=fla.fno AND fla.ano=album.ano AND fla.ano IN\n" +
                "\t(SELECT ano FROM album\n" +
                "\tWHERE abno =?\n" +
                "\t)";
        return  queryForList(Fan.class,sql,bno);
    }
    //通过bno查询喜欢乐队的歌曲的粉丝
    public List<Fan> querySongFan(int bno){
        String sql="SELECT sname lovesongname,fname,fsex,fage,fjob\n" +
                "FROM fan,fls,song\n" +
                "WHERE fan.fno=fls.fno AND fls.sno=song.sno AND fls.sno IN \n" +
                "\t(SELECT sno FROM song\n" +
                "\tWHERE sano IN\n" +
                "\t\t(SELECT ano FROM album\n" +
                "\t\tWHERE abno=?\n" +
                "\t\t)\n" +
                "\t)";
        return  queryForList(Fan.class,sql,bno);
    }
    //通过bno查询参加乐队的演唱会的粉丝
    public List<Fan> queryConcertFan(int bno){
        String sql="SELECT cname loveconcertname,fname,fsex,fage,fjob\n" +
                "FROM fan,fac,concert\n" +
                "WHERE fac.cno=concert.cno AND fan.fno=fac.fno AND fac.cno IN\n" +
                "\t(SELECT cbs_cno FROM  cbs\n" +
                "\tWHERE cbs_bno=?\n" +
                "\t)";
        return  queryForList(Fan.class,sql,bno);
    }
    //通过bno，乐队分工和队员姓名删除乐队成员
    public void deleteBandMember(int bno,String division,String name){
        String sql="DELETE FROM banmer \n" +
                "WHERE bmbno=? AND Division=? AND bmmno IN\n" +
                "\t(SELECT mno FROM member\n" +
                "\t WHERE mname=?\n" +
                "\t)";
        update(sql,bno,division,name);
        sql="SELECT COUNT(*) FROM banmer WHERE bmbno=?";
        long bmenum= (long) queryForSingleValue(sql,bno);
        sql="UPDATE band SET bmenum=? WHERE bno=?";
        update(sql,bmenum,bno);
    }
    //通过提交的bno，乐队分工、队员姓名、年龄、性别添加乐队新的成员
    public void addBandMember(int bno,String division,String name,int age,String sex){
        String sql="SELECT MAX(mno) FROM member";
        int mno= (int) queryForSingleValue(sql);
        mno=mno+1;
        sql="INSERT INTO member VALUES (?,?,?,?)";
        update(sql,mno,name,sex,age);
        sql="INSERT INTO banmer VALUES (?,?,?,?,NULL)";
        Date jointime=new Date(new java.util.Date().getTime());
        update(sql,bno,mno,division,jointime);
        sql="SELECT COUNT(*) FROM banmer WHERE bmbno=?";
        long bmenum= (long) queryForSingleValue(sql,bno);
        sql="UPDATE band SET bmenum=? WHERE bno=?";
        update(sql,bmenum,bno);
    }
    //通过提交的bno，队员姓名、发行公司添加新的乐队专辑
    public void addBandAlbum(int bno,String aname,String acom){
        String sql="SELECT MAX(ano) FROM album";
        int ano= (int) queryForSingleValue(sql);
        ano=ano+1;
        Date aestime=new Date(new java.util.Date().getTime());
        sql="INSERT INTO album VALUES (?,?,?,?,?)";
        update(sql,ano,aname,aestime,bno,acom);
    }
    //通过bno、专辑名称删除乐队专辑
    public void deleteBandAlbum(int bno,String aname){
        String sql="DELETE FROM album WHERE abno=? AND aname=?";
        update(sql,bno,aname);
    }
    //通过bno、歌曲名字删除乐队歌曲
    public void deleteBandSong(int bno,String sname){
        String sql="DELETE FROM song\n" +
                "WHERE sname=? AND sano IN\n" +
                "\t(SELECT ano\n" +
                "\tFROM album\n" +
                "\tWHERE abno=?\n" +
                "\t)";
        update(sql,sname,bno);
    }
    //通过提交的bno，歌曲名称、创作者、所在专辑的名称添加新的乐队歌曲
    public void addBandSong(int bno,String sname,String swriter,String aname){
        String sql="SELECT MAX(sno) FROM song";
        int sno= (int) queryForSingleValue(sql);
        sno=sno+1;
        sql="SELECT ano FROM album WHERE aname=? AND abno=?";
        int sano=(int) queryForSingleValue(sql,aname,bno);
        sql="INSERT INTO song VALUES (?,?,?,?)";
        update(sql,sno,sname,swriter,sano);
    }
    //通过bno，提交的乐队名称，创立时间，队员人数更新乐队信息
    public void updateBand(int bno,String bname,String estime,int bmenum){
        String sql="UPDATE band \n" +
                "SET bname=?,estime=?,bmenum=?\n" +
                "WHERE bno=?";
        update(sql,bname,estime,bmenum,bno);
    }
    //通过bno，演唱会名称删除乐队的演唱会
    public void deleteBandConcert(int bno,String cname){
        String sql="DELETE FROM cbs\n" +
                "WHERE cbs_bno=? AND cbs_cno IN\n" +
                "\t(SELECT cno \n" +
                "\tFROM concert\n" +
                "\tWHERE cname=?\n" +
                "\t)";
        update(sql,bno,cname);
    }
    //通过提交的bno，演唱会名称、开始时间、结束时间、举办地点添加新的乐队演唱会
    public void addBandConcert(int bno,String cname,String cstartime,String cendtime,String clocal){
        String sql="SELECT MAX(cno) FROM concert";
        int cno= (int) queryForSingleValue(sql);
        cno=cno+1;
        sql="INSERT INTO concert VALUES(?,?,?,?,?)";
        update(sql,cno,cname,cstartime,cendtime,clocal);
        sql="INSERT INTO cbs VALUES(?,?,1,1)";
        update(sql,cno,bno);
    }
    //通过名称模糊查询乐队
    public List<Band> searchBand(String name){
        name="%"+name+"%";
        String sql="SELECT * FROM band \n" +
                "WHERE bname LIKE ?\n";
        return queryForList(Band.class,sql,name);
    }
    //通过名称模糊查询专辑
    public List<Album> searchAlbum(String name) {
        name="%"+name+"%";
        String sql="SELECT * FROM album \n" +
                "WHERE aname LIKE ?\n";
        return queryForList(Album.class,sql,name);
    }
    //通过名称模糊查询歌曲
    public List<Song> searchSong(String name) {
        name="%"+name+"%";
        String sql="SELECT * FROM song \n" +
                "WHERE sname LIKE ?\n";
        return queryForList(Song.class,sql,name);
    }
    //通过名称模糊查询演唱会
    public List<Concert> searchConcert(String name) {
        name="%"+name+"%";
        String sql="SELECT * FROM concert \n" +
                "WHERE cname LIKE ?\n";
        return queryForList(Concert.class,sql,name);
    }
}
