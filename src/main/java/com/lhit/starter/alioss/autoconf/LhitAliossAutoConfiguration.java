package com.lhit.starter.alioss.autoconf;


import com.lhit.starter.alioss.properties.LhitAliossProperties;
import com.lhit.starter.alioss.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解详解
 * 1. @Configuration：说明该类是配置类，等价于xml中的beans
 * 2. @EnableConfigurationProperties :开启属性注入
 * 3. @ConditionalOnClass ：条件注解 当类路径下有指定的类的条件（即存在该配置类）
 * 4. @ConditionalOnProperty(prefix=”lhit.aliyun.oss”,value=”enabled”,matchIfMissing=true)：条件注解（存在配置前缀lhit.aliyun.oss,开启,缺失检查)存在对应配置信息时初始化该配置类
 */
@Configuration
@EnableConfigurationProperties(LhitAliossProperties.class)
@ConditionalOnClass(LhitAliossClientService.class)
@ConditionalOnProperty(prefix="lhit.aliyun.oss",value="enabled",matchIfMissing=true)
public class LhitAliossAutoConfiguration {


    @Autowired
    private LhitAliossProperties lhitAliossProperties;


    /**
     * @ConditionalOnMissingBean(HelloService.class)
     * 当SpringIoc容器内不存在指定Bean的条件
     * （缺失LhitAliossService实体bean时，初始化LhitAliossService）
     * 并添加到SpringIoc中
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public LhitAliossClientService lhitAliossService(){
        return new LhitAliossClientService(lhitAliossProperties);
    }


    @Bean
    @ConditionalOnMissingBean
    public LhitAliossBucketService lhitAliossBucketService(){
        return new LhitAliossBucketService();
    }

    @Bean
    @ConditionalOnMissingBean
    public LhitAliossUploadService lhitAliossUploadService(){
        return new LhitAliossUploadService();
    }


    @Bean
    @ConditionalOnMissingBean
    public LhitAliossDownloadService lhitAliossDownloadService(){
        return new LhitAliossDownloadService();
    }

    @Bean
    @ConditionalOnMissingBean
    public LhitAliossFileMgrService lhitAliossFileMgrService(){
        return new LhitAliossFileMgrService();
    }
}
