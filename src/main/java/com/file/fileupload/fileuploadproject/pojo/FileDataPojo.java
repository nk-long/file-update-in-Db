package com.file.fileupload.fileuploadproject.pojo;

import java.util.Arrays;

public class FileDataPojo {
    private int imgid;
    private String imgname;
    private String imgtype;
    private byte[] imgdata;

    public FileDataPojo()
    {

    }

    public FileDataPojo(int imgid, String imgname, String imgtype, byte[] imgdata) {
        this.imgid = imgid;
        this.imgname = imgname;
        this.imgtype = imgtype;
        this.imgdata = imgdata;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getImgtype() {
        return imgtype;
    }

    public void setImgtype(String imgtype) {
        this.imgtype = imgtype;
    }

    public byte[] getImgdata() {
        return imgdata;
    }

    public void setImgdata(byte[] imgdata) {
        this.imgdata = imgdata;
    }

    @Override
    public String toString() {
        return "FileDataPojo [imgdata=" + Arrays.toString(imgdata) + ", imgid=" + imgid + ", imgname=" + imgname
                + ", imgtype=" + imgtype + "]";
    }

    

    
}
