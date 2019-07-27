package com.lhit.starter.alioss.imagedeal.rule;

import com.lhit.starter.alioss.imagedeal.enum_.AliossImageInterlace;
import com.lhit.starter.alioss.imagedeal.enum_.AliossImageType;

public class AliossImageFormatRule implements AliossImageRule {



    private AliossImageInterlace aliossImageInterlace;

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
