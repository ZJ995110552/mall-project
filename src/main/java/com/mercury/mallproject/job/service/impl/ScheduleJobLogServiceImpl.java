package com.mercury.mallproject.job.service.impl;

import com.mercury.mallproject.job.entity.ScheduleJobLogEntity;
import com.mercury.mallproject.job.repository.mapper.ScheduleJobLogDao;
import com.mercury.mallproject.job.service.api.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {
    @Autowired
    private ScheduleJobLogDao scheduleJobLogDao;

    @Override
    public ScheduleJobLogEntity queryObject(Long jobId) {
        return scheduleJobLogDao.queryObject(jobId);
    }

    @Override
    public List<ScheduleJobLogEntity> queryList(Map<String, Object> map) {
        return scheduleJobLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return scheduleJobLogDao.queryTotal(map);
    }

    @Override
    public void save(ScheduleJobLogEntity log) {
        scheduleJobLogDao.save(log);
    }

}
