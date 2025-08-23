<%@ page import="java.util.List" %>
<%@ page import="dao.impl.DaoImpl" %>
<%@ page import="pojo.*" %><%--
  Created by IntelliJ IDEA.
  User: troye
  Date: 2023/1/6
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/MusicManage/static/css/style.css"/>
</head>
<body>
<%
    int fno = (int) request.getAttribute("fno");
    String fname = (String) request.getAttribute("fname");
    String fsex = (String) request.getAttribute("fsex");
    int fage = (int) request.getAttribute("fage");
    String fjob = (String) request.getAttribute("fjob");
    List<Band> loveBand = (List<Band>) request.getAttribute("loveband");
    List<Album> loveAlbum = (List<Album>) request.getAttribute("lovealbum");
    List<Song> loveSong = (List<Song>) request.getAttribute("lovesong");
    List<Concert> concerts = (List<Concert>) request.getAttribute("concert");
    DaoImpl dao = new DaoImpl();
    List<Band> otherBand = dao.queryOtherBand(fno);
    List<Album> otherAlbum = dao.queryOtherAlbum(fno);
    List<Song> otherSong = dao.queryOtherSong(fno);
    List<Concert> otherconcert = dao.queryOtherConcert(fno);
%>


<h1>乐迷信息</h1>
<table>
    <tr>
        <td>
            <table width="300" height="100">
                <tr><%="<h3>fno：" + fno + "</h3>"%>
                </tr>
                <tr><%="<h3>名字：" + fname + "</h3>"%>
                </tr>
                <tr><%="<h3>性别：" + fsex + "</h3>"%>
                </tr>
                <tr><%="<h3>年龄：" + fage + "</h3>"%>
                </tr>
                <tr><%="<h3>工作：" + fjob + "</h3>"%>
                </tr>
            </table>
        </td>
        <td>
            <form action="http://localhost:8080/MusicManage/updatefaninfo">
                <table width="300" height="100">
                    <tr>
                        <td><%="<h3>fno：" + fno + "</h3>"%><input type="hidden" name="fno" value="<%=fno%>">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="fname" value="<%=fname%>"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="fsex" value="<%=fsex%>"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="fage" value="<%=fage%>"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="fjob" value="<%=fjob%>"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="修改"/></td>
                    </tr>
                </table>
            </form>
        <td>
    </tr>
</table>
<h1>我喜欢的</h1>
<h4>乐队</h4>
<form action="/MusicManage/adddeleteservlet">
    <input type="hidden" name="fno" value="<%=fno%>">
    <table width="300" height="100">
        <tr>
            <td><h3>添加/删除的乐队名称</h3></td>
        </tr>
        <tr>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="添加乐队" />  <input type="submit" name="submit" value="删除乐队" /></td>
        </tr>
    </table>
