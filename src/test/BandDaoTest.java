package test;

import dao.BandDao;
import dao.FanDao;
import dao.impl.BandDaoImpl;
import dao.impl.DaoImpl;
import dao.impl.FanDaoImpl;
import org.junit.Test;
import service.FanService;
import service.impl.FanServiceImpl;

public class BandDaoTest {
    @Test
    public void queryBandLog(){
        BandDao bandDao=new BandDaoImpl();
        System.out.println(bandDao.queryByUsernameAndPassword("beast","123456"));
        FanDao fanDao=new FanDaoImpl();
        FanService fanService=new FanServiceImpl();
        System.out.println(fanService.getLoveBand(1));
    }

    @Test
    public void otherband(){
        int fno=1;
        DaoImpl dao=new DaoImpl();
        System.out.println(dao.queryOtherBand(fno));
    }
}
