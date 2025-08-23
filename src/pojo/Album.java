package pojo;

import java.sql.Date;

public class Album {
    private int ano;
    private String aname;
    private Date aestime;
    private int abno;
    private String acom;

    public Album() {
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Date getAestime() {
        return aestime;
    }

    public void setAestime(Date aestime) {
        this.aestime = aestime;
    }

    public int getAbno() {
        return abno;
    }

    public void setAbno(int abno) {
        this.abno = abno;
    }

    public String getAcom() {
        return acom;
    }

    public void setAcom(String acom) {
        this.acom = acom;
    }
}
