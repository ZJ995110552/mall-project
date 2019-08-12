package com.mercury.mallproject.fastdfs.mapper;

import com.mercury.mallproject.fastdfs.domain.SysFileDetail;
import com.mercury.mallproject.fastdfs.domain.SysFileDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysFileDetailMapper {
    int countByExample(SysFileDetailExample example);

    int deleteByExample(SysFileDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysFileDetail record);

    int insertSelective(SysFileDetail record);

    List<SysFileDetail> selectByExample(SysFileDetailExample example);

    SysFileDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysFileDetail record, @Param("example") SysFileDetailExample example);

    int updateByExample(@Param("record") SysFileDetail record, @Param("example") SysFileDetailExample example);

    int updateByPrimaryKeySelective(SysFileDetail record);

    int updateByPrimaryKey(SysFileDetail record);
}