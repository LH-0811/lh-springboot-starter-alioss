package com.lhit.starter.alioss.imagedeal.rule;


import com.lhit.starter.alioss.imagedeal.enum_.AliossImageResizeModel;

public class AliossImageResizeRule implements AliossImageRule {


    private AliossImageResizeModel m;

    private Integer w;

    private Integer h;

    private Integer l;

    private Integer s;

    private Integer p;

    private Boolean limit;

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
