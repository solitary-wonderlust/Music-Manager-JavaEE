package dao;

import pojo.*;

import java.util.List;

public interface FanDao {
    public Fan queryByUsernameAndPassword(String username,String password);
    public Fan queryByFno(int fno);
    public List<Band> queryLoveBandByfno(int fno);
    public List<Album> queryLoveAlbum(int fno);
    public List<Song> queryLoveSong(int fno);
    public List<Concert> queryConcert(int fno);
}
