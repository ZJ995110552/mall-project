package com.mercury.mallproject;

import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.MateData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.mercury.mallproject.fastdfs.service.api.FastdfsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
@RunWith(SpringRunner.class)
@SpringBootTest
public class FastdfsApplicationTests {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(FastdfsApplicationTests.class);
 
    File file = null;
    Set<MateData> metaDataSet = null;

    public static final String ip_home = "192.168.56.25";

    //默认文件本地文件路径
    public static final String pathname = "/Users/zhujie/Desktop/22.png";

    //组名，跟你在fastdfs配置文件中的一致
    public static final String groupName = "group2";

    //fastDFS存储文件的path，这个path路径需要你执行测试方法中上传后，获取的path粘贴过来，用于查询、删除的
    public static final String path = "M00/00/00/wKg4G11GwfyAPYjmACUSUuplvRM794_150x150.png";

    //默认文件名称，你所需要上传的图片名称
    public static final String filename = "22.png";

    //默认文件格式，后缀名,设置上传后在fastdfs存储的格式，你可以改成其它格式图片，fastdfs只支持几种常用格式的，自己百度可以查查，jpg和png都是可以的
    public static final String fileExtName = "png";

    //带组名的path
    public static final String filePath = groupName + path;

    public final static int port = 22122;

    public final static int store_port = 23000;

    public static InetSocketAddress address = new InetSocketAddress(ip_home, port);

    public static InetSocketAddress store_address = new InetSocketAddress(ip_home, store_port);

    //超时时间
    public static final int soTimeout = 550;

    //连接时间
    public static final int connectTimeout = 500;

    @Autowired
    private FastdfsService fastdfsService;
 
    @Before
    public void newFile() {
        metaDataSet = createMetaData();
        file = new File(pathname);
    }
 
    @Autowired
    private FastFileStorageClient storageClient;
 
    @Autowired
    private ThumbImageConfig thumbImageConfig;
 
    /**
     * 测试1--图片上传
     */
    @Test
    public void testUpload() throws FileNotFoundException {
        //上传图片
        StorePath storePath = fastdfsService.uploadFile(new FileInputStream(file), file.length(), fileExtName, metaDataSet);
        printlnPath(storePath);
        //group2/M00/00/00/wKg4G11GwW2AFVsiACUSUuplvRM926.png
    }
 
    /**
     * 测试2--图片上传缩略图
     */
    @Test
    public void testCrtThumbImage() throws FileNotFoundException {
        //上传图片的缩略图
        StorePath storePath = fastdfsService.uploadThumbImage(new FileInputStream(file), file.length(), fileExtName, metaDataSet);
        String fullPath = thumbImageConfig.getThumbImagePath(storePath.getFullPath());

        System.out.println("【图片缩略图带有组名的路径】:" + fullPath);
        printlnPath(storePath);
        //group2/M00/00/00/wKg4G11GwfyAPYjmACUSUuplvRM794_150x150.png
    }
 
    /**
     * 查询
     */
    @Test
    public void testQuery() {
        FileInfo fileInfo = fastdfsService.queryFileInfo(groupName, path);
        System.out.println("图片信息如下：\n" + fileInfo.getCrc32() + "\n" + new Date(fileInfo.getCreateTime()) + "\n" + fileInfo.getFileSize() + "\n" + fileInfo.getSourceIpAddr());
    }
 
    /**
     * 删除
     */
    @Test
    public void testDel() {
        fastdfsService.delFile(filePath);
    }
 
 
    /**
     * 删除(效果同上删除)
     */
    @Test
    public void testDel2() {
        fastdfsService.delFile(groupName, path);
    }
 
 
    /**
     * 下载文件
     */
    @Test
    public void downLoadFile() {

        fastdfsService.downloadFile(groupName,filePath,filename);
        // StorageDownloadCommand<String> stringStorageDownloadCommand = new StorageDownloadCommand<>(variables.groupName, variables.path, callback);
       // String fileName = commandTestBase.executeStoreCmd(stringStorageDownloadCommand);
    }
 
    /**
     * 创建元信息
     *
     * @return
     */
    private Set<MateData> createMetaData() {
        Set<MateData> metaDataSet = new HashSet<MateData>();
        metaDataSet.add(new MateData("Author", "lucifer"));
        metaDataSet.add(new MateData("CreateDate", "2018-11-11"));
        return metaDataSet;
    }
 
 
    private void printlnPath(StorePath storePath) {
        //组名
        System.out.println("【组名】:" + storePath.getGroup());
        //带组名的文件地址
        System.out.println("【带组名的文件地址】:" + storePath.getFullPath());
        //不带组名的文件地址
        System.out.println("【不带组名的文件地址】:" + storePath.getPath());
    }
 
}