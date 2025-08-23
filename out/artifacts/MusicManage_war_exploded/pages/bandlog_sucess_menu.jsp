<%@ page import="pojo.*" %>
<%@ page import="dao.impl.DaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: troye
  Date: 2023/1/6
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css"/>
</head>
<body>
<%
    Band band= (Band) request.getAttribute("band");
    DaoImpl dao=new DaoImpl();
    List<Member> member=dao.queryBandMember(band.getBno());
    List<Album> albums=dao.queryBandAlbum(band.getBno());
    List<Song> songs=dao.queryBandSong(band.getBno());
    List<Concert> concerts=dao.queryBandConcert(band.getBno());
    List<Fan> bandfans=dao.queryBandFan(band.getBno());
    List<Fan> albumfans=dao.queryAlbumFan(band.getBno());
    List<Fan> songfans=dao.querySongFan(band.getBno());
    List<Fan> concertfans=dao.queryConcertFan(band.getBno());

%>
    <h1>乐队相关信息</h1>
    <h4>乐队信息</h4>
    <table>
    <tr>
        <td width="300" height="100">
            <table width="300" height="100">
                <tr><%="<h3>bno：" + band.getBno() + "</h3>"%>
                </tr>
                <tr><%="<h3>乐队名：" + band.getBname() + "</h3>"%>
                </tr>
                <tr><%="<h3>成立时间：" + band.getEstime() + "</h3>"%>
                </tr>
                <tr><%="<h3>人数：" + band.getBmenum() + "</h3>"%>
                </tr>
            </table>
        </td>
        <td width="300" height="100">
            <form action="http://localhost:8080/MusicManage/bandservlet">
                <table width="300" height="100">
                    <tr>
                        <td><%="<h3>bno：" + band.getBno() + "</h3>"%><input type="hidden" name="bno" value="<%=band.getBno()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="bname" value="<%=band.getBname()%>"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="estime" value="<%=band.getEstime()%>"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="bmenum" value="<%=band.getBmenum()%>"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="submit" value="修改乐队信息"/></td>
                    </tr>
                </table>
            </form>
        <td>
    </tr>
    </table>
    <h4>成员信息</h4>
    <table style="color: black;font-size:16px" width="900" height="100">
        <% if (member != null) {
            for (Member m : member) {%>
        <tr>
            <td>乐队分工：<%=m.getDivision()%>
            </td>
            <td>姓名：<%=m.getMname()%>
            </td>
            <td>性别：<%=m.getMsex()%>
            </td>
            <td>年龄：<%=m.getMage()%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <form action="/MusicManage/bandservlet">
        <input type="hidden" name="bno" value="<%=band.getBno()%>">
        <table width="300" height="100">
            <tr>
                <td>乐队分工<input type="text" name="division"/></td>
            </tr>
            <tr>
                <td>成员姓名<input type="text" name="name"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="删除成员" /></td>
            </tr>
        </table>
    </form>
    <form action="/MusicManage/bandservlet">
        <input type="hidden" name="bno" value="<%=band.getBno()%>">
        <table width="300" height="100">
            <tr>
                <td>乐队分工<input type="text" name="division"/></td>
            </tr>
            <tr>
                <td>成员姓名<input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>成员性别<input type="text" name="sex"/></td>
            </tr>
            <tr>
                <td>成员年龄<input type="text" name="age"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="添加成员" /></td>
            </tr>
        </table>
    </form>
    <h4>专辑信息</h4>
    <table style="color: black;font-size:16px" width="900" height="100">
        <% if (albums != null) {
            for (Album album : albums) {%>
        <tr>
            <td>专辑名称：<%=album.getAname()%>
            </td>
            <td>发行时间：<%=album.getAestime()%>
            </td>
            <td>发行公司：<%=album.getAcom()%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <form action="/MusicManage/bandservlet">
        <input type="hidden" name="bno" value="<%=band.getBno()%>">
        <table width="300" height="100">
            <tr>
                <td>专辑名<input type="text" name="aname"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="删除专辑" /></td>
            </tr>
        </table>
    </form>
    <form action="/MusicManage/bandservlet">
        <input type="hidden" name="bno" value="<%=band.getBno()%>">
        <table width="300" height="100">
            <tr>
                <td>专辑名<input type="text" name="aname"/></td>
            </tr>
            <tr>
                <td>发行公司<input type="text" name="acom"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="添加专辑" /></td>
            </tr>
        </table>
    </form>
    <h4>歌曲信息</h4>
    <table style="color: black;font-size:16px" width="900" height="100">
        <% if (songs != null) {
            for (Song song : songs) {%>
        <tr>
            <td>歌曲名称：<%=song.getSname()%>
            </td>
            <td>创作者姓名：<%=song.getSwriter()%>
            </td>
            <td>所在专辑：<%=song.getAname()%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <form action="/MusicManage/bandservlet">
        <input type="hidden" name="bno" value="<%=band.getBno()%>">
        <table width="300" height="100">
            <tr>
                <td>歌曲名<input type="text" name="sname"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="删除歌曲" /></td>
            </tr>
        </table>
    </form>
    <form action="/MusicManage/bandservlet">
        <input type="hidden" name="bno" value="<%=band.getBno()%>">
        <table width="300" height="100">
            <tr>
                <td>歌曲名<input type="text" name="sname"/></td>
            </tr>
            <tr>
                <td>创作者<input type="text" name="swriter"/></td>
            </tr>
            <tr>
                <td>所在专辑名<input type="text" name="aname"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="添加歌曲" /></td>
            </tr>
        </table>
    </form>
    <h4>演唱会信息</h4>
    <table style="color: black;font-size:16px" width="900" height="100">
        <% if (concerts != null) {
            for (Concert concert : concerts) {%>
        <tr>
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
    <form action="/MusicManage/bandservlet">
        <input type="hidden" name="bno" value="<%=band.getBno()%>">
        <table width="300" height="100">
            <tr>
                <td>演唱会名<input type="text" name="cname"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="删除演唱会" /></td>
            </tr>
        </table>
    </form>
    <form action="/MusicManage/bandservlet">
        <input type="hidden" name="bno" value="<%=band.getBno()%>">
        <table width="300" height="100">
            <tr>
                <td>演唱会名<input type="text" name="cname"/></td>
            </tr>
            <tr>
                <td>开始时间<input type="text" name="cstartime"/></td>
            </tr>
            <tr>
                <td>结束时间<input type="text" name="cendtime"/></td>
            </tr>
            <tr>
                <td>地点<input type="text" name="clocal"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="添加演唱会" /></td>
            </tr>
        </table>
    </form>
    <h1>歌迷</h1>
    <h4>乐队歌迷</h4>
    <table style="color: black;font-size:16px" width="900" height="100">
        <% if (bandfans != null) {
            for (Fan fan : bandfans) {%>
        <tr>
            <td>姓名：<%=fan.getFname()%>
            </td>
            <td>性别：<%=fan.getFsex()%>
            </td>
            <td>年龄：<%=fan.getFage()%>
            </td>
            <td>工作：<%=fan.getFjob()%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <h4>喜欢本乐队专辑的歌迷</h4>
    <table style="color: black;font-size:16px" width="900" height="100">
        <% if (albumfans != null) {
            for (Fan fan : albumfans) {%>
        <tr>
            <td>喜欢的专辑名：<%=fan.getLovealbumname()%>
            </td>
            <td>姓名：<%=fan.getFname()%>
            </td>
            <td>性别：<%=fan.getFsex()%>
            </td>
            <td>年龄：<%=fan.getFage()%>
            </td>
            <td>工作：<%=fan.getFjob()%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <h4>喜欢本乐队歌曲的歌迷</h4>
    <% if (songfans != null) {
        for (Fan fan : songfans) {%>
    <tr>
        <td>喜欢的歌曲名：<%=fan.getLovesongname()%>
        </td>
        <td>姓名：<%=fan.getFname()%>
        </td>
        <td>性别：<%=fan.getFsex()%>
        </td>
        <td>年龄：<%=fan.getFage()%>
        </td>
        <td>工作：<%=fan.getFjob()%>
        </td>
    </tr>
    <%
            }
        }
    %>
    <h4>参加本乐队演唱会的歌迷</h4>
    <% if (concertfans != null) {
        for (Fan fan : concertfans) {%>
    <tr>
        <td>参加的演唱会：<%=fan.getLoveconcertname()%>
        </td>
        <td>姓名：<%=fan.getFname()%>
        </td>
        <td>性别：<%=fan.getFsex()%>
        </td>
        <td>年龄：<%=fan.getFage()%>
        </td>
        <td>工作：<%=fan.getFjob()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</body>
</html>
