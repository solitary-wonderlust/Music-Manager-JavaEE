package web;

import dao.impl.DaoImpl;
import pojo.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//完成搜索页面下通过名称模糊查询乐队、专辑、歌曲、演唱会
public class SearchServlet extends HttpServlet {
    private DaoImpl dao = new DaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        List<Band> bands=dao.searchBand(name);
        List<Album> albums=dao.searchAlbum(name);
        List<Song> songs=dao.searchSong(name);
        List<Concert> concerts=dao.searchConcert(name);
        req.setAttribute("band",bands);
        req.setAttribute("album",albums);
        req.setAttribute("song",songs);
        req.setAttribute("concert",concerts);
        req.getRequestDispatcher("pages/search.jsp").forward(req,resp);
    }
}
