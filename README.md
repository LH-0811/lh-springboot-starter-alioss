# lh-springboot-starter-alioss

作者从业时间短。希望有问题可以尽量提出。帮助进步。
阿里oss springboot starter 集成,官方demo的copy 目前可以用于简单的文件上传 下载 管理。
oss 的用途<br/>
1.上传文件到oss 免去自己构建文件服务器（这个可以凑合用）
2.把自己文件服务器中的内容备份到oss 服务。容灾和和数据保护。（目前这个还没有实现）


# 1.目录结构
java<br/>
<br/>
-com.lhit.starter.alioss<br/>
  --autoconf (自动装配)<br/>
    ----LhitAliossAutoConfiguration(自动装配类 在spring.factories文件中指定扫描)<br/>
    <br/>
  --properties（对应application.properties/yml文件中的配置信息）<br/>
    ----LhitAliossProperties(配置信息对象) <br/>
    <br/>
  --service (主要实现)<br/>
    ----LhitAliossBucketService(bucket 存储空间管理服务)<br/>
    ----LhitAliossClientService(oss client 管理服务，提供ossclient的获取)<br/>
    ----LhitAliossDownloadService(对象下载 服务)<br/>
    ----LhitAliossObjMgrService(对象管理管理 服务)<br/>
    ----LhitAliossUploadService(对象上传管理 服务)<br/>
    <br/><br/>
resources<br/>
<br/>
META-INF/spring.factories (指定springboot扫描的自动装配类)
<br/>

# 2.功能实现

### LhitAliossBucketService 存储空间管理
###### 1.创建存储空间
###### 2.创建存储空间  自定义 存储空间的权限(默认私有) 空间的存储类型(默认标准)
###### 3.列举所有的存储空间
###### 4.获取指定个数的存储空间 默认值为100，最大值为1000。
###### 5.根据前缀搜索存储空间
###### 6.获取指定存储空间之后的存储空间
###### 7.判断存储空间是否存在
###### 8.设置存储空间的访问权限
###### 9.获取存储空间的访问权限
###### 10.获取存 储空间的地域（称为Region或Location）：
###### 11.获取存储空间的详细信息
###### 12.删除存储空间
<br/>

### LhitAliossClientService OSS客户端服务<br/>
###### 1. 获取oss客户端
<br/>

### LhitAliossDownloadService 对象下载服务

###### 1.通过流下载的方式获取到oss存储的string数据

###### 2.下载oss 对象到本地

<br/>

### LhitAliossObjMgrService 对象管理服务

###### 1.判断对象是不是在oss中存储

###### 2.判断对象是否存在。doesObjectExist还有一个参数isOnlyInOSS，如果为true则忽略302重定向或镜像；如果为false，则考虑302重定向或镜像。

###### 3.设置对象的访问权限

###### 4.获取对象的访问权限

###### 5.获取全部存储对象

###### 6.分页获取全部存储对象

###### 7.分页获取固定前缀的存储对象

###### 8.删除对象

###### 9.批量删除对象
<br/>

### LhitAliossUploadService 对象上传服务

###### 1.上传字符串对象

###### 2.上传 byte数组

###### 3.上传网络流数据

###### 4.上传本地文件

###### 5.上传文件流

<br/>
# 关于使用<br/>

###### clone下源码 mvn install 到自己的mvn仓库，然后在springboot项目中引用。



















