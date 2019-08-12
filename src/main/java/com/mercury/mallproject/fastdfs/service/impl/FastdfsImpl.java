package com.mercury.mallproject.fastdfs.service.impl;

import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.MateData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.proto.storage.DownloadFileWriter;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.fastdfs.domain.SysFileDetail;
import com.mercury.mallproject.fastdfs.mapper.SysFileDetailMapper;
import com.mercury.mallproject.fastdfs.service.FastdfsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.Set;

@Service
public class FastdfsImpl implements FastdfsService {

    private IdGenerator idGenerator = DefaultIdGenerator.getInstance();

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private SysFileDetailMapper sysFileDetailMapper;

    @Autowired
    private ThumbImageConfig thumbImageConfig;


    @Override
    public StorePath uploadFile(InputStream inputStream, long fileLenth, String fileExtName, Set<MateData> metaDataSet) {
        return storageClient.uploadFile(inputStream, fileLenth, fileExtName, metaDataSet);
    }

    @Override
    public StorePath uploadThumbImage(InputStream inputStream, long fileLenth, String fileExtName, Set<MateData> metaDataSet) {
        return storageClient.uploadImageAndCrtThumbImage(inputStream, fileLenth, fileExtName, metaDataSet);
    }

    @Override
    public FileInfo queryFileInfo(String groupName, String filePath) {
        return storageClient.queryFileInfo(groupName, filePath);
    }

    @Override
    public void delFile(Long fileDetailId) {
        SysFileDetail sysFileDetail = sysFileDetailMapper.selectByPrimaryKey(fileDetailId);
        storageClient.deleteFile(sysFileDetail.getServerGroup(),StringUtils.substringAfter(sysFileDetail.getServerRootDir(),sysFileDetail.getServerGroup()+File.separator));
        sysFileDetailMapper.deleteByPrimaryKey(fileDetailId);
    }

    @Override
    public void delFile(String filePath) {
        storageClient.deleteFile(filePath);
    }

    @Override
    public void delFile(String groupName, String filePath) {
        storageClient.deleteFile(groupName, filePath);
    }

    @Override
    public String downloadFile(String groupName, String filePath, String fileName) {
        DownloadFileWriter callback = new DownloadFileWriter(fileName);
        return storageClient.downloadFile(groupName, filePath, callback);
    }

    @Override
    public StorePath uploadFileAndUpdateFileDetail(InputStream inputStream, long fileLenth, String fileExtName, Set<MateData> metaDataSet) {

        StorePath storePath = storageClient.uploadFile(inputStream, fileLenth, fileExtName, metaDataSet);
        SysFileDetail sysFileDetail = new SysFileDetail();
        sysFileDetail.setId(idGenerator.generateId());
        sysFileDetail.setLogicalName(sysFileDetail.getId().toString());
        sysFileDetail.setCreateTime(new Date());
//        sysFileDetail.setDocServerAddress();
//        sysFileDetail.setDocServerId();
//        sysFileDetail.setFileCategory(); // 枚举类型:缩略图/原图/文档/压缩包

        sysFileDetail.setPhysicalName(StringUtils.substringAfterLast(storePath.getFullPath(), File.separator));
        sysFileDetail.setExtentionName(fileExtName);
        sysFileDetail.setServerGroup(storePath.getGroup());
        sysFileDetail.setServerRootDir(storePath.getFullPath());

        FileInfo fileInfo = queryFileInfo(storePath.getGroup(), storePath.getPath());
        sysFileDetail.setDocServerAddress(fileInfo.getSourceIpAddr());
        sysFileDetail.setFileSize(fileInfo.getFileSize());

        sysFileDetailMapper.insert(sysFileDetail);

        return storePath;
    }

    @Override
    public StorePath uploadThumbImageAndUpdateFileDetail(InputStream inputStream, long fileLenth, String fileExtName, Set<MateData> metaDataSet) {

        StorePath storePath = storageClient.uploadImageAndCrtThumbImage(inputStream, fileLenth, fileExtName, metaDataSet);
        SysFileDetail sysFileDetail = new SysFileDetail();
        sysFileDetail.setId(idGenerator.generateId());
        sysFileDetail.setLogicalName(sysFileDetail.getId().toString());
        sysFileDetail.setCreateTime(new Date());
//        sysFileDetail.setDocServerAddress();
//        sysFileDetail.setDocServerId();
//        sysFileDetail.setFileCategory(); // 枚举类型:缩略图/原图/文档/压缩包 暂未区分

        sysFileDetail.setPhysicalName(StringUtils.substringAfterLast(storePath.getFullPath(), File.separator));
        sysFileDetail.setExtentionName(fileExtName);
        sysFileDetail.setServerGroup(storePath.getGroup());
        sysFileDetail.setServerRootDir(storePath.getFullPath());

        sysFileDetailMapper.insert(sysFileDetail);

        return storePath;
    }

    @Override
    public FileInfo queryFileInfoByFileDetailId(Long fileDetailId) {
        SysFileDetail sysFileDetail = sysFileDetailMapper.selectByPrimaryKey(fileDetailId);
        // 若delFlag为Y则提示已删除，obj为null则提示不存在，借用MyException
        return queryFileInfo(sysFileDetail.getServerGroup(), StringUtils.substringAfter(sysFileDetail.getServerRootDir(),sysFileDetail.getServerGroup()+File.separator));
    }

    @Override
    public void delFileAndUpdateFileDetailByFileDetailId(Long fileDetailId) {
        SysFileDetail sysFileDetail = sysFileDetailMapper.selectByPrimaryKey(fileDetailId);
        // 若delFlag为Y则提示已删除，obj为null则提示不存在，借用MyException
        delFile(sysFileDetail.getServerRootDir());
    }

    @Override
    public String downloadFileLByFileDetailId(Long fileDetailId) {
        SysFileDetail sysFileDetail = sysFileDetailMapper.selectByPrimaryKey(fileDetailId);
        // 若delFlag为Y则提示已删除，obj为null则提示不存在，借用MyException
        return downloadFile(sysFileDetail.getServerGroup(),sysFileDetail.getServerRootDir(),sysFileDetail.getPhysicalName());
    }


}
