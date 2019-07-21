package com.lhit.starter.alioss.service;

import com.aliyun.oss.OSSClient;
import com.lhit.starter.alioss.properties.LhitAliossProperties;

public class LhitAliossClientService {

    private LhitAliossProperties lhitAliossProperties;

    public LhitAliossClientService(LhitAliossProperties lhitAliossProperties) {
        this.lhitAliossProperties = lhitAliossProperties;
    }

    public OSSClient getOssClient(){
        return new OSSClient(lhitAliossProperties.getEndpoint(), lhitAliossProperties.getKeyId(), lhitAliossProperties.getKeySecret());
    }
}
