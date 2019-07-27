package com.lhit.starter.alioss.imagedeal.enum_;

public enum AliossImageType {


    jpg("jpg","jpg 格式"),
    png("png","png 格式"),
    webp("webp","webp 格式"),
    bmp("bmp","bmp 格式"),
    gif("gif","gif 格式"),
    tiff("tiff","tiff 格式");

    private String type;

    private String desc;

    AliossImageType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
