package com.lhit.starter.alioss.imagedeal.enum_;

public enum  AliossImageResizeModel {

    lift("lift","等比缩放，限制在指定w与h的矩形内的最大图片"),
    mfit("mfit","等比缩放，延伸出指定w与h的矩形框外的最小图片"),
    fill("fill","固定宽高，将延伸出指定w与h的矩形框外的最小图片进行居中裁剪"),
    pad("pad","固定宽高，缩略填充"),
    fixed("fixed","固定宽高，强制缩略")
    ;

    private String model;

    private String desc;


    AliossImageResizeModel(String model, String desc) {
        this.model = model;
        this.desc = desc;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
