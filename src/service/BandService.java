package service;

import pojo.Band;
import pojo.Fan;

public interface BandService {
    public Band login(Band band);
    public Band getInfo(int bno);
}
