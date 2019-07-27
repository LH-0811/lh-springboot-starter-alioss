package com.lhit.starter.alioss.service;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.common.utils.IOUtils;
import com.aliyun.oss.model.GenericResult;
import com.aliyun.oss.model.ProcessObjectRequest;
import com.lhit.starter.alioss.imagedeal.rule.AliossImageResizeRule;
import com.lhit.starter.alioss.common.HttpClientUtil;
import com.lhit.starter.alioss.imagedeal.rule.AliossImageRule;
import com.lhit.starter.alioss.properties.LhitAliossProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 图片管理相关 服务
 */
public class LhitAliossImgMgrService {


    private LhitAliossProperties aliossProperties;

    public LhitAliossImgMgrService(LhitAliossProperties lhitAliossProperties) {
        this.aliossProperties = lhitAliossProperties;
    }


    /**
     * 获取图片主色调
     *
     * @param bucketName
     * @param objectName
     * @return
     * @throws Exception
     */
    public String getImageMainColor(String bucketName, String objectName) throws Exception {
        return "http://" + bucketName + "." + aliossProperties.getEndpoint() + "/" + objectName + "?x-oss-process=image/average-hue";
    }


    /**
     * 根据缩略图规则 获取到缩略图链接
     *
     * @param bucketName
     * @param objectName
     * @param rules
     * @return
     * @throws Exception
     */
    public String imageThumbnail(String bucketName, String objectName, List<AliossImageRule> rules) throws Exception {
        if (rules == null || rules.size() == 0) {
            return "http://" + bucketName + "." + aliossProperties.getEndpoint() + "/" + objectName;
        }
        List<AliossImageRule> collect = rules.stream().sorted(Comparator.comparing(AliossImageRule::getOrder)).collect(Collectors.toList());
        String param = "";
        for (int i = 0; i < collect.size(); i++) {
            param += "/" + collect.get(i).buildParam();
        }
        return "http://" + bucketName + "." + aliossProperties.getEndpoint() + "/" + objectName + "?x-oss-process=image" + param;
    }

    /**
     * 持久化修改图片
     *
     * @param ossClient
     * @param bucketName
     * @param rules
     * @throws Exception
     */
    public String imagePersistentUpdate(OSSClient ossClient, String bucketName,String sourceImage, String targetImage, List<AliossImageRule> rules) throws Exception {
        StringBuilder sbStyle = new StringBuilder();
        Formatter styleFormatter = new Formatter(sbStyle);
        StringBuilder stringBuilder = new StringBuilder("image");
        for (AliossImageRule rule : rules) {
            stringBuilder.append("/"+rule.buildParam());
        }
        styleFormatter.format("%s|sys/saveas,o_%s,b_%s", stringBuilder.toString(),
                BinaryUtil.toBase64String(targetImage.getBytes()),
                BinaryUtil.toBase64String(bucketName.getBytes()));
        System.out.println(sbStyle.toString());
        ProcessObjectRequest request = new ProcessObjectRequest(bucketName, sourceImage, sbStyle.toString());
        GenericResult processResult = ossClient.processObject(request);
        String json = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
        processResult.getResponse().getContent().close();
        System.out.println(json);
        return "http://" + bucketName + "." + aliossProperties.getEndpoint() + "/" + targetImage ;
    }


}
