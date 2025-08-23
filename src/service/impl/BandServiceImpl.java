package service.impl;

import dao.BandDao;
import dao.impl.BandDaoImpl;
import pojo.Band;
import service.BandService;

public class BandServiceImpl implements BandService {
    private BandDao bandDao=new BandDaoImpl();
    @Override
    public Band login(Band band) {
        return bandDao.queryByUsernameAndPassword(band.getUsername(),band.getPassword());
    }

    @Override
    public Band getInfo(int bno) {
        return bandDao.queryByBno(bno);
    }
}
