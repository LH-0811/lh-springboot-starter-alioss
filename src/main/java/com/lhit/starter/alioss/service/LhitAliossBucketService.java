package com.lhit.starter.alioss.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;

import java.util.ArrayList;
import java.util.List;

public class LhitAliossBucketService {

    /**
     * 创建存储空间
     *
     * @param ossClient
     * @param bucketName
     */
    public void createBucket(OSSClient ossClient, String bucketName) throws Exception {
        // 新建存储空间默认为标准存储类型，私有权限。
        ossClient.createBucket(bucketName);
    }


    /**
     * 创建存储空间  自定义 存储空间的权限(默认私有) 空间的存储类型(默认标准)
     *
     * @param ossClient
     * @param bucketName
     * @param cannedAccessControlList
     * @param storageClass
     * @throws Exception
     */
    public void createBucket(OSSClient ossClient, String bucketName, CannedAccessControlList cannedAccessControlList, StorageClass storageClass) throws Exception {
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
        // 设置存储空间的权限为公共读，默认是私有。
        createBucketRequest.setCannedACL(cannedAccessControlList);
        // 设置存储空间的存储类型为低频访问类型，默认是标准类型。
        createBucketRequest.setStorageClass(storageClass);
        ossClient.createBucket(createBucketRequest);
    }


    /**
     * 列举所有的存储空间
     *
     * @param ossClient
     * @return
     */
    public List<BucketList> queryAllBucket(OSSClient ossClient,Integer maxKeys) throws Exception {
        List<BucketList> bucketLists = new ArrayList<BucketList>();
        // 列举存储空间。
        String nextMarket = null;
        BucketList bucketList;
        do {
            ListBucketsRequest listBucketsRequest = new ListBucketsRequest().withMarker(nextMarket);
            if (maxKeys != null){
                listBucketsRequest.withMaxKeys(maxKeys);
            }
            bucketList = ossClient.listBuckets(listBucketsRequest);
            bucketLists.add(bucketList);
        }while (bucketList.isTruncated());
        return bucketLists;
    }


    /**
     * 获取指定个数的存储空间 默认值为100，最大值为1000。
     *
     * @param ossClient
     * @param maxKeys
     * @return
     * @throws Exception
     */
    public BucketList queryBucketList(OSSClient ossClient, Integer maxKeys) throws Exception {
        ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
        // 限定此次列举存储空间的个数为500。默认值为100，最大值为1000。
        if (maxKeys != null) {
            listBucketsRequest.setMaxKeys(maxKeys);
        }
        BucketList bucketList = ossClient.listBuckets(listBucketsRequest);
        return bucketList;
    }

    /**
     * 根据前缀搜索存储空间
     *
     * @param ossClient
     * @param prefix
     * @return
     * @throws Exception
     */
    public BucketList queryBucketByPrefix(OSSClient ossClient, String prefix, Integer maxKeys) throws Exception {
        ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
        listBucketsRequest.setPrefix(prefix);
        if (maxKeys != null) {
            listBucketsRequest.setMaxKeys(maxKeys);
        }
        BucketList bucketList = ossClient.listBuckets(listBucketsRequest);
        return bucketList;
    }


    /**
     * 获取指定market之后的存储空间
     *
     * @param ossClient
     * @param marker
     * @return
     * @throws Exception
     */
    public BucketList queryBucketAfterMarket(OSSClient ossClient, String marker, Integer maxKeys) throws Exception {
        ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
        // 列举指定marker之后的存储空间。
        listBucketsRequest.setMarker(marker);
        if (maxKeys != null) {
            listBucketsRequest.setMaxKeys(maxKeys);
        }
        BucketList bucketList = ossClient.listBuckets(listBucketsRequest);
        return bucketList;
    }


    /**
     * 判断存储空间是否存在
     *
     * @param ossClient
     * @param bucketName
     * @return
     * @throws Exception
     */
    public Boolean checkBucketExist(OSSClient ossClient, String bucketName) throws Exception {
        return ossClient.doesBucketExist(bucketName);
    }


    /**
     * 设置存储空间的访问权限
     *
     * @param ossClient
     * @param bucketName
     * @param controlList
     * @throws Exception
     */
    public void setAccessControlForBucket(OSSClient ossClient, String bucketName, CannedAccessControlList controlList) throws Exception {
        ossClient.setBucketAcl(bucketName, controlList);
    }


    /**
     * 获取存储空间的访问权限
     *
     * @param ossClient
     * @param bucketName
     * @return
     * @throws Exception
     */
    public AccessControlList getBucketAccessControl(OSSClient ossClient, String bucketName) throws Exception {
        return ossClient.getBucketAcl(bucketName);
    }


    /**
     * 获取存 储空间的地域（称为Region或Location）：
     * @param ossClient
     * @param bucketName
     * @return
     * @throws Exception
     */
    public String getRegionForBucket(OSSClient ossClient, String bucketName) throws Exception {
        return ossClient.getBucketLocation(bucketName);
    }


    /**
     * 获取存储空间的详细信息
     *
     * @param ossClient
     * @param bucketName
     * @return
     * @throws Exception
     */
    public BucketInfo getBucketInfoForBucket(OSSClient ossClient ,String bucketName ) throws Exception{
        return ossClient.getBucketInfo(bucketName);
    }


    /**
     * 删除存储空间
     *
     * 要删除分片上传产生的碎片，
     * 首先使用Bucket.ListMultipartUploads列举出所有碎片，
     * 然后使用Bucket.AbortMultipartUpload删除这些碎片
     *
     *
     * @param ossClient
     * @param bucketName
     * @throws Exception
     */
    public void  deleteBucket(OSSClient ossClient,String bucketName) throws Exception{
        BucketInfo bucketInfo = getBucketInfoForBucket(ossClient, bucketName);
        Bucket bucket = bucketInfo.getBucket();
        // 删除存储空间。
        ossClient.deleteBucket(bucketName);
    }
}
