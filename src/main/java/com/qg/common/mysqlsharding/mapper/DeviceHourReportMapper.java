package com.qg.common.mysqlsharding.mapper;


import com.qg.common.mysqlsharding.anno.Sharding;
import com.qg.common.mysqlsharding.model.DeviceHourReport;
import com.qg.common.mysqlsharding.model.DeviceHourReportExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
@Sharding
@Deprecated
public interface DeviceHourReportMapper {
    long countByExample(DeviceHourReportExample example);

    int deleteByExample(DeviceHourReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceHourReport record);

    int insertSelective(DeviceHourReport record);

    List<DeviceHourReport> selectByExample(DeviceHourReportExample example);

    DeviceHourReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceHourReport record, @Param("example") DeviceHourReportExample example);

    int updateByExample(@Param("record") DeviceHourReport record, @Param("example") DeviceHourReportExample example);

    int updateByPrimaryKeySelective(DeviceHourReport record);

    int updateByPrimaryKey(DeviceHourReport record);

    int batchInsert(@Param("list") List<DeviceHourReport> list);

    int batchInsertSelective(@Param("list") List<DeviceHourReport> list, @Param("selective") DeviceHourReport.Column... selective);

}