</form>
<table style="color: white;font-size:16px" width="900" height="100">
    <% if (loveBand != null) {
        for (Band band : loveBand) {%>
    <tr>
        <td>乐队编号：<%=band.getBno()%>
        </td>
        <td>乐队名：<%=band.getBname()%>
        </td>
        <td>成立时间：<%=band.getEstime()%>
        </td>
        <td>人数：<%=band.getBmenum()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<h4>专辑</h4>
<form action="/MusicManage/adddeleteservlet">
    <input type="hidden" name="fno" value="<%=fno%>">
    <table width="300" height="100">
        <tr>
            <td><h3>添加/删除的专辑名称</h3></td>
        </tr>
        <tr>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="添加专辑" />  <input type="submit" name="submit" value="删除专辑" /></td>
        </tr>
    </table>
</form>
<table style="color: white;font-size:16px" width="900" height="100">
    <% if (loveAlbum != null) {
        for (Album album : loveAlbum) {%>
    <tr>
        <td>专辑编号：<%=album.getAbno()%>
        </td>
        <td>专辑名：<%=album.getAname()%>
        </td>
        <td>发行时间：<%=album.getAestime()%>
        </td>
        <td>乐队编号：<%=album.getAbno()%>
        </td>
        <td>发行公司：<%=album.getAbno()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<h4>歌曲</h4>
<form action="/MusicManage/adddeleteservlet">
    <input type="hidden" name="fno" value="<%=fno%>">
    <table width="300" height="100">
        <tr>
            <td><h3>添加/删除的歌曲名称</h3></td>
        </tr>
        <tr>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="添加歌曲" />  <input type="submit" name="submit" value="删除歌曲" /></td>
        </tr>
    </table>
</form>
<table style="color: white;font-size:16px" width="900" height="100">
    <%
        if (loveSong != null) {
            for (Song song : loveSong) {
    %>
    <tr>
        <td>歌曲编号：<%=song.getSno()%>
        </td>
        <td>歌曲名：<%=song.getSname()%>
        </td>
        <td>创作者：<%=song.getSwriter()%>
        </td>
        <td>所在专辑编号：<%=song.getSano()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<h4>参加的演唱会</h4>
<form action="/MusicManage/adddeleteservlet">
    <input type="hidden" name="fno" value="<%=fno%>">
    <table width="300" height="100">
        <tr>
            <td><h3>添加/删除的演唱会名称</h3></td>
        </tr>
        <tr>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="添加演唱会" />  <input type="submit" name="submit" value="删除演唱会" /></td>
        </tr>
    </table>
</form>
<table style="color: white;font-size:16px" width="900" height="100">
    <%
        if (concerts != null) {
            for (Concert concert : concerts) {
    %>
    }
    <tr>
        <td>演唱会编号：<%=concert.getCno()%>
        </td>
        <td>演唱会名称：<%=concert.getCname()%>
        </td>
        <td>开始时间：<%=concert.getCstartime()%>
        </td>
        <td>结束时间：<%=concert.getCendtime()%>
        </td>
        <td>举办地点：<%=concert.getClocal()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<h1>发现</h1>
<a target="_blank" href="pages/search.jsp" style="font-size: 25px">查询界面</a>
<h4>未关注的乐队</h4>
<table style="color: white;font-size:16px" width="900" height="100">
    <%
        if (otherBand != null) {
            for (Band band : otherBand) {
    %>
    <tr>
        <td>乐队编号：<%=band.getBno()%>
        </td>
        <td>乐队名：<%=band.getBname()%>
        </td>
        <td>成立时间：<%=band.getEstime()%>
        </td>
        <td>人数：<%=band.getBmenum()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<h4>专辑</h4>
<table style="color: white;font-size:16px" width="900" height="100">
    <%
        if (otherAlbum != null) {
            for (Album album : otherAlbum) {
    %>
    <tr>
        <td>专辑编号：<%=album.getAbno()%>
        </td>
        <td>专辑名：<%=album.getAname()%>
        </td>
        <td>发行时间：<%=album.getAestime()%>
        </td>
        <td>乐队编号：<%=album.getAbno()%>
        </td>
        <td>发行公司：<%=album.getAbno()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<h4>歌曲</h4>
<table style="color: white;font-size:16px" width="900" height="100">
    <%
        if (otherSong != null) {
            for (Song song : otherSong) {
    %>
    <tr>
        <td>歌曲编号：<%=song.getSno()%>
        </td>
        <td>歌曲名：<%=song.getSname()%>
        </td>
        <td>创作者：<%=song.getSwriter()%>
        </td>
        <td>所在专辑编号：<%=song.getSano()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<h4>演唱会</h4>
<table style="color: white;font-size:16px" width="900" height="100">
    <% if (otherconcert != null) {
        for (Concert concert : otherconcert) {%>
    <tr>
        <td>演唱会编号：<%=concert.getCno()%>
        </td>
        <td>演唱会名称：<%=concert.getCname()%>
        </td>
        <td>开始时间：<%=concert.getCstartime()%>
        </td>
        <td>结束时间：<%=concert.getCendtime()%>
        </td>
        <td>举办地点：<%=concert.getClocal()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
