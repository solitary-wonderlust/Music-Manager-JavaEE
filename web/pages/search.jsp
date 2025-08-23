<%@ page import="pojo.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: troye
  Date: 2023/1/9
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Band> bands = (List<Band>) request.getAttribute("band");
    List<Album> albums = (List<Album>) request.getAttribute("album");
    List<Song> songs = (List<Song>) request.getAttribute("song");
    List<Concert> concerts = (List<Concert>) request.getAttribute("concert");
%>
<form action="/MusicManage/searchservlet">
    <table width="300" height="100">
        <tr>
            <td>搜索的乐队/专辑/歌曲/演唱会名称</td>
        </tr>
        <tr>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="搜索" /></td>
        </tr>
    </table>
</form>
<h4>乐队</h4>
<table style="color: black;font-size:16px" width="900" height="100">
    <%
        if (bands != null) {
            for (Band band : bands) {
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
<table style="color: black;font-size:16px" width="900" height="100">
    <%
        if (albums != null) {
            for (Album album : albums) {
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
<table style="color: black;font-size:16px" width="900" height="100">
    <%
        if (songs != null) {
            for (Song song : songs) {
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
<table style="color: black;font-size:16px" width="900" height="100">
    <% if (concerts != null) {
        for (Concert concert : concerts) {%>
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
