package com.mercury.mallproject.log.mapper;

import com.mercury.mallproject.log.domain.SysLogOperation;
import com.mercury.mallproject.log.domain.SysLogOperationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLogOperationMapper {
    int countByExample(SysLogOperationExample example);

    int deleteByExample(SysLogOperationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLogOperation record);

    int insertSelective(SysLogOperation record);

    List<SysLogOperation> selectByExampleWithBLOBs(SysLogOperationExample example);

    List<SysLogOperation> selectByExample(SysLogOperationExample example);

    SysLogOperation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLogOperation record, @Param("example") SysLogOperationExample example);

    int updateByExampleWithBLOBs(@Param("record") SysLogOperation record, @Param("example") SysLogOperationExample example);

    int updateByExample(@Param("record") SysLogOperation record, @Param("example") SysLogOperationExample example);

    int updateByPrimaryKeySelective(SysLogOperation record);

    int updateByPrimaryKeyWithBLOBs(SysLogOperation record);

    int updateByPrimaryKey(SysLogOperation record);
}