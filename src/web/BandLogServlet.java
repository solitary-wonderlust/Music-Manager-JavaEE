package web;
import pojo.Band;
import service.BandService;
import service.impl.BandServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//完成乐队用户登录操作，从登录界面跳转到乐队界面，并把查询到该乐队信息封装成一个Band实例通过request域传给页面
public class BandLogServlet extends HttpServlet{
    private BandService bandService=new BandServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Band band=new Band(username,password);
        band=bandService.login(band);
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html; charset=UTF-8");
        if(band==null){
            PrintWriter writer = resp.getWriter();
            writer.write("<a href='pages/bandlogin.html'>用户名或密码错误，点击返回</a>");
        }
        else{
            band=bandService.getInfo(band.getBno());
            req.setAttribute("band",band);
            req.getRequestDispatcher("pages/bandlog_sucess_menu.jsp").forward(req,resp);
        }
    }
}
