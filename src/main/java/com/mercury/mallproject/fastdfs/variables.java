package com.mercury.mallproject.fastdfs;
 
import java.net.InetSocketAddress;
 
/**
 * @author: Lucifer
 * @create: 2018-11-11 04:00
 * @description: 定义常用的变量
 **/
public class variables {
 
    //安装fastdfs的虚拟机的ip
    public static final String ip_home = "192.168.56.25";
 
    //默认文件本地文件路径
    public static final String pathname = "/Users/zhujie/Desktop/2.png";
 
    //组名，跟你在fastdfs配置文件中的一致
    public static final String groupName = "group1";
 
    //fastDFS存储文件的path，这个path路径需要你执行测试方法中上传后，获取的path粘贴过来，用于查询、删除的
    public static final String path = "M00/00/00/wKg7g1vnC0uAF33PAADWMguR3lU360.png";
 
    //默认文件名称，你所需要上传的图片名称
    public static final String filename = "2.png";
 
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
 
 
}