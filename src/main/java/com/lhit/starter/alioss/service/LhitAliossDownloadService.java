package com.lhit.starter.alioss.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;

import java.io.*;

public class LhitAliossDownloadService {


    /**
     * 通过流下载的方式获取到oss存储的string数据
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @return
     * @throws Exception
     */
    public String downloadString(OSSClient ossClient, String bucketName, String objectName) throws Exception {
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
        // 读取文件内容。
        BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
        String result = "";
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            result += line;
        }
        // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
        reader.close();
        return result;
    }


    /**
     * 下载oss 文件到本地
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @param localFilePath
     * @throws Exception
     */
    public void downloadFileToLocal(OSSClient ossClient, String bucketName, String objectName, String localFilePath) throws Exception {
        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(localFilePath));
    }





}
