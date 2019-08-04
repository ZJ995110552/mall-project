package com.mercury.mallproject.fastdfs.conf;

import com.github.tobato.fastdfs.domain.MateData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FileMateDataInfo {
    private static Set<MateData> getDefaultFileMateDataInfo(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Set<MateData> metaDataSet = new HashSet<MateData>();
        metaDataSet.add(new MateData("Author", "Z"));
        metaDataSet.add(new MateData("CreateDate", simpleDateFormat.format(new Date())));
        return metaDataSet;
    }
}
