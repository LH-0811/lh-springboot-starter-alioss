package com.lhit.starter.alioss.imagedeal.param;

public class AliossImageEffectBlur {


    /**
     * 模糊半径
     *[1,50]r 越大图片越模糊。
     */
    private Integer r;

    /**
     * 正态分布的标准差
     *
     * [1,50]s 越大图片越模糊
     */
    private Integer s;


    public AliossImageEffectBlur withR(Integer r){
        this.r = r;
        return this;
    }
    public AliossImageEffectBlur withS(Integer s){
        this.s = s;
        return this;
    }

    public AliossImageEffectBlur build(){
        return this;
    }

    public String buildParam(){
        String result = "";
        if (r!=null){
            result += "r_"+r;
        }
        if (s!=null){
            result += "s_"+s;
        }
        return result;
    }

}
