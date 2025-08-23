package dao;

import pojo.Band;
import pojo.Fan;

public interface BandDao {
    public Band queryByUsernameAndPassword(String username,String password);
    public Band queryByBno(int bno);
}
