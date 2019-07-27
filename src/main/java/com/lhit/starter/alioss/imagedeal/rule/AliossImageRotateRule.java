package com.lhit.starter.alioss.imagedeal.rule;

public class AliossImageRotateRule implements AliossImageRule {


    /**
     * 进行自动旋转
     *
     * 0：表示按原图默认方向，不进行自动旋转。
     *
     * 1：先进行图片旋转，然后再进行缩略。
     *
     * 0 和 1，默认是 1
     */
    private Boolean autoRrient;


    /**
     * 图片按顺时针旋转的角度
     * [0, 360]默认值为 0，表示不旋转。
     */
    private Integer rotate;

    public AliossImageRotateRule withAutoRrient(Boolean autoRrient){
        this.autoRrient = autoRrient;
        return this;
    }
    public AliossImageRotateRule withRotate(Integer rotate){
        this.rotate = rotate;
        return this;
    }
    public AliossImageRotateRule build(){
        return this;
    }



    public String buildParam() {

        String result = "";
        if (this.autoRrient != null){
            result = "auto-orient,"+(this.autoRrient==true?1:0);
        }
        if (this.rotate != null){
            result = "rotate,"+rotate;
        }
        return result;
    }

    public Integer getOrder() {
        return 4;
    }
}
