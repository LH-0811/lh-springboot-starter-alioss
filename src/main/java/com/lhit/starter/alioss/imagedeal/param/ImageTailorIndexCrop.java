package com.lhit.starter.alioss.imagedeal.param;

import com.lhit.starter.alioss.imagedeal.enum_.AliossImageGrid;

public class ImageTailorIndexCrop {


    /**
     * 进行水平切割，每块图片的长度。x 参数与 y 参数只能任选其一。
     * [1,图片宽度]
     */
    private Integer x;

    /**
     * 进行垂直切割，每块图片的长度。x 参数与 y 参数只能任选其一。
     * [1,图片高度]
     */
    private Integer y;

    /**
     * 选择切割后第几个块。（0表示第一块）
     * [0,最大块数)。如果超出最大块数，返回原图。
     */
    private Integer i;


    public ImageTailorIndexCrop withX(Integer x) {
        this.x = x;
        return this;
    }

    public ImageTailorIndexCrop withY(Integer y) {
        this.y = y;
        return this;
    }

    public ImageTailorIndexCrop withI(Integer i) {
        this.i = i;
        return this;
    }

    public ImageTailorIndexCrop build(){
        return this;
    }

    public String buildParam() {
        String result = "";
        if (x != null) {
            result += "x_" + x;
        }
        if (y != null) {
            result += "y_" + y;
        }
        if (i != null) {
            result += "i_" + i;
        }
        return result;
    }


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
