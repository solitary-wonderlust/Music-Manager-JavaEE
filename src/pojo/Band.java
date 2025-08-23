package pojo;

import java.sql.Date;

public class Band {
    private int bno;
    private String bname;
    private Date estime;
    private Date distime;
    private int bleano;
    private int bmenum;
    private String username;
    private String password;

    public Band() {
    }

    @Override
    public String toString() {
        return "Band{" +
                "bno=" + bno +
                ", bname='" + bname + '\'' +
                ", estime=" + estime +
                ", distime=" + distime +
                ", bleano=" + bleano +
                ", bmenum=" + bmenum +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Band(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Band(int bno, String username, String password) {
        this.bno = bno;
        this.username = username;
        this.password = password;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Date getEstime() {
        return estime;
    }

    public void setEstime(Date estime) {
        this.estime = estime;
    }

    public Date getDistime() {
        return distime;
    }

    public void setDistime(Date distime) {
        this.distime = distime;
    }

    public int getBleano() {
        return bleano;
    }

    public void setBleano(int bleano) {
        this.bleano = bleano;
    }

    public int getBmenum() {
        return bmenum;
    }

    public void setBmenum(int bmenum) {
        this.bmenum = bmenum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
