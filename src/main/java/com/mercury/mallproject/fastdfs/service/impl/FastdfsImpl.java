package com.mercury.mallproject.fastdfs.service.impl;

import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.MateData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.proto.storage.DownloadFileWriter;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.mercury.mallproject.fastdfs.service.api.FastdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Set;

@Service
public class FastdfsImpl implements FastdfsService {

    @Autowired
    private FastFileStorageClient storageClient;

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


}
