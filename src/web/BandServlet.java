package web;

import dao.impl.DaoImpl;
import pojo.Band;
import service.BandService;
import service.impl.BandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//完成乐队界面下修改乐队基本信息操作，添加和删除乐队成员、专辑、歌曲、演唱会操作
public class BandServlet extends HttpServlet {
    private DaoImpl dao = new DaoImpl();
    private BandService bandService=new BandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bno = Integer.parseInt(req.getParameter("bno"));
        String submit = req.getParameter("submit");
        if (submit.equals("删除成员")) {
            String division = req.getParameter("division");
            String name = req.getParameter("name");
            dao.deleteBandMember(bno, division, name);
        } else if (submit.equals("添加成员")) {
            String division = req.getParameter("division");
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String sex = req.getParameter("sex");
            dao.addBandMember(bno, division, name, age, sex);
        }else if (submit.equals("修改乐队信息")) {
            String bname = req.getParameter("bname");
            String estime = req.getParameter("estime");
            int bmenum = Integer.parseInt(req.getParameter("bmenum"));
            dao.updateBand(bno,bname,estime,bmenum);
        }else if (submit.equals("删除专辑")) {
            String aname = req.getParameter("aname");
            dao.deleteBandAlbum(bno,aname);
        }else if (submit.equals("添加专辑")) {
            String aname = req.getParameter("aname");
            String acom = req.getParameter("acom");
            dao.addBandAlbum(bno,aname,acom);
        }else if (submit.equals("删除歌曲")) {
            String sname = req.getParameter("sname");
            dao.deleteBandSong(bno,sname);
        }else if (submit.equals("添加歌曲")) {
            String sname = req.getParameter("sname");
            String swriter = req.getParameter("swriter");
            String aname = req.getParameter("aname");
            dao.addBandSong(bno,sname,swriter,aname);
        }else if (submit.equals("删除演唱会")) {
            String cname = req.getParameter("cname");
            dao.deleteBandConcert(bno,cname);
        }else if (submit.equals("添加演唱会")) {
            String cname = req.getParameter("cname");
            String cstartime = req.getParameter("cstartime");
            String cendtime = req.getParameter("cendtime");
            String clocal = req.getParameter("clocal");
            dao.addBandConcert(bno,cname,cstartime,cendtime,clocal);
        }

        Band band =bandService.getInfo(bno);
        req.setAttribute("band",band);
        req.getRequestDispatcher("pages/bandlog_sucess_menu.jsp").forward(req,resp);
    }
}
