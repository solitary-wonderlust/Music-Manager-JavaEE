package web;
import pojo.*;
import service.FanService;
import service.impl.FanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
//完成乐队用户登录操作，从登录界面跳转到乐队界面，并把一些信息传给页面
public class FanLogServlet extends HttpServlet{
    private FanService fanService=new FanServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Fan fan=new Fan(username,password);
        fan=fanService.login(fan);
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html; charset=UTF-8");
        if(fan==null){
            PrintWriter writer = resp.getWriter();
            writer.write("<a href='pages/fanlogin.html'>用户名或密码错误，点击返回</a>");
        }
        else{
            fan=fanService.getInfo(fan.getFno());
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
}
