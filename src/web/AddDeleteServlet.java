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

//完成乐迷界面下添加和删除乐迷喜欢的乐队、专辑、歌曲、演唱会操作
public class AddDeleteServlet extends HttpServlet {
    private DaoImpl dao = new DaoImpl();
    private FanService fanService = new FanServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fno = Integer.parseInt(req.getParameter("fno"));
        String name = req.getParameter("name");
        String submit = req.getParameter("submit");

        Fan fan;


        if (submit.equals("添加乐队")) {
            dao.addLoveBand(fno, name);
        } else if (submit.equals("删除乐队")) {
            dao.deleteLoveBand(fno, name);
        } else if (submit.equals("添加专辑")) {
            dao.addLoveAlbum(fno, name);
        } else if (submit.equals("删除专辑")) {
            dao.deleteLoveAlbum(fno, name);
        } else if (submit.equals("添加歌曲")) {
            dao.addLoveSong(fno, name);
        } else if (submit.equals("删除歌曲")) {
            dao.deleteLoveSong(fno, name);
        } else if (submit.equals("添加演唱会")) {
            dao.addLoveConcert(fno, name);
        } else if (submit.equals("删除演唱会")) {
            dao.deleteLoveConcert(fno, name);
        }
        fan = fanService.getInfo(fno);
        req.setAttribute("fno", fan.getFno());
        req.setAttribute("fname", fan.getFname());
        req.setAttribute("fsex", fan.getFsex());
        req.setAttribute("fage", fan.getFage());
        req.setAttribute("fjob", fan.getFjob());
        List<Band> loveBand = fanService.getLoveBand(fan.getFno());
        List<Album> loveAlbum = fanService.getLoveAlbum(fan.getFno());
        List<Song> loveSong = fanService.getLoveSong(fan.getFno());
        List<Concert> concert = fanService.getConcert(fan.getFno());
        req.setAttribute("loveband", loveBand);
        req.setAttribute("lovealbum", loveAlbum);
        req.setAttribute("lovesong", loveSong);
        req.setAttribute("concert", concert);
        req.getRequestDispatcher("pages/fanlog_sucess_menu.jsp").forward(req, resp);
    }
}
