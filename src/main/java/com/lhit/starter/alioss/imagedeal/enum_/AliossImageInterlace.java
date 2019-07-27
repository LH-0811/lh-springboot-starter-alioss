package com.lhit.starter.alioss.imagedeal.enum_;

public enum  AliossImageInterlace {
    Normal(0,"0 表示保存成普通的 jpg 格式。"),
    Interlace(1,"1 表示保存成渐进显示的 jpg 格式。");


    private Integer interlace;

    private String desc;


    AliossImageInterlace(Integer interlace, String desc) {
        this.interlace = interlace;
        this.desc = desc;
    }

    public Integer getInterlace() {
        return interlace;
    }

    public void setInterlace(Integer interlace) {
        this.interlace = interlace;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
