package service;

import pojo.*;

import java.util.List;

public interface FanService {
    public Fan login(Fan Fan);
    public Fan getInfo(int fno);
    public List<Band> getLoveBand(int fno);
    public List<Album> getLoveAlbum(int fno);
    public List<Song> getLoveSong(int fno);
    public List<Concert> getConcert(int fno);
}
