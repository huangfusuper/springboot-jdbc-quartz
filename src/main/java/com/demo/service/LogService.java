package com.demo.service;

import com.demo.dataobject.LogEntity;

import java.util.List;

/**
 * @author 皇甫
 */
public interface LogService {
    /**
     * 保存日志信息
     * @param logs
     */
    void saveLogs(List<LogEntity> logs);
}
