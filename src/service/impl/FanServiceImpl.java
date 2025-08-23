package service.impl;

import dao.FanDao;
import dao.impl.FanDaoImpl;
import pojo.*;
import service.FanService;

import java.util.List;

public class FanServiceImpl implements FanService {
    private FanDao fanDao=new FanDaoImpl();
    @Override
    public Fan login(Fan fan) {
        return(fanDao.queryByUsernameAndPassword(fan.getUsername(),fan.getPassword()));
    }
    public Fan getInfo(int fno){return fanDao.queryByFno(fno);}
    public List<Band> getLoveBand(int fno){return fanDao.queryLoveBandByfno(fno);}
    public List<Album> getLoveAlbum(int fno){return fanDao.queryLoveAlbum(fno);}
    public List<Song> getLoveSong(int fno){return fanDao.queryLoveSong(fno);}
    public List<Concert> getConcert(int fno){return fanDao.queryConcert(fno);}
}
