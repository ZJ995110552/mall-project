package com.mercury.mallproject.fastdfs.service;

import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.MateData;
import com.github.tobato.fastdfs.domain.StorePath;

import java.io.InputStream;
import java.util.Set;

public interface FastdfsService {

    StorePath uploadFile(InputStream inputStream, long fileLenth, String fileExtName, Set<MateData> metaDataSet);

    StorePath uploadThumbImage(InputStream inputStream, long fileLenth, String fileExtName, Set<MateData> metaDataSet);

    FileInfo queryFileInfo(String groupName,String filePath);

    void delFile(Long fileDetailId);

    void delFile(String filePath);

    void delFile(String groupName,String filePath);

    String downloadFile(String groupName,String filePath,String fileName);

    StorePath uploadFileAndUpdateFileDetail(InputStream inputStream, long fileLenth, String fileExtName, Set<MateData> metaDataSet);

    StorePath uploadThumbImageAndUpdateFileDetail(InputStream inputStream, long fileLenth, String fileExtName, Set<MateData> metaDataSet);

    FileInfo queryFileInfoByFileDetailId(Long fileDetailId);

    void delFileAndUpdateFileDetailByFileDetailId(Long fileDetailId);

    String downloadFileLByFileDetailId(Long fileDetailId);
}
