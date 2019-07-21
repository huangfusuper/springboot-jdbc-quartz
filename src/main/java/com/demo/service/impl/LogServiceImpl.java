package com.demo.service.impl;

import com.demo.dao.LogDao;
import com.demo.dataobject.LogEntity;
import com.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 皇甫
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public void saveLogs(List<LogEntity> logs) {
        logDao.saveAll(logs);
    }
}
