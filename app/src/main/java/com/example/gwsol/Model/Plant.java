package com.example.gwsol.Model;

public class Plant {
    private int id;
    private String header;
    private String desc;
    private int imgname;
    private boolean ismine;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImgname() {
        return imgname;
    }

    public void setImgname(int imgname) {
        this.imgname = imgname;
    }
    public boolean getIsMine(){return ismine;}
    public void setIsMine(boolean ismine) {this.ismine = ismine;}
}
