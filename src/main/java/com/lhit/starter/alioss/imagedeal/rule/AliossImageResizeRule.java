package com.lhit.starter.alioss.imagedeal.rule;


import com.lhit.starter.alioss.imagedeal.enum_.AliossImageResizeModel;

public class AliossImageResizeRule implements AliossImageRule {


    /**
     * 指定缩略的模式：
     * lfit：等比缩放，限制在指定w与h的矩形内的最大图片。
     * mfit：等比缩放，延伸出指定w与h的矩形框外的最小图片。
     * fill：固定宽高，将延伸出指定w与h的矩形框外的最小图片进行居中裁剪。
     * pad：固定宽高，缩略填充。
     * fixed：固定宽高，强制缩略。
     *
     * 取值：
     * lfit、mfit、fill、pad、fixed，默认为 lfit。
     */
    private AliossImageResizeModel m;

    /**
     * 	指定目标缩略图的宽度。
     *
     * 	取值范围
     * 	1-4096
     */
    private Integer w;

    /**
     * 指定目标缩略图的高度。
     *
     * 取值范围
     * 1-4096
     */
    private Integer h;

    /**
     * 指定目标缩略图的最长边。
     *
     * 取值范围
     * 1-4096
     */
    private Integer l;

    /**
     * 指定目标缩略图的最短边。
     *
     * 取值范围
     * 1-4096
     */
    private Integer s;


    /**
     * 倍数百分比。 小于 100，即是缩小，大于 100 即是放大。
     *
     * 1-1000
     */
    private Integer p;

    /**
     * 指定当目标缩略图大于原图时是否处理。值是 1 表示不处理；值是 0 表示处理。
     *
     * 0/1, 默认是 1
     */
    private Boolean limit;


    /**
     * 当缩放模式选择为 pad（缩略填充）时，可以选择填充的颜色(默认是白色)参数的填写方式：采用 16 进制颜色码表示，如 00FF00（绿色）。
     *
     * [000000-FFFFFF]
     */
    private String color;


    public AliossImageResizeRule withM(AliossImageResizeModel m) {
        this.m = m;
        return this;
    }

    public AliossImageResizeRule withH(Integer h) {
        this.h = h;
        return this;
    }
    public AliossImageResizeRule withW(Integer w) {
        this.w = w;
        return this;
    }

    public AliossImageResizeRule withL(Integer l) {
        this.l = l;
        return this;
    }

    public AliossImageResizeRule withS(Integer s) {
        this.s = s;
        return this;
    }

    public AliossImageResizeRule withLimit(Boolean limit) {
        this.limit = limit;
        return this;
    }

    public AliossImageResizeRule withColor(String color) {
        this.color = color;
        return this;
    }

    public AliossImageResizeRule withP(Integer p) {
        this.p = p;
        return this;
    }

    public AliossImageResizeRule build() {
        return this;
    }

    public String buildParam(){
        String result = "resize";
        if (m != null){
            result+=",m_"+m.getModel();
        }
        if (w != null){
            result+=",w_"+w;
        }
        if (h != null){
            result+=",h_"+h;
        }
        if (l != null){
            result+=",l_"+l;
        }
        if (s != null){
            result+=",s_"+s;
        }
        if (p != null){
            result+=",p_"+p;
        }
        if (limit != null){
            result+=",limit_" + (limit == true ?1:0);
        }
        if (color != null){
            result+=",color_" + color;
        }

        return result;
    }

    public Integer getOrder() {
        return 1;
    }

}
