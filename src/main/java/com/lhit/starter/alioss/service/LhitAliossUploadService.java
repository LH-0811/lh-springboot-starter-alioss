package com.lhit.starter.alioss.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class LhitAliossUploadService {


    /**
     * 上传字符串
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @param uploadStr
     * @throws Exception
     */
    public PutObjectResult uploadString(OSSClient ossClient, String bucketName, String objectName, String uploadStr) throws Exception {
        // 上传字符串。
        return ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(uploadStr.getBytes()));
    }


    /**
     * 上传 byte数组
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @param bytes
     * @return
     * @throws Exception
     */
    public PutObjectResult uploadByteArr(OSSClient ossClient, String bucketName, String objectName, byte[] bytes) throws Exception {
        return ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(bytes));
    }


    /**
     * 删除网络流数据
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @param urlStr
     * @return
     * @throws Exception
     */
    public PutObjectResult uploadNetworkStream(OSSClient ossClient, String bucketName, String objectName, String urlStr) throws Exception {
        InputStream inputStream = new URL(urlStr).openStream();
        return ossClient.putObject(bucketName, objectName, inputStream);
    }


    /**
     * 上传本地文件
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @param localFileUrl
     * @return
     * @throws Exception
     */
    public PutObjectResult uploadLocationFile(OSSClient ossClient, String bucketName, String objectName, String localFileUrl) throws Exception {
        return ossClient.putObject(bucketName, objectName, new File(localFileUrl));
    }


    /**
     * 上传文件流
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @param inputStream
     * @return
     * @throws Exception
     */
    public PutObjectResult uploadFileStream(OSSClient ossClient, String bucketName, String objectName,InputStream inputStream) throws Exception {
        // 上传文件流。
        return ossClient.putObject(bucketName,objectName, inputStream);
    }

}
