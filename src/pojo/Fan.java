package pojo;

public class Fan {
    private int fno;
    private String fname;
    private String fsex;
    private int fage;
    private String fjob;
    private String username;
    private String password;
    private String lovealbumname;
    private String lovesongname;
    private String loveconcertname;

    public String getLovesongname() {
        return lovesongname;
    }

    public void setLovesongname(String lovesongname) {
        this.lovesongname = lovesongname;
    }

    public String getLoveconcertname() {
        return loveconcertname;
    }

    public void setLoveconcertname(String loveconcertname) {
        this.loveconcertname = loveconcertname;
    }

    public String getLovealbumname() {
        return lovealbumname;
    }

    public void setLovealbumname(String lovealbumname) {
        this.lovealbumname = lovealbumname;
    }

    public Fan() {
    }

    public Fan(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFsex() {
        return fsex;
    }

    public void setFsex(String fsex) {
        this.fsex = fsex;
    }

    public int getFage() {
        return fage;
    }

    public void setFage(int fage) {
        this.fage = fage;
    }

    public String getFjob() {
        return fjob;
    }

    public void setFjob(String fjob) {
        this.fjob = fjob;
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
