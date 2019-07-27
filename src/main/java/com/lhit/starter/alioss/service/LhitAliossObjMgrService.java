package com.lhit.starter.alioss.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象管理 服务
 */
public class LhitAliossObjMgrService {


    /**
     * 判断 对象文件是不是在oss中存储
     *
     * @param ossClient
     * @param bucketName
     * @param obejctName
     * @return
     * @throws Exception
     */
    public Boolean checkFileIsExist(OSSClient ossClient, String bucketName, String obejctName) throws Exception {
        return ossClient.doesObjectExist(bucketName, obejctName);
    }

    /**
     * 判断文件是否存在。doesObjectExist还有一个参数isOnlyInOSS，如果为true则忽略302重定向或镜像；如果
     * 为false，则考虑302重定向或镜像。
     *
     * @param ossClient
     * @param bucketName
     * @param obejctName
     * @param isOnlyInOss
     * @return
     * @throws Exception
     */
    public Boolean checkFileIsExist(OSSClient ossClient, String bucketName, String obejctName, Boolean isOnlyInOss) throws Exception {
        return ossClient.doesObjectExist(bucketName, obejctName, isOnlyInOss);
    }


    /**
     * 设置文件的访问权限
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @param cannedAccessControlList
     * @throws Exception
     */
    public void setObjecAcl(OSSClient ossClient, String bucketName, String objectName, CannedAccessControlList cannedAccessControlList) throws Exception {
        ossClient.setObjectAcl(bucketName, objectName, cannedAccessControlList);
    }


    /**
     * 获取文件的访问权限
     *
     * @param ossClient
     * @param bucketName
     * @param obejctName
     * @return
     * @throws Exception
     */
    public ObjectAcl getObjcet(OSSClient ossClient, String bucketName, String obejctName) throws Exception {
        return ossClient.getObjectAcl(bucketName, obejctName);
    }

    /**
     * 获取 全部 存储对象
     *
     * @param ossClient
     * @param bucketName
     * @param maxKeys    限定此次列举文件的最大个数。默认值为100，最大值为1000。
     * @return
     * @throws Exception
     */
    public List<ObjectListing> getAllObject(OSSClient ossClient, String bucketName, Integer maxKeys) throws Exception {
        List<ObjectListing> listings = new ArrayList<ObjectListing>();
        String nextMarker = null;
        ObjectListing objectListing;
        do {
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName).withMarker(nextMarker);
            if (maxKeys != null) {
                listObjectsRequest.withMaxKeys(maxKeys);
            }
            objectListing = ossClient.listObjects(listObjectsRequest);
            listings.add(objectListing);
            nextMarker = objectListing.getNextMarker();
        } while (objectListing.isTruncated());
        return listings;
    }


    /**
     * 分页 获取 全部 存储对象
     *
     * @param ossClient
     * @param bucketName
     * @param marker     列举指定marker之后的文件。	ObjectListing 有nextMarket参数
     * @param maxKeys    限定此次列举文件的最大个数。默认值为100，最大值为1000。
     * @return
     * @throws Exception
     */
    public ObjectListing getObjectByPage(OSSClient ossClient, String bucketName, String marker, Integer maxKeys) throws Exception {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        if (marker != null) {
            listObjectsRequest.withMarker(marker);
        }
        if (maxKeys != null) {
            listObjectsRequest.withMaxKeys(maxKeys);
        }
        return ossClient.listObjects(listObjectsRequest);
    }


    /**
     * 分页获取 固定前缀的存储对象
     *
     * @param ossClient
     * @param bucketName
     * @param prefix
     * @param market
     * @param maxKeys
     * @return
     * @throws Exception
     */
    public ObjectListing getPrefixObjectByPage(OSSClient ossClient, String bucketName, String prefix, String market, Integer maxKeys) throws Exception {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        if (prefix != null) {
            listObjectsRequest.withPrefix(prefix);
        }
        if (market != null) {
            listObjectsRequest.withMarker(market);
        }
        if (maxKeys != null) {
            listObjectsRequest.withMaxKeys(maxKeys);
        }
        return ossClient.listObjects(listObjectsRequest);
    }


    /**
     * 删除文件
     *
     * @param ossClient
     * @param bucketName
     * @param objectName
     * @throws Exception
     */
    public void delObject(OSSClient ossClient, String bucketName, String objectName) throws Exception {
        // 删除文件。
        ossClient.deleteObject(bucketName, objectName);
    }


    /**
     * 批量删除文件
     *
     * @param ossClient
     * @param bucketName
     * @param objectNames
     * @return
     * @throws Exception
     */
    public DeleteObjectsResult delObject(OSSClient ossClient,String bucketName, List<String> objectNames ) throws Exception{
        return ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(objectNames));
    }

}
