package com.lhit.starter.alioss.imagedeal.rule;

import com.lhit.starter.alioss.imagedeal.param.AliossImageEffectBlur;

public class AliossImageEffectRule implements AliossImageRule{


    /**
     * 图片处理支持对图片进行模糊操作。
     * r	模糊半径	[1,50]r 越大图片越模糊。
     * s	正态分布的标准差	[1,50]s 越大图片越模糊。
     */
    private AliossImageEffectBlur aliossImageEffectBlur;


    /**
     * 亮度调整。0 表示原图亮度，小于 0 表示低于原图亮度，大于 0 表示高于原图亮度。
     * [-100, 100]
     */
    private Integer bright;


    /**
     * 对比度调整。0 表示原图对比度，小于 0 表示低于原图对比度，大于 0 表示高于原图对比度。
     * [-100, 100]
     */
    private Integer contrast;


    /**
     * 表示进行锐化处理。取值为锐化参数，参数越大，越清晰。
     *
     * [50, 399] 为达到较优效果，推荐取值为 100。
     */
    private Integer sharpen;


    public String buildParam() {
        String result = "";
        if (aliossImageEffectBlur != null){
            result += "blur,"+aliossImageEffectBlur.buildParam();
        }
        if (bright != null){
            result += "bright,"+bright;
        }
        if (contrast != null){
            result += "contrast,"+contrast;
        }
        if (sharpen != null){
            result += "sharpen,"+sharpen;
        }
        return null;
    }

    public Integer getOrder() {
        return 99;
    }
}
