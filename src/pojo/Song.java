package pojo;

public class Song {
    private int sno;
    private String sname;
    private String swriter;
    private int sano;
    private String aname;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Song() {
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSwriter() {
        return swriter;
    }

    public void setSwriter(String swriter) {
        this.swriter = swriter;
    }

    public int getSano() {
        return sano;
    }

    public void setSano(int sano) {
        this.sano = sano;
    }
}
