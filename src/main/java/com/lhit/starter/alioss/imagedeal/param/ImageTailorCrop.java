package com.lhit.starter.alioss.imagedeal.param;

import com.lhit.starter.alioss.imagedeal.enum_.AliossImageGrid;

public class ImageTailorCrop {

    /**
     * 指定裁剪宽度
     * [0-图片边界]
     */
    private Integer w;

    /**
     * 指定裁剪高度
     * [0-图片边界]
     */
    private Integer h;

    /**
     * 指定裁剪起点横坐标（默认左上角为原点）
     * [0-图片边界]
     */
    private Integer x;

    /**
     * 指定裁剪起点纵坐标（默认左上角为原点）
     * [0-图片边界]
     */
    private Integer y;

    /**
     * 设置裁剪的原点位置，由九宫格的格式，一共有九个地方可以设置，每个位置位于每个九宫格的左上角
     * [nw, north, ne, west, center, east, sw, south, se]
     */
    private AliossImageGrid grid;


    public ImageTailorCrop withW(Integer w){
        this.w = w;
        return this;
    }

    public ImageTailorCrop withH(Integer H){
        this.h = h;
        return this;
    }

    public ImageTailorCrop withX(Integer x){
        this.x = x;
        return this;
    }
    public ImageTailorCrop withY(Integer y){
        this.y = y;
        return this;
    }
    public ImageTailorCrop withG(AliossImageGrid grid){
        this.grid = grid;
        return this;
    }

    public ImageTailorCrop build(){
        return this;
    }

    public String buildParam(){
        String result = "";
        if (w!=null){
            result += "w_"+w;
        }
        if (h!=null){
            result += "h_"+h;
        }
        if (x!= null){
            result += "x_"+x;
        }
        if (y!=null){
            result += "y_"+y;
        }
        if (grid!= null){
            result += "g_"+grid.getGrid();
        }
        return result;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
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

    public AliossImageGrid getGrid() {
        return grid;
    }

    public void setGrid(AliossImageGrid grid) {
        this.grid = grid;
    }
}
