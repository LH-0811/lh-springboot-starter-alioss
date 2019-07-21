package com.lhit.starter.alioss.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *  配置文件映射实体类
 *  备注：
 *   1.@ConfigurationProperties：将application.properties配置文件中的
 *     符合规则的配置参数映射到实体类中
 */
@ConfigurationProperties(prefix="lhit.aliyun.oss")
public class LhitAliossProperties {

    private String keyId;

    private String keySecret;

    private String endpoint = "oss-cn-qingdao.aliyuncs.com";

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeySecret() {
        return keySecret;
    }

    public void setKeySecret(String keySecret) {
        this.keySecret = keySecret;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
