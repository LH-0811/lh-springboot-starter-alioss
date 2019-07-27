package com.lhit.starter.alioss.imagedeal.rule;

import com.lhit.starter.alioss.imagedeal.enum_.AliossImageInterlace;
import com.lhit.starter.alioss.imagedeal.enum_.AliossImageType;

public class AliossImageFormatRule implements AliossImageRule {


    /**
     * 图片格式为 jpg 时有两种呈现方式：
     *
     * 自上而下的扫描式
     * 先模糊后逐渐清晰（在网络环境比较差时明显）
     * 默认保存为第一种，如果要指定先模糊后清晰的呈现方式，请使用渐进显示参数。
     *
     * 1 表示保存成渐进显示的 jpg 格式。
     * 0 表示保存成普通的 jpg 格式。
     *
     * 取值
     * [0, 1]
     */
    private AliossImageInterlace aliossImageInterlace;

    /**
     * 图片存储格式
     *
     * jpg	将原图保存成 jpg 格式，如果原图是 png、webp、bmp 存在透明通道，默认会把透明填充成白色。
     * png	将原图保存成 png 格式。
     * webp	将原图保存成 webp 格式。
     * bmp	将原图保存成 bmp 格式。
     * gif	将 gif 格式保存成 gif 格式，非 gif 格式是按原图格式保存。
     * tiff	将原图保存成 tiff 格式。
     *
     */
    private AliossImageType aliossImageType;




    public AliossImageFormatRule whitInterlace(AliossImageInterlace aliossImageInterlace){
        this.aliossImageInterlace = aliossImageInterlace;
        return this;
    }

    public AliossImageFormatRule whitImageType(AliossImageType aliossImageType){
        this.aliossImageType = aliossImageType;
        return this;
    }



    public String buildParam() {

        if (aliossImageInterlace != null ){
            return  "format,jpg/interlace,"+aliossImageInterlace.getInterlace();
        }
        if (aliossImageType != null){
            return  "format,"+aliossImageType.getType();
        }

        return "";
    }





    public Integer getOrder() {
        return 100;
    }


    public AliossImageInterlace getAliossImageInterlace() {
        return aliossImageInterlace;
    }

    public void setAliossImageInterlace(AliossImageInterlace aliossImageInterlace) {
        this.aliossImageInterlace = aliossImageInterlace;
    }

    public AliossImageType getAliossImageType() {
        return aliossImageType;
    }

    public void setAliossImageType(AliossImageType aliossImageType) {
        this.aliossImageType = aliossImageType;
    }
}
