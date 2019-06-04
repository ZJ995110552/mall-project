package com.mercury.mallproject.repository.mapper;

import com.mercury.mallproject.domain.SysLogOperation;
import com.mercury.mallproject.domain.SysLogOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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