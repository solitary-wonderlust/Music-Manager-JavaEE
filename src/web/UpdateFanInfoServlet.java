package web;

import dao.impl.DaoImpl;
import pojo.*;
import service.FanService;
import service.impl.FanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//完成乐迷界面下修改乐迷基本信息操作
public class UpdateFanInfoServlet extends HttpServlet {
    private DaoImpl dao=new DaoImpl();
    private FanService fanService=new FanServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fno =Integer.parseInt(req.getParameter("fno"));
        String fname=req.getParameter("fname");
        String fsex=req.getParameter("fsex");
        int fage= Integer.parseInt(req.getParameter("fage"));
        String fjob=req.getParameter("fjob");
        dao.updateFan(fno,fname,fsex,fage,fjob);

        Fan fan;
        fan=fanService.getInfo(fno);
        req.setAttribute("fno",fan.getFno());
        req.setAttribute("fname",fan.getFname());
        req.setAttribute("fsex",fan.getFsex());
        req.setAttribute("fage",fan.getFage());
        req.setAttribute("fjob",fan.getFjob());
        List<Band> loveBand=fanService.getLoveBand(fan.getFno());
        List<Album> loveAlbum = fanService.getLoveAlbum(fan.getFno());
        List<Song> loveSong = fanService.getLoveSong(fan.getFno());
        List<Concert> concert = fanService.getConcert(fan.getFno());
        req.setAttribute("loveband",loveBand);
        req.setAttribute("lovealbum",loveAlbum);
        req.setAttribute("lovesong",loveSong);
        req.setAttribute("concert",concert);
        req.getRequestDispatcher("pages/fanlog_sucess_menu.jsp").forward(req,resp);
    }
}
