package com.lhit.starter.alioss.imagedeal.rule;

import com.lhit.starter.alioss.imagedeal.param.ImageTailorCrop;
import com.lhit.starter.alioss.imagedeal.param.ImageTailorIndexCrop;

public class AliossImageTailorRule implements AliossImageRule {

    /**
     * 从图片取出的圆形区域的半径
     * 半径 r 不能超过原图的最小边的一半。如果超过，则圆的大小仍然是原圆的最大内切圆。
     */
    private Integer  circle;


    /**
     * 您可以把图片保存成圆角矩形，并指定圆角的大小 。
     * 将图片切出圆角，指定圆角的半径。
     * [1, 4096] 生成的最大圆角的半径不能超过原图的最小边的一半。
     */
    private Integer roundedCorners;

    /**
     * 可以指定裁剪的起始点以及裁剪的宽高来决定图片裁剪的区域。
     */
    private ImageTailorCrop imageTailorCrop;


    /**
     * 将图片分成 x，y 轴，按指定长度 (length) 切割，指定索引 (index)，取出指定的区域。
     */
    private ImageTailorIndexCrop imageTailorIndexCrop;


    /**
     * 构建参数
     *
     * @return
     */
    public String buildParam() {
        if (circle != null){
            return "circle,r_"+ circle;
        }else if (roundedCorners !=null ){
            return "rounded-corners,r_"+roundedCorners;
        }else if (imageTailorCrop != null){
            return "crop,"+imageTailorCrop.buildParam();
        }else if (imageTailorIndexCrop != null){
            return "indexcrop,"+imageTailorIndexCrop.buildParam();
        }
        return "";
    }



    private AliossImageTailorRule() {
    }

    /**
     * 构建内切圆
     *
     * @param circle
     * @return
     */
    public static AliossImageTailorRule withCircle(Integer circle) {
        AliossImageTailorRule aliossImageTailorRule = new AliossImageTailorRule();
        aliossImageTailorRule.circle = circle;
        return aliossImageTailorRule;
    }

    /**
     * 切圆角
     *
     * @param roundedCorners
     * @return
     */
    public static AliossImageTailorRule withRoundedCorners(Integer roundedCorners){
        AliossImageTailorRule aliossImageTailorRule = new AliossImageTailorRule();
        aliossImageTailorRule.roundedCorners = roundedCorners;
        return aliossImageTailorRule;
    }


    /**
     * 裁剪
     *
     * @param imageTailorCrop
     * @return
     */
    public static AliossImageTailorRule withTailorCrop(ImageTailorCrop imageTailorCrop){
        AliossImageTailorRule aliossImageTailorRule = new AliossImageTailorRule();
        aliossImageTailorRule.imageTailorCrop = imageTailorCrop;
        return aliossImageTailorRule;
    }


    /**
     * 切断
     *
     * @param indexCrop
     * @return
     */
    public static AliossImageTailorRule withTailorIndexCrop(ImageTailorIndexCrop indexCrop){
        AliossImageTailorRule aliossImageTailorRule = new AliossImageTailorRule();
        aliossImageTailorRule.imageTailorIndexCrop = indexCrop;
        return aliossImageTailorRule;
    }




    public Integer getOrder() {
        return 3;
    }
}
