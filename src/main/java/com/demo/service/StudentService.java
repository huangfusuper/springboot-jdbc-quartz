package com.demo.service;

import com.demo.dataobject.StudentEntity;

import java.util.List;

/**
 * @author 皇甫
 */
public interface StudentService {
    /**
     * 循环插入数据
     * @param studentEntities
     */
    void saveStudents(List<StudentEntity> studentEntities);
}
